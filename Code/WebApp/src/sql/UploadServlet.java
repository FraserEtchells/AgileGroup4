package sql;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet/2424824#2424824
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	    System.out.println(":D");
	    
	    //chosen the way of 8. Seems to have best performance.
	    //https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
	    ByteArrayOutputStream result = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int length;
	    while ((length = fileContent.read(buffer)) != -1) {
	        result.write(buffer, 0, length);
	    }
	    // StandardCharsets.UTF_8.name() > JDK 7
	    DataSetFormater n = new DataSetFormater();
	    DataSetFormater upload = new DataSetFormater();
	    System.out.print(result.toString("UTF-8"));
	    upload.uploadData(result.toString("UTF-8"));
//	    String[] a = n.separateFile(result.toString("UTF-8"));
//	    System.out.print("SIZE: " + a.length);
	    
	    
	}
}
