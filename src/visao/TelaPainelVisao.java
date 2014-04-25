
package visao;

import figura.RetanguloTransformavel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class TelaPainelVisao extends JPanel implements MouseListener,MouseMotionListener, Runnable
{
    private BufferedImage imagem;
    private Graphics2D g;
    private RetanguloTransformavel retangulo;
    private Rectangle2D.Double background;
    private Thread animador;
    private Color corFundo;

    private double larguraFundo;
    private double halturaFundo;
    
    private HashMap<Key,Object> controlaQualidade;
    private int x;
    private int y; 
    boolean inverter ;
    private boolean pintarPonto;
    private int opcao;
    private boolean mover;
    
    private int dx;
    private int dy;
    
    private int posX;
    private int posY;

    public int getOpcao() 
    {
        return opcao;
    }

    public void setOpcao(int opcao) 
    {
        this.opcao = opcao;
    }
    
    public TelaPainelVisao()
    {
        super();
        setDoubleBuffered(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        animador = new Thread(this);
        animador.start();
        controlaQualidade = new HashMap<>();
        retangulo = new RetanguloTransformavel(80,0,200,300);
        retangulo.setTela(this);
        adicionarNivelDeQualidade();
        
        corFundo = new Color(255, 255, 255, 200);
        
        larguraFundo=647;
        halturaFundo=585;
        imagem = new BufferedImage((int)larguraFundo, (int)halturaFundo, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D)imagem.getGraphics();
        background = new Rectangle2D.Double(3,3, larguraFundo+5, halturaFundo+5);

    }
    
    public TelaPainelVisao(Color corFundo)
    {
       this();
        
       this.corFundo = corFundo;
       
    }
    
    public TelaPainelVisao(Color corFundo,double larguraFundo,double halturaFundo)
    {
       this(corFundo);
        
       this.larguraFundo=larguraFundo;
       this.halturaFundo=halturaFundo;
       
    }
    
    public BufferedImage getImagem() 
    {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) 
    {
        this.imagem = imagem;
    }
    
    public Color getCorFundo() 
    {
        return corFundo;
    }

    public void setCorFundo(Color corFundo) 
    {
        this.corFundo = corFundo;
    }
    
    public double getLarguraFundo() 
    {
        return larguraFundo;
    }

    public void setLarguraFundo(double larguraFundo) 
    {
        this.larguraFundo = larguraFundo;
    }

    public double getHalturaFundo() 
    {
        return halturaFundo;
    }

    public void setHalturaFundo(double halturaFundo) 
    {
        this.halturaFundo = halturaFundo;
    }
    
    public void adicionarNivelDeQualidade()
    {
       controlaQualidade.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       controlaQualidade.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
       controlaQualidade.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    
    
    @Override
    public void paint(Graphics g)
    {
       super.paint(g);
       
       Graphics2D g2d = (Graphics2D)g;
             
       g2d.setRenderingHints(controlaQualidade);
       
       g2d.setColor(new Color(150,150,150,100));
       
       g2d.fill(background);
       
       menuPintura(opcao,g2d);
       
       g2d.dispose();
    }
    
    public void menuPintura(int opcao, Graphics2D g2d)
    {
        g2d.drawImage(imagem, 3, 3, corFundo, this);
        
        switch(opcao)
        {
            case 1: pintarPontos(Color.BLACK);  
                break;
                
            case 2: retangulo.desenhar(g2d);
               
                break;
                
            default :
        
        }
    }
    
    public void pintar() 
    {   
       repaint();
    }

    
    @Override
    public void run()
    {
        while(pintarPonto)
        {
            pintar();
        }
    }
    
    public void pintarPontos(Color cor)
    {
                
//        g.setRenderingHints(controlaQualidade);
        g.setColor(cor);
        
        if(pintarPonto)
        {
            g.fillOval(x, y,10 , 10);
            repaint();
        }
    }
    
    public void desenharImagem(BufferedImage img)
    {
        Graphics2D g = (Graphics2D)imagem.getGraphics();
        
        g.setRenderingHints(controlaQualidade);
  
        g.drawImage(img, x, y, this);

    }
    
    public void limparTudo()
    {
        imagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_ARGB);      
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        pintar();
    }

    @Override
    public void mousePressed(MouseEvent e) 
    { 
       dx=e.getX();
       dy=e.getY();
       mover = true;
       
       pintarPonto=true;
       
       
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {    
       pintarPonto=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
       x=e.getX();
       y=e.getY();
       
       posX=e.getX()-dx;
       posY=e.getY()-dy;
       
       if(retangulo.getForma().contains(e.getPoint()))
       {
           retangulo = new RetanguloTransformavel(posX,posY,200,300);
           
           System.out.println("ponto existe");
       }
       
       pintar();
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {

    }
    
}