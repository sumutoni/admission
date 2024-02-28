package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import FileHandlers.PDFHandlers;
import FileHandlers.PictureHandlers;
import Model.Form;
import Service.FormService;
import Service.FormServiceInterface;

@WebServlet("/admission")
@MultipartConfig(maxFileSize = 16177215)
public class Admission extends HttpServlet{
    final FormServiceInterface formService = new FormService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        // get all parameters
        String fullnames = request.getParameter("firstname") + " " +request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String fathname = request.getParameter("fathname");
        String mothname = request.getParameter("mothname");
        String email = request.getParameter("email");
        String phone  = request.getParameter("phone");
        String country = request.getParameter("residence");
        String city = request.getParameter("resicity");
        String address = request.getParameter("address");
        String degree = request.getParameter("degree");
        String dept = request.getParameter("dept");
        Part picPart = request.getPart("picture");
        Part filePart = request.getPart("certs");
        // Handle file uploads: picture and pdf
        byte[]pdf = PDFHandlers.transformPDF(filePart);
        byte[]pic = PictureHandlers.transformPicture(picPart);
        String fileName = PDFHandlers.fileName;

        //Instatiate Form and save to db
        Form form = new Form(fullnames, fathname, mothname, dob, gender, email, phone, address, country, city, pic, fileName, pdf, dept, degree, "Pending");
        System.out.println(formService.SaveForm(form));

        RequestDispatcher ds = request.getRequestDispatcher("preview.jsp");
        ds.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        List<Form> forms = formService.getForms();
        byte[] file = forms.get(7).getFile();
        // response.setContentType("image/jpeg");
        response.setContentType("application/pdf");
        response.setContentLength(file.length);
        response.getOutputStream().write(file);
    }
}

