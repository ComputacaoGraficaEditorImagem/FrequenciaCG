

package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Fundo extends JRootPane
{  

    ImageIcon imagem = new ImageIcon(this.getClass().getResource("/img/fundo.png"));  
      
    @Override
    public void paintComponent(Graphics g) {  
          
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
          
        final Image backgroundImage = imagem.getImage();  
        double scaleX = getWidth() / (double) backgroundImage.getWidth(null);  
        double scaleY = getHeight() / (double) backgroundImage.getHeight(null);  
        AffineTransform xform = AffineTransform.getScaleInstance(scaleX, scaleY);  
        ((Graphics2D) g).drawImage(backgroundImage, xform, this);  
                 
    }  
}
    

