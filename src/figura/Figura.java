
package figura;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public abstract class Figura 
{
    protected Color cor;
    
    protected double origemX;
    protected double origemY;
    
    public abstract void desenhar(Graphics2D g2d);
    
    public abstract Shape getForma();
}
