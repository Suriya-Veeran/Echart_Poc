package report.utils.image;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ImageUtils {

  /** Loads an image for header/footer if required. */
  public Image loadImage(String imagePath, float fitWidth, float fitHeight) {
    try {
      File imageFile = new File(imagePath);
      if (!imageFile.exists()) {
        log.info("Image file not found at path: {}", imagePath);
        return null;
      }

      ImageData imageData = ImageDataFactory.create(imageFile.getAbsolutePath());
      return new Image(imageData).scaleToFit(fitWidth, fitHeight);
    } catch (IOException e) {
      log.error("Error loading image from path: {}", imagePath, e);
      return null;
    }
  }
}
