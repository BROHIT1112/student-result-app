package com.devops;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class StudentResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String rollNo = request.getParameter("rollNo");

        String name;
        int marks;

        if ("101".equals(rollNo)) {
            name = "Rahul";
            marks = 85;
        } else if ("102".equals(rollNo)) {
            name = "Amit";
            marks = 72;
        } else if ("103".equals(rollNo)) {
            name = "Priya";
            marks = 65;
        } else {
            name = "Student Not Found";
            marks = 0;
        }

        String result = marks >= 40 ? "PASS" : "FAIL";

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Result</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Student Result</h1>");

        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr>");
        out.println("<th>Roll No</th>");
        out.println("<th>Name</th>");
        out.println("<th>Marks</th>");
        out.println("<th>Result</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>" + rollNo + "</td>");
        out.println("<td>" + name + "</td>");
        out.println("<td>" + marks + "</td>");
        out.println("<td>" + result + "</td>");
        out.println("</tr>");

        out.println("</table>");
        out.println("<br>");
        out.println("<a href='index.jsp'>Search Another Student</a>");

        out.println("</body>");
        out.println("</html>");
    }
}

