
package Helper;

import java.io.File;

public class ImageRemover {
    public static boolean removeImage(String imageName){
        String imagePath = "src/Images/" + imageName;

        File imageFile = new File(imagePath);

        if (!imageFile.exists()){
            return false;
        } 
        
        boolean deleted = imageFile.delete();

        if (!deleted) {
            return false;
        }
        
        return true;
    }
}
