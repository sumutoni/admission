package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Service.UserService;
import Service.UserServiceInterface;

@WebServlet("/registration")
public class SignUp extends HttpServlet{

    private final UserServiceInterface userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        //get all parameters
        String names = request.getParameter("name");
        String email =  request.getParameter("email");
        String password = request.getParameter("password");
        User user =  new User(names, email, password, "Student");
        userService.createUser(user);
        response.sendRedirect("login.jsp");
    }
    
}
