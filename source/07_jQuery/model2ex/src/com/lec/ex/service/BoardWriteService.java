package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파일첨부 로직 + 파라미터들 받아 DB에 join
		String path = request.getRealPath("fileBoardUp");
		int maxSize = 1024 * 1024 * 10; // 최대업로드 사이즈는 10M
		MultipartRequest mRequest = null;
		String ffileName = "";
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			ffileName = mRequest.getFilesystemName(param);
			HttpSession session = request.getSession();
			MemberDto member = (MemberDto) session.getAttribute("member");
			if (member != null) {
				String mid = member.getMid();
				String ftitle = mRequest.getParameter("ftitle");
				String fcontent = mRequest.getParameter("fcontent");
				String fip = request.getRemoteAddr();
				BoardDao bDao = BoardDao.getInstance();
				BoardDto bDto = new BoardDto(0, mid, null, ftitle, fcontent, ffileName, null, 0, 0, 0, 0, fip);
				int result = bDao.insertBoard(bDto);
				if (result == BoardDao.SUCCESS) {
					request.setAttribute("boaredResult", "글쓰기 성공");
				} else {
					request.setAttribute("boaredResult", "글쓰기 실패");
				}
			} else {
				request.setAttribute("boaredResult", "글을 쓰고 싶으면 로그인 하세요");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("boaredResult", "글쓰기 실패");
		}
		// 서버에 올라간 fileboardUp 파일을 소스폴더에 filecopy
		if (ffileName != null) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + ffileName);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro/source/07_jQuery/model2ex/WebContent/fileBoardUp/" + ffileName);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int nByteCnt = is.read(bs);
					if (nByteCnt == -1)
						break;
					os.write(bs, 0, nByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} // try
		} // 파일 복사 if
	}
}
