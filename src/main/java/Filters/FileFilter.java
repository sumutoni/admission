package Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import FileHandlers.PDFHandlers;
import FileHandlers.PictureHandlers;

@WebFilter("/admission")
@MultipartConfig(maxFileSize = 16177215)
public class FileFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Part filePart = req.getPart("certs");
        PDFHandlers.transformPDF(filePart);
        Part picturePart = req.getPart("picture");
        PictureHandlers.transformPicture(picturePart);
        String diplomaFilename = PDFHandlers.fileName;
        String pictureFilename = PictureHandlers.fileName;
        System.out.println(diplomaFilename);
        System.out.println(pictureFilename);
        String diplomaMessage = "", pictureMessage = "";
        boolean hasErrors = false;
        if (diplomaFilename == ""){
            diplomaMessage = "Please upload a certifcate or diploma";
            hasErrors = true;
        }
        else if (!diplomaFilename.endsWith(".pdf")){
            diplomaMessage = "Only provide PDF files";
            hasErrors = true;
        }

        if (pictureFilename == ""){
            pictureMessage = "Please upload a passport picture";
            hasErrors = true;
        }
        else if (!pictureFilename.endsWith(".jpg") && !pictureFilename.endsWith(".png")){
            pictureMessage = "Only provide pictures with jpg or png extensions";
            hasErrors = true;
        }

        System.out.println(hasErrors);
        request.setAttribute("hasErrors", hasErrors);
        

        if (hasErrors) {
            // Forward to JSP
            RequestDispatcher dp = request.getRequestDispatcher("registration.jsp");
            dp.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
    
}