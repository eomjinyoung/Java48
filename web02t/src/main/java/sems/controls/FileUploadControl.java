package sems.controls;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import sems.annotations.Component;

@Component("/file/upload.bit")
public class FileUploadControl implements PageController {
	ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public String execute(Map<String, Object> model) {
		try {
			String fullPath = servletContext.getRealPath("/upload");
			FileItem item = (FileItem)model.get("file1");
			File savedFile = new File(fullPath + "/" + item.getName());
			item.write(savedFile); 
			
			return "/file/uploadResult.jsp";
		
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}








