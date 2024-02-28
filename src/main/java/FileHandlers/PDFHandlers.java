package FileHandlers;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class PDFHandlers {
    public static String fileName;

    public static byte[] transformPDF(Part filePart){
        byte[] file = null;
        InputStream fileContent;
        try {
            fileContent = filePart.getInputStream();
            file = fileContent.readAllBytes();
            fileName = filePart.getSubmittedFileName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
// if (ServletFileUpload.isMultipartContent(request)) {
        //     DiskFileItemFactory factory = new DiskFileItemFactory();
        //     ServletFileUpload upload = new ServletFileUpload(factory);
            
        //     try {
        //         List<FileItem> items = upload.parseRequest(request);
        //         for (FileItem item : items) {
        //             if (!item.isFormField()) {
        //                 file = item.get();
        //                 fileName = item.getName();
        //             }
        //         }
        //     } catch (Exception e) {
        //         throw new ServletException("Exception in uploading file.", e);
        //     }
        // }