package visao;

import figura.*;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

public final class TelaPainelVisao extends JPanel implements MouseListener, MouseMotionListener, Runnable {

    private ArrayList<FiguraTransFormavel> figuras;
    
    private BufferedImage imagem;
    private Graphics2D graficoImagem;
    private FiguraTransFormavel figuraAtual;
    private OvalTransformavel oval;
    private RetaTransformavel retaTransformavel;
    private RetanguloSemArestasTransformavel retanguloRedondo;
    private RetanguloComArestasTransformavel retanguloQuadrado;
    private Lapis lapis;
    private Borracha borracha;
    private Rectangle2D.Double backgroundCenario;
    private Rectangle2D.Double backgroundTela;
    
    private Rectangle2D.Double auxRect;
    private Thread animador;
    private Color corFundo;
    private Color cor1;
    private Color cor2;
    private GradientPaint gradienteGP;
    
    private double larguraFundo;
    private double halturaFundo;
    private HashMap<Key, Object> controlaQualidade;
    private int x;
    private int y;
    boolean inverter;
    private int opcao;
    private double dx;
    private double dy;
    private double pontoInicialX;
    private double pontoInicialY;
    private double posX;
    private double posY;

    private int fixoX;
    private int fixoY;
    private boolean desenhar;
    private boolean pintarPonto;
    private boolean mousePrecionado;
    private boolean mouseLivre;
    private boolean mover;
    private boolean gradiente;
    private boolean textura;
    private boolean preencher;
    private boolean contorno;
    
    private ArrayList<BufferedImage> imagens;
    private ArrayList<FiguraTransFormavel> figurasMoviveis;
    
    private int xCenario;
    private int yCenario;
    private BasicStroke espessuraContorno;
    private Color corContorno;
    private Color corFundoFigura;
    private boolean densenhou;
    private boolean mouseArrastado;
    
    public TelaPainelVisao()
    {
        super();
        setDoubleBuffered(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        animador = new Thread(this);
        espessuraContorno = new BasicStroke(1);
        contorno =  true;
        controlaQualidade = new HashMap<>();
        adicionarNivelDeQualidade();
        imagens = new ArrayList<>();
        
        corFundo = new Color(255, 255, 255);
        cor1 = Color.CYAN;
        cor2 = Color.GRAY;
        corContorno = Color.BLACK;
        corFundoFigura = Color.WHITE;
        gradienteGP = new GradientPaint(20, 0, cor1, 20, 10, cor2);
        
        larguraFundo = 500;
        halturaFundo = 500;

        imagem = new BufferedImage((int) larguraFundo, (int) halturaFundo, BufferedImage.TRANSLUCENT);
        graficoImagem = imagem.createGraphics();
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        backgroundTela = new Rectangle2D.Double(0, 0, d.getWidth()-320, d.getHeight());

        oval = new OvalTransformavel(1000,1000);
        lapis = new Lapis(1000, 1000);
        borracha = new Borracha(1000, 1000);
        retaTransformavel = new RetaTransformavel(1000, 1000);
        retanguloRedondo = new RetanguloSemArestasTransformavel(1000,1000);
        retanguloQuadrado = new RetanguloComArestasTransformavel(1000,1000);
        figuraAtual =retanguloQuadrado;
        
        figuras = new ArrayList<>();
        figurasMoviveis=new  ArrayList<>();
        backgroundCenario = new Rectangle2D.Double(0, 0, larguraFundo + 5, halturaFundo + 5);
        
    }

    public TelaPainelVisao(Color corFundo) 
    {
        this();

        this.corFundo = corFundo;

    }
    
    public TelaPainelVisao(Color corFundo, double larguraFundo, double halturaFundo) 
    {
        this(corFundo);

        this.larguraFundo = larguraFundo;
        this.halturaFundo = halturaFundo;
        
        imagem = new BufferedImage((int) larguraFundo, (int) halturaFundo, BufferedImage.TRANSLUCENT);
        graficoImagem = imagem.createGraphics();
        
    }

    public BasicStroke getEspessuraContorno() 
    {
        return espessuraContorno;
    }

    public void setEspessuraContorno(BasicStroke espessuraContorno) 
    {
        this.espessuraContorno = espessuraContorno;
    }

    public Color getCorContorno()
    {
        return corContorno;
    }

    public void setCorContorno(Color corContorno) 
    {
        this.corContorno = corContorno;
    }

    public Color getCorFundoFigura() 
    {
        return corFundoFigura;
    }

    public void setCorFundoFigura(Color corFundoFigura) 
    {
        this.corFundoFigura = corFundoFigura;
    }

    
    
    public boolean isPreencher()
    {
        return preencher;
    }

    public void setPreencher(boolean preencher) 
    {
        this.preencher = preencher;
    }

    public boolean isContorno() 
    {
        return contorno;
    }

    public void setContorno(boolean contorno)
    {
        this.contorno = contorno;
    }

    
    
    public int getOpcao() 
    {
        return opcao;
    }

    public void setOpcao(int opcao) 
    {
        this.opcao = opcao;
    }
    
    public BufferedImage getImagem() 
    {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) 
    {
        this.imagem = imagem;
        graficoImagem = this.imagem.createGraphics();
    }

    public Color getCorFundo() 
    {
        return corFundo;
    }

    public void setCorFundo(Color corFundo) 
    {
        this.corFundo = corFundo;
    }

    public Color getCor1()
    {
        return cor1;
    }

    public void setCor1(Color cor1) 
    {
        this.cor1 = cor1;
    }

    public Color getCor2() 
    {
        return cor2;
    }

    public void setCor2(Color cor2) 
    {
        this.cor2 = cor2;
    }

    public GradientPaint getGradienteGP() 
    {
        return gradienteGP;
    }

    public void setGradienteGP(GradientPaint gradienteGP) 
    {
        this.gradienteGP = gradienteGP;
    }

    public boolean isGradiente() 
    {
        return gradiente;
    }

    public void setGradiente(boolean gradiente) 
    {
        this.gradiente = gradiente;
    }
    
    

    public double getLarguraFundo()
    {
        return larguraFundo;
    }

    public void setLarguraFundo(double larguraFundo) 
    {
        this.larguraFundo = larguraFundo;
        
        imagem = new BufferedImage((int) larguraFundo, (int) halturaFundo, BufferedImage.TRANSLUCENT);
        graficoImagem = imagem.createGraphics();
        
        int x = (int)(getCentroXPainel()-(larguraFundo/2) );
        int y = (int)(getCentroYPainel()-(halturaFundo/2) );
        
        backgroundCenario = new Rectangle2D.Double(x+5, y+5, larguraFundo + 5, halturaFundo + 5);
        
        repaint();
    }

    public double getHalturaFundo() 
    {
        return halturaFundo;
    }

    public void setHalturaFundo(double halturaFundo)
    {
        this.halturaFundo = halturaFundo;
        
        imagem = new BufferedImage((int) larguraFundo, (int) halturaFundo, BufferedImage.TRANSLUCENT);
        graficoImagem = imagem.createGraphics();
        
        int x = (int)(getCentroXPainel()-(larguraFundo/2) );
        int y = (int)(getCentroYPainel()-(halturaFundo/2) );
        
        backgroundCenario = new Rectangle2D.Double(x+5, y+5, larguraFundo + 5, halturaFundo + 5);
        
        repaint();
    }

    public void adicionarNivelDeQualidade()
    {
        controlaQualidade.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        controlaQualidade.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        controlaQualidade.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    @Override
    public void paint(Graphics graficoImagem) 
    {

        super.paint(graficoImagem);

        Graphics2D g2d = (Graphics2D) graficoImagem;

        g2d.setRenderingHints(controlaQualidade);
        this.graficoImagem.setRenderingHints(controlaQualidade);
        GradientPaint gp = new GradientPaint((int)getCentroXPainel(), 0, new Color(240,148,255),(int)getCentroXPainel(), 500, Color.DARK_GRAY);
        g2d.setPaint(Color.DARK_GRAY);
        backgroundTela = new Rectangle2D.Double(0, 0,getWidth()+320, getHeight()+320);
        g2d.fill(backgroundTela);
        
        g2d.setColor(new Color(150, 150, 150, 100));
        g2d.fill(backgroundCenario);

        menuPintura(opcao, g2d);

        g2d.dispose();
    }

    public void limparTela()
    {
        imagem = new BufferedImage((int) larguraFundo, (int) halturaFundo, BufferedImage.TRANSLUCENT);
        graficoImagem = imagem.createGraphics();
    }
    
    public void pintarImagens(ArrayList<RetanguloSemArestasTransformavel> figurasMoviveis)
    {
        for(int i=0; i<figurasMoviveis.size(); i++)
        {
            pintar();
            graficoImagem.drawImage(figurasMoviveis.get(i).getImagem(), -xCenario,-yCenario, this);
            pintar();
        }
    }
    
    public double getCentroXPainel()
    {
        return getWidth()/2;
    }
    
    public double getCentroYPainel()
    {
        return getHeight()/2;
    }
    
    public void menuPintura(int opcao, Graphics2D g2d)
    {   
        
        xCenario = (int)(getCentroXPainel()-(larguraFundo/2) );
        yCenario = (int)(getCentroYPainel()-(halturaFundo/2) );
        
        backgroundCenario = new Rectangle2D.Double(xCenario+5, yCenario+5, larguraFundo + 5, halturaFundo + 5);
        g2d.drawImage(imagem,xCenario ,yCenario, corFundo, this);
        
        switch (opcao) 
        {
            case 1: 
            
                pintarComLapis(g2d);
                break;

            case 2:
                usarBorracha(g2d);
                
                break;
                
            case 3:

                break;
                
            case 4:
                
                break;
            
            case 25: 
                pintarRetanguloComArestas(g2d);

                break;
                
            case 26: 
                pintarRetanguloSemArestas(g2d);

                break;
                
            case 27: 
                pintarOval(g2d);

                break;           
            
            case 28: 
                pintarReta(g2d);

                break;
             
            default:

        }
       
        pintar();
    }

    public void pintar() 
    {
        this.repaint();
    }

    @Override
    public void run() 
    {
        int i=0;
        
        while (true) 
        {
            try 
            {
                
                Thread.sleep(10000 / 24);
                
            } catch (InterruptedException ex) {}
            
            pintar();
        }
    }

    public void pintarPontos(Color cor) 
    {
        graficoImagem.setColor(cor);
        graficoImagem.setStroke(new BasicStroke(10));
        
        if (pintarPonto) 
        {
            graficoImagem.drawLine((int) pontoInicialX, (int) pontoInicialY, x, y);
            repaint();
        }
    }
    
    public void pintaFundo(Color cor, BufferedImage imagem){
    
//        imagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        graficoImagem.drawImage(imagem, x, y, cor, this);
        
        
         pintar();
    
    }

    public void desenharImagem(BufferedImage img,Graphics2D g2d) 
    {
        g2d.drawImage(img, x, y, this);
    }

    public void desenharImagemFundo(BufferedImage img) 
    {
        
        double scaleX = getWidth() / (double) getLarguraFundo(); 
        double scaleY = getHeight() / (double) getHalturaFundo();  
        AffineTransform xform = AffineTransform.getScaleInstance(scaleX, scaleY);
              
        graficoImagem.drawImage(img, xform, this);

        pintar();
    }
    
    public void limparTudo() 
    {
        imagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
    
    public void atualizarGradiente()
    {
        gradienteGP = new GradientPaint((figuraAtual.getLarguraFigura()/2)+fixoX, fixoY, cor1,
                                        figuraAtual.getLarguraFigura()/2+fixoX,figuraAtual.getHalturaFigura()+fixoY, cor2);
    }
    
    public void pintarRetanguloSemArestas(Graphics2D g2d)
    {
        retanguloRedondo.setGradiente(gradiente);
        figuraAtual = retanguloRedondo;
        atualizarGradiente();
        retanguloRedondo.setGradienteGP(gradienteGP);
        retanguloRedondo.setEspessuraContorno(espessuraContorno);
        
        if(!backgroundCenario.contains((new Point2D.Double(fixoX+10, fixoY+10))))
        {
            retanguloRedondo.setContorno(false);
            retanguloRedondo.setPreencher(false);
        }
        else if( mouseLivre && densenhou)
        {
            retanguloRedondo.setoX(x);
            retanguloRedondo.setoY(y);
            figurasMoviveis.add(retanguloRedondo);
            graficoImagem.drawImage(retanguloRedondo.getImagem(), -xCenario,-yCenario, this);
            
            densenhou =false;
        }
        else if( mousePrecionado )
        {             
            retanguloRedondo.setCorContorno(corContorno);
            retanguloRedondo.setCorFundo(corFundoFigura);
            retanguloRedondo.setContorno(contorno);
            retanguloRedondo.setPreencher(preencher);
            retanguloRedondo.setSelecionado(retanguloRedondo.foiApontado(x,y));
            retanguloRedondo.mover(x, y);
            retanguloRedondo.redimensionar(fixoX,fixoY,(int)x,(int)y);
            retanguloRedondo.desenhar(getWidth(),getHeight());
            retanguloRedondo.mostrarImagem(g2d);
            
            densenhou =true;
        }
        
        pintar();
    }
    
    public void pintarRetanguloComArestas(Graphics2D g2d)
    {
        retanguloQuadrado.setGradiente(gradiente);
        figuraAtual = retanguloQuadrado;
        atualizarGradiente();
        retanguloQuadrado.setGradienteGP(gradienteGP);
        retanguloQuadrado.setEspessuraContorno(espessuraContorno);
        
        if(!backgroundCenario.contains((new Point2D.Double(fixoX+10, fixoY+10))))
        {
            retanguloQuadrado.setContorno(false);
            retanguloQuadrado.setPreencher(false);
        }
        else if( mouseLivre && densenhou)
        {
            retanguloQuadrado.setoX(x);
            retanguloQuadrado.setoY(y);
            figurasMoviveis.add(retanguloQuadrado);
            graficoImagem.drawImage(retanguloQuadrado.getImagem(), -xCenario,-yCenario, this);
            
            densenhou = false;
        }
        else if( mousePrecionado )
        {             
            retanguloQuadrado.setCorContorno(corContorno);
            retanguloQuadrado.setCorFundo(corFundoFigura);
            retanguloQuadrado.setContorno(contorno);
            retanguloQuadrado.setPreencher(preencher);
            retanguloQuadrado.setSelecionado(retanguloQuadrado.foiApontado(x,y));
            retanguloQuadrado.mover(x, y);
            retanguloQuadrado.redimensionar(fixoX,fixoY,(int)x,(int)y);
            retanguloQuadrado.desenhar(getWidth(),getHeight());
            retanguloQuadrado.mostrarImagem(g2d);
            
            densenhou = true;
        }
        
        pintar();
    }

    public void pintarOval(Graphics2D g2d)
    {
        oval.setGradiente(gradiente);
        figuraAtual = oval;
        atualizarGradiente();
        oval.setGradienteGP(gradienteGP);
        oval.setEspessuraContorno(espessuraContorno);
        
        if(!backgroundCenario.contains((new Point2D.Double(fixoX+10, fixoY+10))))
        {
            oval.setContorno(false);
            oval.setPreencher(false);
        }
        else if( mouseLivre && densenhou)
        {
            oval.setoX(x);
            oval.setoY(y);
            figurasMoviveis.add(oval);
            graficoImagem.drawImage(oval.getImagem(), -xCenario,-yCenario, this);
            
            densenhou =false;
        }

        else if( mousePrecionado )
        {             
            oval.setCorContorno(corContorno);
            oval.setCorFundo(corFundoFigura);
            oval.setContorno(contorno);
            oval.setPreencher(preencher);
            oval.setSelecionado(oval.foiApontado(x,y));
            oval.mover(x, y);
            oval.redimensionar(fixoX,fixoY,(int)x,(int)y);
            oval.desenhar(getWidth(),getHeight());
            oval.mostrarImagem(g2d);
            
            densenhou =true;
        }
        
        pintar();
    }

    public void pintarReta(Graphics2D g2d)
    {
        retaTransformavel.setGradiente(gradiente);
        figuraAtual = retaTransformavel;
        atualizarGradiente();
        retaTransformavel.setGradienteGP(gradienteGP);
        retaTransformavel.setEspessuraContorno(espessuraContorno);
        
        if(!backgroundCenario.contains((new Point2D.Double(fixoX+10, fixoY+10))))
        {
            retaTransformavel.setContorno(false);
            retaTransformavel.setPreencher(false);
        }
        else if( mouseLivre && densenhou)
        {
            retaTransformavel.setoX(x);
            retaTransformavel.setoY(y);
            figurasMoviveis.add(retaTransformavel);
            graficoImagem.drawImage(retaTransformavel.getImagem(), -xCenario,-yCenario, this);
            
            densenhou =false;
        }
        else if( mousePrecionado )
        {             
            retaTransformavel.setCorContorno(corContorno);
            retaTransformavel.setContorno(contorno);
            retaTransformavel.setSelecionado(retaTransformavel.foiApontado(x,y));
            retaTransformavel.mover(x, y);
            
            retaTransformavel.redimensionar(fixoX,fixoY,(int)x,(int)y);
            retaTransformavel.desenhar(getWidth(),getHeight());
            
            retaTransformavel.mostrarImagem(g2d);
            
            densenhou =true;
        }
        
        pintar();
    }

    public void pintarComLapis(Graphics2D g2d)
    {
        lapis.setGradiente(gradiente);
        figuraAtual = lapis;
        atualizarGradiente();
        lapis.setGradienteGP(gradienteGP);
        lapis.setEspessuraContorno(espessuraContorno);
        
        if(!backgroundCenario.contains((new Point2D.Double(fixoX+10, fixoY+10))))
        {
            lapis.setContorno(false);
            lapis.setPreencher(false);
        }
        else if( mouseLivre )
        {
            lapis.setoX(x);
            lapis.setoY(y);
            figurasMoviveis.add(lapis);
            graficoImagem.drawImage(lapis.getImagem(), -xCenario,-yCenario, this);
            
            densenhou =false;
        }

        else if( mouseArrastado )
        {             
            lapis.setoX(x);
            lapis.setoY(y);
            
            lapis.setCorContorno(corContorno);
            lapis.setCorFundo(corFundoFigura);
            lapis.setContorno(contorno);
            lapis.setEspessuraContorno(espessuraContorno);
            lapis.setSelecionado(lapis.foiApontado(x,y));
            lapis.desenhar(getWidth(),getHeight());
            lapis.mostrarImagem(g2d);
            
            densenhou =true;
        }
        
        pintar();
    }

    
    public void usarBorracha(Graphics2D g2d)
    {
        borracha.setGradiente(gradiente);
        figuraAtual = borracha;
        atualizarGradiente();
        borracha.setGradienteGP(gradienteGP);
        borracha.setEspessuraContorno(espessuraContorno);
        
        if(!backgroundCenario.contains((new Point2D.Double(fixoX+10, fixoY+10))))
        {
            borracha.setContorno(false);
            borracha.setPreencher(false);
        }
        else if( mouseLivre )
        {
            borracha.setoX(x);
            borracha.setoY(y);
            figurasMoviveis.add(borracha);
            graficoImagem.drawImage(borracha.getImagem(), -xCenario,-yCenario, this);
            
            densenhou =false;
        }

        else if( mouseArrastado )
        {             
            borracha.setoX(x);
            borracha.setoY(y);
            
            borracha.setCorContorno(corFundo);
            borracha.setLarguraFigura(20);
            borracha.setHalturaFigura(20);
            borracha.setContorno(contorno);
            borracha.setEspessuraContorno(espessuraContorno);
            borracha.setSelecionado(borracha.foiApontado(x,y));
            borracha.desenhar(getWidth(),getHeight());
            borracha.mostrarImagem(g2d);
            
            densenhou =true;
        }
        
        pintar();
    }

    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        x=e.getX();
        x=e.getX();

        pintar();
    }

    public void selecionarFiguras(MouseEvent e)
    {
        RetanguloSemArestasTransformavel figuraAux = new RetanguloSemArestasTransformavel();
        
        for(FiguraTransFormavel f: figuras)
        {
//            if(f.isSelecionado(e.getPoint())) 
//            {
//                f.setPrencher(desenhar =(desenhar)?false: true);                
//                break;
//            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) 
    {
        if(retanguloRedondo.foiApontado(new Point2D.Double(x, y)))
        {
            retanguloRedondo.setSelecionado((retanguloRedondo.isSelecionado())?false:true);
        }
        mousePrecionado=true;
        
        mouseLivre =false;
        pontoInicialX = e.getX();
        pontoInicialY = e.getY();
        fixoX=e.getX();
        fixoY=e.getY();
        mover = true;
        pintarPonto = true;
        desenhar = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        mover = false;
        pintarPonto = false;
        desenhar = false;
        mousePrecionado=false;
        mouseLivre =true;
        mouseArrastado=false;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        x=e.getX();
        x=e.getX();
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
        
        mouseArrastado = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        
    }

    /**
     * @return the textura
     */
    public boolean isTextura() {
        return textura;
    }

    /**
     * @param textura the textura to set
     */
    public void setTextura(boolean textura) {
        this.textura = textura;
    }
    
    
    
    
}