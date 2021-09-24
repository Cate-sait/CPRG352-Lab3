/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ya-Yun Huang
 */
public class AgeCalculatorServlet extends HttpServlet
{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String age = request.getParameter("age");
        request.setAttribute("age", age);
        
        // validation
        if (age == null || age == "")
        {
            request.setAttribute("message", "You must give your current age.");
        } 
        else if (! age.matches("\\d+"))
        {
             request.setAttribute("message", "You must enter a number.");
        } 
        else
        {
            request.setAttribute("message", "Your age next birthday will be " + (Integer.parseInt(age) + 1) + ".");
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
}
