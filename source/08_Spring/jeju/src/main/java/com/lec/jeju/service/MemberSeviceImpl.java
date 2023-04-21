package com.lec.jeju.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.jeju.dao.MemberDao;
import com.lec.jeju.vo.Member;

@Service
public class MemberSeviceImpl implements MemberSerivce {
	@Autowired
	private MemberDao memberDao;
	String backupPath = "D:/webPro/source/08_Spring/jeju/src/main/webapp/memberPhotoUp/";
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession, MultipartHttpServletRequest mRequest) {
		// mRequest에 들어온 파일을 서버에 저장 -> 소스폴더로 복사
		String uploadPath = mRequest.getRealPath("memberPhotoUp/");
		Iterator<String> params = mRequest.getFileNames();
		String mphoto = new String();
		int idx = 0;
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부 된 파일객체 생성.
			mphoto = mFile.getOriginalFilename(); // 업로드한 파일이름
			if (mphoto != null && !mphoto.equals("")) {
				// 첨부
				if (new File(uploadPath + mphoto).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재하는 경우
					mphoto = System.currentTimeMillis() + mphoto;
				} // if (파일이름 변경)
				try {
					mFile.transferTo(new File(uploadPath + mphoto));
					System.out.println("서버에 저장된 파일 : " + uploadPath + mphoto);
					System.out.println("복사 될 파일 : " + backupPath + mphoto);
					boolean result = fileCopy(uploadPath + mphoto, backupPath + mphoto);
					System.out.println(result ? idx + "번째 백업 성공" : idx + "번째 백업 실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				// 파일 첨부 안 하면 bimg[idx] = "" 빈스트링이 들어감
				// bimg[idx] = "";
			} // if
			idx++;
		} // while
		member.setMphoto(mphoto);
		
		// 메일전송
				MimeMessagePreparator message = new MimeMessagePreparator() {
					String content = "<div style=\"width:500px; margin: 0 auto\">\n" + 
							" <h1>" +member.getMname() + "님의 회원가입 감사합니다</h1>\n" + 
							" 아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다<br>\n" + 
							" <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\" alt=\"다음 로고\">\n" + 
							" <hr color=\"red\">\n" + 
							" <span style=\"color:red;\">빨간 글씨 부분</span><br>\n" + 
							" <span style=\"color:blue;\">파란 글씨 부분</span><br>\n" + 
							" <img src=\"http://localhost:8090/jeju/img/coupon.jpg\" alt=\"쿠폰\"><br>\n" + 
							" <p align=\"center\">서울시 어떤구 몰라17길 51 어떤빌딩 2층</p>\n" + 
							" </div>";
					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						// 받을 메일
						mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMemail()));
						// 보낼 메일
						mimeMessage.setFrom(new InternetAddress("dnvk8888@gmail.com"));
						// 메일 제목
						mimeMessage.setSubject("[HTML 가입인사]" + member.getMname() + "님 가입 감사합니다");
						// 메일 본문
						mimeMessage.setText(content, "utf-8", "html");
					}
				}; // message 객체 생성
				mailSender.send(message); // 메일 전송
				httpSession.setAttribute("mid", member.getMid());
				return memberDao.joinMember(member); // DB 저장	
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberDao.getDetailMember(mid);
		if (member == null) {
			result = "유효하지 않은 아이디 입니다.";
		} else if (! member.getMpw().equals(mpw)) {
			result = "비밀번호가 틀렸습니다.";
		} else {
			httpSession.setAttribute("member", member);
		}
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member, HttpSession httpSession) {
		httpSession.setAttribute("member", member);
		return memberDao.modifyMember(member);
	}

	@Override
	public int DeleteMember(String mid) {
		return memberDao.DeleteMember(mid);
	}
	private boolean fileCopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while (true) {
				int nReadByte = is.read(buff);
				if (nReadByte == -1)
					break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
