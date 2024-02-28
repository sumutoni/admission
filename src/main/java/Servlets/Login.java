package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Form;
import Model.User;
import Service.FormService;
import Service.FormServiceInterface;
import Service.UserService;
import Service.UserServiceInterface;

@WebServlet("/login")
public class Login extends HttpServlet{
    private final UserServiceInterface userService = new UserService();
    private final FormServiceInterface formService = new FormService();
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email =  request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.getUser(email, password);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("names", user.getNames());
        request.setAttribute("user", user);
        if (user.getRole().equalsIgnoreCase("Student")){
            RequestDispatcher dp = request.getRequestDispatcher("registration.jsp");
            dp.forward(request, response);
        }
        else{
            List<Form> forms = formService.getForms();
            request.setAttribute("forms", forms);
            RequestDispatcher dp = request.getRequestDispatcher("admin_dash.jsp");
            dp.forward(request, response);
        }
        

       
    }
    
}
