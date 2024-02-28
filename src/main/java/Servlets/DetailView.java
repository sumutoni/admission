package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Form;
import Service.FormService;
import Service.FormServiceInterface;

@WebServlet("/viewForm")
public class DetailView extends HttpServlet{
    private final FormServiceInterface formService = new FormService();
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        if (session != null){
            String id = request.getParameter("id");
            Form form = formService.getForm(Integer.parseInt(id));
            request.setAttribute("fullName", form.getFullName());
            request.setAttribute("dob", form.getDOB());
            request.setAttribute("gender", form.getGender());
            request.setAttribute("fatherName", form.getFatherName());
            request.setAttribute("motherName", form.getMotherName());
            request.setAttribute("country", form.getCountry());
            request.setAttribute("city", form.getCity());
            request.setAttribute("address", form.getAddress());
            request.setAttribute("email", form.getEmail());
            request.setAttribute("phone", form.getPhone());
            request.setAttribute("degree", form.getDegree());
            request.setAttribute("dept", form.getDepartment());
            request.setAttribute("form", form);
            RequestDispatcher rd = request.getRequestDispatcher("viewForm.jsp");
            rd.forward(request, response);

        } 
        else{
            response.sendRedirect("login.jsp");
        }             
       
    }
    
}

