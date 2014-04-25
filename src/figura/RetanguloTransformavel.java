/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package figura;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import visao.TelaPainelVisao;


public class RetanguloTransformavel extends FiguraAnimada
{
    private Rectangle2D.Double forma;
    
    private double largura;
    private double haltura;
    private boolean preencher;
    private TelaPainelVisao tela;
    
    public RetanguloTransformavel()
    {
        this.cor=Color.DARK_GRAY;
        forma = new Rectangle2D.Double(origemX, origemY, largura, haltura);
    }
    
    public RetanguloTransformavel(TelaPainelVisao tela)
    {
        this();
        this.tela = tela;
    }
    
    public RetanguloTransformavel(double x, double y, double largura, double haltura )
    {
        this.cor=Color.DARK_GRAY;
        this.origemX=x;
        this.origemY=y;
        forma = new Rectangle2D.Double(x, y, largura, haltura);
    }
 
    public TelaPainelVisao getTela() 
    {
        return tela;
    }

    public void setTela(TelaPainelVisao tela) 
    {
        this.tela = tela;
    }
    
    @Override
    public void desenhar(Graphics2D g2d) 
    {
        g2d.setColor(cor);
        if(preencher) { g2d.draw(forma); }
        
        else { g2d.fill(forma); }
        
    }

    @Override
    public Shape getForma() 
    {
        return forma;
    }

    @Override
    public void transformar() 
    {
       
    }
    
    public void mover(double x, double y)
    {
        origemX+=x;
        origemY+=y;
        
        tela.repaint();
    }
}
