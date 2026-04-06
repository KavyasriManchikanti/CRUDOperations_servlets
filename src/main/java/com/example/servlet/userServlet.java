package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	 private Connection getConnection() throws Exception {
	        Class.forName("org.postgresql.Driver");
	        return DriverManager.getConnection(
	            "jdbc:postgresql://localhost:5432/jobportal",
	            "postgres",
	            "root"
	        );
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String action = request.getParameter("action");

	        try {
	            Connection con = getConnection();

	            if ("register".equals(action)) {
					// Register
	                String name = request.getParameter("name");
	                String email = request.getParameter("email");
	                String phone = request.getParameter("phone");

	                PreparedStatement ps = con.prepareStatement(
	                    "INSERT INTO userDetails(name, phone_number, email) VALUES(?,?,?)"
	                );

	                ps.setString(1, name);
	                ps.setString(2, phone);
	                ps.setString(3, email);

	                ps.executeUpdate();

	                out.println("<h3 style='color:green;'>User Registered!</h3>");
	            }

	            //Update
	            else if ("update".equals(action)) {

	                String phone = request.getParameter("phone");
	                String name = request.getParameter("name");
	                String email = request.getParameter("email");

	                PreparedStatement ps = con.prepareStatement(
	                    "UPDATE userDetails SET name=?, email=? WHERE phone_number=?"
	                );

	                ps.setString(1, name);
	                ps.setString(2, email);
	                ps.setString(3, phone);

	                int rows = ps.executeUpdate();

	                if (rows > 0)
	                    out.println("<h3 style='color:orange;'>User Updated!</h3>");
	                else
	                    out.println("<h3 style='color:red;'>User Not Found!</h3>");
	            }

	            // Delete
	            else if ("delete".equals(action)) {

	                String phone = request.getParameter("phone");

	                PreparedStatement ps = con.prepareStatement(
	                    "DELETE FROM userDetails WHERE phone_number=?"
	                );

	                ps.setString(1, phone);

	                int rows = ps.executeUpdate();

	                if (rows > 0)
	                    out.println("<h3 style='color:red;'>User Deleted!</h3>");
	                else
	                    out.println("<h3 style='color:red;'>User Not Found!</h3>");
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
	        }
	    }

	    // Retrive
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String action = request.getParameter("action");

	        try {
	            Connection con = getConnection();

	            if ("retrieve".equals(action)) {

	                String phone = request.getParameter("phone");

	                PreparedStatement ps = con.prepareStatement(
	                    "SELECT * FROM userDetails WHERE phone_number=?"
	                );

	                ps.setString(1, phone);

	                ResultSet rs = ps.executeQuery();

	                if (rs.next()) {
	                    out.println("<h3>User Details</h3>");
	                    out.println("Name: " + rs.getString("name") + "<br>");
	                    out.println("Email: " + rs.getString("email") + "<br>");
	                    out.println("Phone: " + rs.getString("phone_number"));
	                } else {
	                    out.println("<h3 style='color:red;'>User Not Found!</h3>");
	                }
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
	        }
	    }

}
