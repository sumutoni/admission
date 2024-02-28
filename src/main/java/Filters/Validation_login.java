package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import Model.User;
import Service.UserService;
import Service.UserServiceInterface;

@WebFilter("/login")
public class Validation_login implements Filter {
    private final UserServiceInterface userService = new UserService();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        //get all parameters
        String email =  request.getParameter("email");
        String password = request.getParameter("password");
        String email_message="", pass_message="";
        String emailpattern = "[A-Za-z0-9\\._\\-]+@[A-Za-z]{2,}\\.[A-Za-z\\.]{2,}";
        if (!email.isEmpty() && !password.isEmpty()){
            User user = userService.getUser(email, password);
            if (user == null){
                email_message = "This user was not found!";
            }
        }
        else{
            if (email.equals("")){
                email_message = "Please provide your email!";
            }
            else if(!email.matches(emailpattern)){
                email_message = "your email is incorrect!";
            }
            if(password.equals("")){
                pass_message = "Please type your password!";
            }
        }
        
        if (pass_message.isEmpty() && email_message.isEmpty()){
            chain.doFilter(request, response);
        }
        else{
            request.setAttribute("pass_message", pass_message);
            request.setAttribute("email_message", email_message);
            RequestDispatcher dp = request.getRequestDispatcher("login.jsp");
            dp.forward(request, response);
        }
    }
    
}

