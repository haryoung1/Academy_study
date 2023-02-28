<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
<<<<<<< HEAD
		String path = request.getRealPath("fileUpFolder2"); //첨부 할 파일이 저장될 서버(was)폴더
		// out.print(path); 절대경로
=======
		String path = request.getRealPath("fileUpFolder2");//첨부 할 파일이 저장될 서버(was)폴더
		// out.print(path);
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		int maxSize = 1024*1024*10; // 업로드 최대용량 (10MB)
		String filename = "";
		String ogFilename = "";
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
									  	new DefaultFileRenamePolicy());
		// new DefaultFileRenamePolicy() : 같은 이름의 파일이 있을 경우 : 1.jpg -> 11.jpg -> (리네임 해주는 역활)
		Enumeration<String> paramNames = mRequest.getFileNames();// 파일 첨부한 파라미터들
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement(); // param = file ?
			filename = mRequest.getFilesystemName(param); // 파라미터로 올라온 파일 이름
			ogFilename = mRequest.getOriginalFileName(param); // 파라미터에 첨부한 오리지널 파일이름
			System.out.println("파라미터 이름 : " + param + " / 서버에 저장된 파일 이름 : " + filename +
					" / 사용자가 첨부한 오리지널 이름 : " + ogFilename);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에 업로드 한 후 소스폴더로 file copy
		InputStream  is = null;
		OutputStream os = null;
		try {
			File serverFile = new File(path + "/" + filename);
			if (serverFile.exists()) {
				is = new FileInputStream(serverFile); // 서버에 업로드 된 파일
				os = new FileOutputStream
				("D:/webPro/source/06_jsp/ch14_fileUp/WebContent/fileUpFolder2/" + filename);
				byte[] bs = new byte [ (int)serverFile.length() ];
				while(true) {
					int nReadCnt = is.read(bs);
					if (nReadCnt == -1) break;
<<<<<<< HEAD
					os.write(bs, 0, nReadCnt);
				}
				System.out.println("서버에 업로드 한  파일을 소스폴더로 복사 완료");
=======
				}
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os != null) os.close();
				if(is != null) os.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
<<<<<<< HEAD
		if(filename != null) {
			
	%>		
		<h3>첨부한 오리지널 파일 이름 : <%=ogFilename %></h3>
		<h3>서버에 저장된 파일 이름 : <%=filename %></h3>
		<img src="<%=conPath %>/fileUpFolder2/<%=filename %>" alt="첨부안함">
	<%}else {
		out.println("<h2>첨부안함 : filename = " + filename + ", 오리지널= " + ogFilename + "</h2>");
	}
	%>	
</body>
</html>
=======
	%>
</body>
</html>












>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
