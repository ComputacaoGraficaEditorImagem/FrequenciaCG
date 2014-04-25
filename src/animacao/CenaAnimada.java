/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animacao;

import figura.Boca;
import figura.CabecaBoneco;
import figura.Retangulo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author moreno angola
 */
public class CenaAnimada extends JPanel implements Animador,Transformavel
{
    private Thread animador;
    private Retangulo formaCabeca;
    private CabecaBoneco cabeca;
    private Boca boca;
    private HashMap<RenderingHints.Key,Object> controlaQualidade;
    private boolean inverter;
    int x;
    int y;
    private boolean triste;
 
    public CenaAnimada()
    {
        setDoubleBuffered(true);
        controlaQualidade = new HashMap<>();
        adicionarQualidade();
        formaCabeca = new Retangulo(200,200);
        boca = new Boca(this);
        boca.setCor(Color.BLACK);
        
        boca.setOrigemX(formaCabeca.getOrigemX()+55);
        boca.setOrigemY(formaCabeca.getOrigemY()+140);
        
        boca.setHaltura(60);
        boca.setLargura(100);
        cabeca = new CabecaBoneco();
        
        cabeca.adicionarFigura(formaCabeca);
        cabeca.adicionarFigura(boca);   
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d =(Graphics2D)g;
        g2d.setRenderingHints(controlaQualidade);
        
        cabeca.desenhar(g2d);
        
    }
    
        
    public void adicionarQualidade()
    {
       controlaQualidade.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       controlaQualidade.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
       controlaQualidade.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
        animador=null;
    }

    @Override
    public void run() 
    {
        while(animador!=null)
        {
            try 
            {
                Thread.sleep(400/60);
            } 
            
            catch (InterruptedException ex) {  }
            
            finally{transformar();}
        }
    }

    @Override
    public void transformar() 
    {
       formaCabeca.setOrigemX(formaCabeca.getOrigemX()+((inverter)?-1.0:1.0));
       formaCabeca.setOrigemY(formaCabeca.getOrigemY()+((inverter)?-1.0:1.0));
       
       boca.setOrigemX(formaCabeca.getOrigemX()+60);
       boca.setOrigemY(formaCabeca.getOrigemY()+150);
       
       boca.transformar();
              
       if((((formaCabeca.getOrigemX()+ formaCabeca.getLargura())==465)||formaCabeca.getOrigemX()<0))
       {
           inverter=(inverter)?false:true;
       }

       repaint();
    }
}
