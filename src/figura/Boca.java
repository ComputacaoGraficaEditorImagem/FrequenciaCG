
package figura;

import animacao.Animador;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import javax.swing.JPanel;

public class Boca extends FiguraAnimada implements Animador 
{
    private JPanel painel;
    
    private double centroX;
    private double centroY;
    
    private double largura;
    private double haltura;
    
    private Thread animador;
    
    private Shape forma;
    
    private boolean inverter;
    
    public Boca()
    {
        cor=Color.BLACK;
        
        centroX=(origemX+(largura/2));
        centroY=origemY+haltura;
        
        forma = new QuadCurve2D.Double(origemX, origemY,centroX, centroY, origemX+largura, origemY);
        
        animador = new Thread(this);
    }

    public Boca(JPanel painel)
    {
        this();
        this.painel=painel;
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

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getHaltura() {
        return haltura;
    }

    public void setHaltura(double haltura) 
    {
        this.haltura = haltura;
    }
    
    public double getCentroX() 
    {
        return  (origemX+(largura/2));
       
    }
    
    public void setCor(Color cor)
    {
        this.cor = cor;
    }
    
    public Color getCor()
    {
        return cor;
    }
    
    public void setCentroX(double centroX) 
    {
        this.centroX = centroX;
    }

    public double getCentroY() 
    {
        return  centroY;
    }

    public void setCentroY(double centroY) 
    {
        this.centroY = centroY;
    }
    
    @Override
    public void desenhar(Graphics2D g2d) 
    {
        g2d.setStroke(new BasicStroke(5));
        
        GeneralPath caminho = new GeneralPath();
        
        caminho.moveTo(getOrigemX(), getOrigemY());
        
        centroY = origemY+haltura;
        
        caminho.quadTo(getCentroX() ,getCentroY()  , getOrigemX()+largura, getOrigemY());
        
        g2d.draw(caminho);
        
        forma=caminho.createTransformedShape(null);
    }

    @Override
    public Shape getForma() 
    {
        return forma;
    }

    @Override
    public void transformar() 
    {  
        haltura=haltura+((inverter)?0.5:-0.5); 
        
        if(haltura<=0||haltura>50) 
        {    
            inverter=(inverter)?false:true;
        }
             
        painel.repaint();
    }

    @Override
    public void comessar() 
    {
        animador = new Thread(this);
        animador.start();
    }

    @Override
    public void terminar() 
    {
        animador = null;
    }

    @Override
    public void run() 
    {
        while(animador!=null)
        {
            try {
                Thread.sleep(500/60);
            } catch (InterruptedException ex) {System.out.println("exepcao");
            }
            
            finally{transformar();}
        }
    }
    
}
