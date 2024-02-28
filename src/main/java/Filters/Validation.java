package Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/registration")
public class Validation implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //get all parameters
        String names = request.getParameter("name");
        String email =  request.getParameter("email");
        String password = request.getParameter("password");
        String confpass = request.getParameter("confpassword");
        String name_message="",email_message="", pass_message="", conf_message="";
        String emailpattern = "[A-Za-z0-9\\._\\-]+@[A-Za-z]{2,}\\.[A-Za-z\\.]{2,}";

        if (names.equals("")){
        name_message = "Please provide your names!";
        }

        if (email.equals("")){
        email_message = "Please provide your email!";
        }
        if(!email.matches(emailpattern)){
        email_message = "your email is incorrect!";
        }
        if(password.equals("")){
        pass_message = "Please type a password!";
        }
        else if (password.length() < 8){
        pass_message = "Password must have at least 8 characters";
        }
        if(confpass.equals("")){
        conf_message = "Please confirm your password!";
        }
        else if(!confpass.equals(password)){
        conf_message = "Passwords do not match";
        }

        if (conf_message.isEmpty() && pass_message.isEmpty() && email_message.isEmpty() && name_message.isEmpty()){
            chain.doFilter(request, response);
        }
        else{
            request.setAttribute("conf_message", conf_message);
            request.setAttribute("pass_message", pass_message);
            request.setAttribute("email_message", email_message);
            request.setAttribute("name_message", name_message);
            RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
            dp.forward(request, response);
        }
        
    }
    
}
