package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Form;
import Service.FormService;
import Service.FormServiceInterface;

@WebServlet("/displayPicture")
public class DisplayPicture extends HttpServlet {
    private final FormServiceInterface formService = new FormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Form form = formService.getForm(Integer.parseInt(id));
        byte[] pictureBytes = form.getPicture();
        
        // Set content type based on your picture format (e.g., image/jpeg, image/png)
        response.setContentType("image/jpeg");
        response.setContentLength(pictureBytes.length);
        response.getOutputStream().write(pictureBytes);
    }
}