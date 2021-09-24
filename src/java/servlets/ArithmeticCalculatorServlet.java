package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ya-Yun Huang
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("message", "Result: ---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String v1 = request.getParameter("v1");
        String v2 = request.getParameter("v2");

        request.setAttribute("v1", v1);
        request.setAttribute("v2", v2);

        int n1;
        int n2;
        
        if (request.getParameter("add") != null)
        {
            if (validateInput(v1, v2))
            {
                n1 = Integer.parseInt(v1);
                n2 = Integer.parseInt(v2);
                request.setAttribute("message", "Result: " + (n1 + n2));
            }
            else
            {
                request.setAttribute("message", "Result: invalid");
            }
        } 
        else if (request.getParameter("subtract") != null)
        {
            if (validateInput(v1, v2))
            {
                n1 = Integer.parseInt(v1);
                n2 = Integer.parseInt(v2);
                request.setAttribute("message", "Result: " + (n1 - n2));
            }
            else
            {
                request.setAttribute("message", "Result: invalid");
            }
        } 
        else if (request.getParameter("multiply") != null) 
        {
            if (validateInput(v1, v2))
            {
                n1 = Integer.parseInt(v1);
                n2 = Integer.parseInt(v2);
                request.setAttribute("message", "Result: " + (n1 * n2));
            }
            else
            {
                request.setAttribute("message", "Result: invalid");
            }
        } 
        else if (request.getParameter("modulur") != null) 
        {
            if (validateInput(v1, v2))
            {
                n1 = Integer.parseInt(v1);
                n2 = Integer.parseInt(v2);
                request.setAttribute("message", "Result: " + (n1 % n2));
            }
            else
            {
                request.setAttribute("message", "Result: invalid");
            }
        }
        else
        {
            request.setAttribute("message", "Result: invalid");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    private boolean validateInput(String v1, String v2) {
        if (v1 == null || v1.equals("") || v2 == null || v2.equals("")) 
        {
            return false;
        } 
        else if (!v1.matches("\\d+") || !v2.matches("\\d+")) 
        {
            return false;
        } 
        else 
        {
            return true;
        }
    }
}
