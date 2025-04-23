package com.jsp.Meals;

import java.io.IOException;
import java.sql.Connection;
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

@WebServlet("/register")
public class Register extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/meals?user=root&password=12345";
		String query = "insert into userregister values(?,?,?,?,?,?,?,?,?)";
		String fname = req.getParameter("firstname");
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String uage = req.getParameter("age");
		String uweight = req.getParameter("weight");
		String uheight = req.getParameter("height");
		String utimeline = req.getParameter("timeline");
		String goal = req.getParameter("goalWeight");
		String gendr = req.getParameter("gender");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, uname);
			ps.setString(3, pass);
			ps.setString(4, uage);
			ps.setString(5, uweight);
			ps.setString(6, uheight);
			ps.setString(7, utimeline);
			ps.setString(8, goal);
			ps.setString(9, gendr);
			int rs = ps.executeUpdate();
			if(rs>0) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				dispatcher.forward(req, resp);
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("Signup.html");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
