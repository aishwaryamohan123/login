package website;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.WebServlet;

@WebServlet("/signup")
public class website extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "Rkv@2022");
	PreparedStatement ps=con.prepareStatement("insert into new_table values(?,?,?)");
	ps.setString(1, id);
	ps.setString(2, name);
	ps.setString(3, email);
	 int row=ps.executeUpdate();
	 if(row==1)
	 {
		 RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
		 rd.forward(req,resp);
	 }
	 else
	 {
		 resp.sendRedirect("signup.html");
	 }
	}catch(Exception e) {
	}

}
}