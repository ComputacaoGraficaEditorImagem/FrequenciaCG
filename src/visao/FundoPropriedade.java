package visao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class FundoPropriedade extends JPanel{

    public FundoPropriedade() 
    {
    }
    
    public FundoPropriedade(LayoutManager lm)
    {
        super(lm);
    }
    ImageIcon imagem = new ImageIcon(this.getClass().getResource("/img/fundoPropriedade.png"));  
      
 
    public void paintComponent(Graphics g) {  
          
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
          
        final Image backgroundImage = imagem.getImage();  
        double scaleX = getWidth() / (double) backgroundImage.getWidth(null);  
        double scaleY = getHeight() / (double) backgroundImage.getHeight(null);  
        AffineTransform xform = AffineTransform.getScaleInstance(scaleX, scaleY);  
        ((Graphics2D) g).drawImage(backgroundImage, xform, this);  
                 
    }  
    
}
