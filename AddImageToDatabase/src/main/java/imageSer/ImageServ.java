package imageSer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImageServ
 */
@MultipartConfig
@WebServlet("/ImageServ")
public class ImageServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
		
		System.out.println("Image servlet");
		
		Part file=request.getPart("image");
		
		String imageName=file.getSubmittedFileName();
		System.out.println("selected image file is " + imageName);
		
		String uploadPath="C:/Users/khandokar56/eclipse-workspace/AddImageToDatabase/images/"+imageName;
		System.out.println("uploadPath"+uploadPath);
		
		try {
			
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=file.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read();
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javatree","root","Aditya@123");
			PreparedStatement psmt;
			String query="insert into image(imageName) values(?)";
			psmt=con.prepareStatement(query);
			psmt.setString(1,imageName);
			int row=psmt.executeUpdate();
			
			if(row>0)
			{
				System.out.println("Image Added");
			}else {
				System.out.println("failed to upload image");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
