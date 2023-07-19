package Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class ImageUploader {
    public static String uploadImage(File selectedFile) {
        try {
            String destinationDirectory = "src/Images/";
            
            String fileName = generateUniqueFileName(selectedFile.getName());
            
            Path destinationPath = Path.of(destinationDirectory + fileName);

            Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            
            return fileName;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    private static String generateUniqueFileName(String originalFileName) {
        long timestamp = System.currentTimeMillis();
        return timestamp + "_" + originalFileName;
    }
}
