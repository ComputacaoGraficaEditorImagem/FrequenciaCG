/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package figura;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author moreno angola
 */
public class Retangulo extends Figura{

    private double origemX;
    private double origemY;

    private double largura;
    private double haltura;

    private Shape forma;
    
    public Retangulo(double largura, double haltura) 
    {
        this.largura = largura;
        this.haltura = haltura;
        origemX=0.0;
        origemY=0.0;
        
        forma = new RoundRectangle2D.Double(origemX, origemY, largura, haltura, 150, 150);
    }
    
    
    public double getOrigemX() 
    {
        return origemX;
    }

    public void setOrigemX(double origemX) 
    {
        this.origemX = origemX;
    }

    public double getOrigemY() 
    {
        return origemY;
    }

    public void setOrigemY(double origemY) 
    {
        this.origemY = origemY;
    }
    
    public double getLargura() 
    {
        return largura;
    }

    public void setLargura(double largura) 
    {
        this.largura = largura;
    }

    public double getHaltura() 
    {
        return haltura;
    }

    public void setHaltura(double haltura) 
    {
        this.haltura = haltura;
    }
        
    @Override
    public void desenhar(Graphics2D g2d) 
    {
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(origemX, origemY, largura, haltura, 150, 150);
        g2d.setColor(Color.red);
        g2d.fill(rect);
        forma=rect;
    }

    @Override
    public Shape getForma() 
    {
        return forma;
    }
    
}
