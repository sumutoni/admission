package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FormService;
import Service.FormServiceInterface;

@WebServlet("/statusUpdate")
public class StatusUpdate extends HttpServlet{
    private final FormServiceInterface formService = new FormService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String update = request.getParameter("update");
        boolean updated = formService.updateStatus(Integer.parseInt(id), update);
        if (updated){
            response.sendRedirect("viewForm?id=" + id);
        } else {
            // Handle error case, e.g., display an error message to the user
            System.out.println("Status update failed.");
        }
    }
}
