package com.jsp.Meals;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkingpage")
public class Checkingpage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uage = req.getParameter("age");
		String wht = req.getParameter("weight");
		String wgoal = req.getParameter("goal");
		String meal = req.getParameter("mealType");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int nage = Integer.parseInt(uage);
		if(nage>=18 && nage<=28 && wgoal.equals("Weight Gain") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age18-28veg.Weightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=18 && nage<=28 && wgoal.equals("Weight Loss") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age18-28nonveg.Weightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=18 && nage<=28 && wgoal.equals("Weight Gain") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age18-28nonveg.Weightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=18 && nage<=28 && wgoal.equals("Weight Loss") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age18-28veg.Weightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=28 && nage<=38 && wgoal.equals("Weight Gain") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age28-38vegWaightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=28 && nage<=38 && wgoal.equals("Weight Loss") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age28-38nonvegWeightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=28 && nage<=38 && wgoal.equals("Weight Gain") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age28-38nonvegWeightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=28 && nage<=38 && wgoal.equals("Weight Loss") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age28-38vegWeightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=38 && nage<=48 && wgoal.equals("Weight Gain") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age38-48vegWeightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=38 && nage<=48 && wgoal.equals("Weight Loss") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age38-48nonvegWeightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=38 && nage<=48 && wgoal.equals("Weight Gain") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age38-48nonvegWeightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=38 && nage<=48 && wgoal.equals("Weight Loss") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age38-48vegWeightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=48 && nage<=58 && wgoal.equals("Weight Gain") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age48-58vegWeightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=48 && nage<=58 && wgoal.equals("Weight Loss") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age48-58nonvegWeightloss.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=48 && nage<=58 && wgoal.equals("Weight Gain") && meal.equals("Non Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age48-58nonvegWeightgain.html");
			dispatcher.include(req, resp);
		}
		else if(nage>=48 && nage<=58 && wgoal.equals("Weight Loss") && meal.equals("Veg")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Age48-58vegWeightloss.html");
			dispatcher.include(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Checkingdata.html");
			dispatcher.include(req, resp);
			out.println("<h4 style=color:red;position:absolute;left:40%;top:25%;>Please Enter Age Between 18 - 58</h4>");
		}
	}
}
