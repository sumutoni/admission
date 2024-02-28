package Filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Form;
import Service.FormService;
import Service.FormServiceInterface;

@WebFilter(urlPatterns = {"/registration.jsp", "/admin_dash.jsp", "/viewForm.jsp"})
public class Authentication implements Filter {
    private final FormServiceInterface formService = new FormService();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession(false) == null || req.getSession(false).getAttribute("email") == null)
        {
           res.sendRedirect("login.jsp");
        }
        else{
            if (req.getServletPath().equals("/admin_dash.jsp")){
                List<Form> forms = formService.getForms();
                req.setAttribute("forms", forms);
                System.out.println(true);
            }
            RequestDispatcher rd = req.getRequestDispatcher(req.getServletPath());
            rd.forward(req, res);
        }
    }
    
}
