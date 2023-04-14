package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.util.Paging;
import com.lec.ch19.vo.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "D:/webPro/source/08_Spring/ch19_bookupMember/src/main/webapp/bookImgFileUpload/";

	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum, 10, 5);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		// mRequest에 들어온 파일을 서버에 저장 -> 소스폴더로 복사
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // bimg1, bimg2
		String[] bimg = new String[2]; // 이미지 두개 들어오니까 배열로 받는다.
		int idx = 0;
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부 된 파일객체 생성.
			bimg[idx] = mFile.getOriginalFilename(); // 업로드한 파일이름
			// 첨부를 안 하면 빈스트링
			if (bimg[idx] != null && !bimg[idx].equals("")) {
				// 첨부함
				if (new File(uploadPath + bimg[idx]).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재하는 경우
					bimg[idx] = System.currentTimeMillis() + bimg[idx];
				} // if (파일이름 변경)
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버에 저장된 파일 : " + uploadPath + bimg[idx]);
					System.out.println("복사 될 파일 : " + backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx + "번째 백업 성공" : idx + "번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else {
				// 파일 첨부 안 하면 bimg[idx] = "" 빈스트링이 들어감
				// bimg[idx] = "";
			} // if
			idx++;
		} // while
		book.setBimg1(bimg[0]); // 첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]); // 두번째 첨부한 파일 이름
		return bookDao.registerBook(book);

	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if (bimg[idx] != null && !bimg[idx].equals("")) { // 첨부함
				if (new File(uploadPath + bimg[idx]).exists()) {
					// 서버에 같은 파일이름이 있을 경우(첨부파일과)
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				} // if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx])); // 서버에 저장
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx + "번째 백업성공" : idx + "번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else {
				// 파일 첨부 안 하면 bimg[idx] = ""이다
			} // if
			idx++;
		} // while - bimg 배열에 파일 이름 저장
		Book book = new Book();
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		// TODO Auto-generated method stub
		return 0;
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
