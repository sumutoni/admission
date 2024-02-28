package FileHandlers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class PictureHandlers {
    public static String fileName;
    public static byte[] transformPicture(Part filePart){
        InputStream fileContent;
        byte[] pictureBytes = null;
        try {
            fileContent = filePart.getInputStream();
            pictureBytes = fileContent.readAllBytes();
            fileName = filePart.getSubmittedFileName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return pictureBytes;
    }
    
}
