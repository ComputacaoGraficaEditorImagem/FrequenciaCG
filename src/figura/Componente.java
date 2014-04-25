
package figura;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;

public abstract class Componente 
{
    protected Color cor;
        
    public abstract void desenhar(Graphics2D g2d);  
    public abstract void adicionarFigura(Figura figura);  
    public abstract Area getArea();  
    
    
}
