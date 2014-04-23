package servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


//@WebServlet("/file/upload.bit")
@SuppressWarnings("serial")
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// 1) 파일을 저장을 담당할 객체 준비
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		
		// 2) 멀티 파트 데이터로부터 각 파트의 추출을 담당할 객체 준비
		ServletFileUpload upload = new ServletFileUpload(fileFactory);
		
		// 3) 멀티 파트 데이터를 읽기
		// - 멀티 파트로부터 각 파트를 분리하여 fileFactory에게 전달한다.
		// - fileFactory는 각 파트로부터 파라미터 이름과 값, 바이너리 데이터 등을 
		//    추출하여 FileItem 객체에 담는다.
		// - FileItem 목록을 리턴한다.
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for (FileItem item : items) {
				if (item.isFormField()) { // 일반 데이터
					System.out.print(item.getFieldName()); // 파라미터 명 출력
					System.out.print("=");
					System.out.println(item.getString("UTF-8")); // 파라미터 값 출력 
					
					// JSP에 전달하기 위해 request에 보관한다.
					request.setAttribute( 
							item.getFieldName(), 
							item.getString("UTF-8"));
				} else { // 파일 데이터 
					System.out.print(item.getFieldName()); // 파라미터 명 출력
					System.out.print("=");
					System.out.print(item.getName()); // 파일명 출력
					System.out.print(",");
					System.out.print(item.getContentType()); // 파일 데이터 타입 출력

					// JSP에 전달하기 위해 request에 보관한다.
					request.setAttribute(item.getFieldName(),	item.getName());
					
					// http://localhost:9898/okok파일 데이터 저장 
					// {톰캣 서버의 배치폴더}/웹애플리케이션/upload
					ServletContext sc = request.getServletContext();
					String fullPath = sc.getRealPath("/upload");
					File savedFile = new File(fullPath + "/" + item.getName());
					
					// savedFile 정보에 따라 해당 경로에 파일 저장
					item.write(savedFile); 
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"/file/uploadResult.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





















