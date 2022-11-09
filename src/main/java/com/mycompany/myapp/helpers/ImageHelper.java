package com.mycompany.myapp.helpers;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author Houta
 */
public class ImageHelper {
    public static Image resize(Image originalImage, int targetWidth, int targetHeight){
        Image resImg = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resImg;
    }
    public static byte[] toByteArray(Image img, String type){
        try {
            BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bimg.createGraphics();
            g.drawImage(img, 0, 0, null);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bimg, type, baos);
            return baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(ImageHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Image createImgFromByteArray(byte[] avatar, String type){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(avatar);
            BufferedImage img = ImageIO.read(bais); 
            return img.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            Logger.getLogger(ImageHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
