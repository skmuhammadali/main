package com.jsp.Meals;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String url = "jdbc:mysql://localhost:3306/meals?user=root&password=12345";
		String query = "select * from userregister where uname = ? and password = ?";
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					if(uname.equals(rs.getString(2)) && pass.equals(rs.getString(3))) {
						RequestDispatcher dispatcher = req.getRequestDispatcher("Checkingdata.html");
						dispatcher.forward(req, resp);
					}
				}
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				dispatcher.include(req, resp);
				out.println("<h4 style=color:red;position:absolute;left:40%;top:25%;>Please Enter Valid Credentials</h4>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
