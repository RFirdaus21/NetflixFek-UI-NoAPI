package Helper;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageProcessor {
    public static ImageIcon scaleImage(JLabel imageLabel, String imageName) {
        String imagePath = "src/Images/" + imageName;
        Image image = loadImage(imagePath);
        if (image != null) {
            Image scaledImage = scaleImage(image, imageLabel.getWidth(), imageLabel.getHeight());
            return new ImageIcon(scaledImage);
        }
        return null;
    }
    
    public static ImageIcon scaleImage(JLabel imageLabel, String imageName, int width, int height) {
        String imagePath = "src/Images/" + imageName;
        Image image = loadImage(imagePath);
        if (image != null) {
            Image scaledImage = scaleImage(image, width, height);
            return new ImageIcon(scaledImage);
        }
        return null;
    }
    private static Image loadImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        return icon.getImage();
    }

    private static Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}


