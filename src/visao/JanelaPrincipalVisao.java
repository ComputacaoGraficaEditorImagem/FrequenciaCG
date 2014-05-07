
package visao;

import controlo.FicheiroControlo;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.BorderUIResource;

public final class JanelaPrincipalVisao extends JFrame
{
    
    private FundoInicial telaInicial;
    
    private BufferedImage bufferedImage;
    
     private BufferedImage buffer;
    
    private JCheckBox corCheck;
    
    private JCheckBox texturaCheck;
    
    String caminho;
    
    JButton novoPalco = new JButton("Novo");
    JButton abrirFicheiro = new JButton("Abrir");
    JButton sairAplicacao = new JButton("Sair");
    JLabel imgLogo;
    private ImageIcon icone;
    private JMenuBar barraMenuJMB;
    private JMenu ficheiroJM;
    private JMenu sobreJM;
    private JMenuItem sobreAplicacaoJM;
    private JMenuItem sobreAutorJM;
    private JMenuItem salvarJMI;
    private JMenuItem novoJMI;
    private JMenuItem abrirJMI;
    private JMenuItem sairJMI;
    
    private ImageIcon novoIMG;
    
    PropriedadesPainel propriedades;
    
    private JPopupMenu menuPopuptelaPainelTAB;
    private JMenuItem recortarJMI;
    private JMenuItem copiarJMI;
    private JMenuItem colarJMI;
    private JMenu outrasOpcoesJM;
    private JMenuItem mudarFundoJMI;
    private JMenuItem fecharTabuladorJMI;
    
    
    private BevelBorder borderRelevo;
    private BevelBorder borderDepressao;
    private CompoundBorder borderComposto ;
    
    private TitledBorder desenhoBorder;
    private TitledBorder exibirBorder;
    private TitledBorder figuraBorder;
    private TitledBorder fundoBorder;
    private TitledBorder corBorder;
    private TitledBorder texturaBorder;
    private TitledBorder imagemBorder;
    
    private FundoPropriedade desenhoJP;
    private FundoPropriedade exibirJP;
    private FundoPropriedade figuraJP;
    private FundoPropriedade imagemJP;
    
    private FundoPropriedade fundoPainel;
       
    private JButton lapisJBT;
    private JButton pincelJBT;
    private JButton textoJBT;
    private JButton selecionarJBT;
    private JButton borrachaJBT;
    
    private JButton trianguloRetanguloJBT;
    private JButton losangoJBT;
    private JButton trianguloEquilateroJBT;
    private JButton pentagnoJBT;
    private JButton setaFrenteJBT;
    private JButton setaTrasJBT;
    private JButton setaCimaJBT;
    private JButton setaBaixoJBT;
    private JButton estrelaDe4JBT;
    private JButton estrelaDe5JBT;
    private JButton estrelaDe6JBT;
    private JButton trovoadaJBT;
    private JButton dialogoQuadrangularJBT;
    private JButton dialogoOvalJBT;
    private JButton imaginacaoJBT;
    private JButton coracaoJBT;
    private JButton retanguloComArestaJBT;
    private JButton retanguloSemArestasJBT;
    private JButton ovalJBT;
    private JButton retaJBT;
    private JButton estrelaJBT;
    private JButton maisFigurasJBT;
    
    private BackgroundButton fundo1BB;
    private BackgroundButton fundo2BB;
    private BackgroundButton fundo3BB;
    private BackgroundButton fundo4BB;
    
    private BackgroundButton fundo5BB;
    private BackgroundButton fundo6BB;
    private BackgroundButton fundo7BB;
    private BackgroundButton fundo8BB;
    
    private BackgroundButton fundo9BB;
    private BackgroundButton fundo10BB;
    private BackgroundButton fundo11BB;
    private BackgroundButton fundo12BB;
    
    private BackgroundButton fundo13BB;
    private BackgroundButton fundo14BB;
    private BackgroundButton fundo15BB;
    private BackgroundButton fundo16BB;
    
    private JCheckBox ContornoJCB;
    private JComboBox<String> ContornoJCMB;
    private JButton corContornoJBT;
    
    private JCheckBox preencherJCB;
    private JButton primeiraCorPreencherJBT;
    private JButton segundaCorPreencherJBT;
    private JPanelCorgradiente gradienteJPC;
            
    private ImageIcon pincelIMG;
    private ImageIcon textoIMG;
    private ImageIcon selecionarIMG;
    private ImageIcon borrachaIMG;
    private ImageIcon lapisIMG;
    
    
    private ImageIcon imgFundo1;
    private ImageIcon imgFundo2;
    private ImageIcon imgFundo3;
    private ImageIcon imgFundo4;
    
    private ImageIcon imgFundo5;
    private ImageIcon imgFundo6;
    private ImageIcon imgFundo7;
    private ImageIcon imgFundo8;
    
    private ImageIcon imgFundo9;
    private ImageIcon imgFundo10;
    private ImageIcon imgFundo11;
    private ImageIcon imgFundo12;
    
    private ImageIcon imgFundo13;
    private ImageIcon imgFundo14;
    private ImageIcon imgFundo15;
    private ImageIcon imgFundo16;
    
    
    private ImageIcon trianguloRetanguloIMG;
    private ImageIcon trianguloEquilateroIMG;
    private ImageIcon losangoIMG;
    private ImageIcon pentagnoIMG;
    private ImageIcon setaFrenteIMG;
    private ImageIcon setaTrasIMG;
    private ImageIcon setaCimaIMG;
    private ImageIcon setaBaixoIMG;
    private ImageIcon estrelaDe4IMG;
    private ImageIcon estrelaDe5IMG;
    private ImageIcon estrelaDe6IMG;
    private ImageIcon trovoadaIMG;
    
    private ImageIcon dialogoQuadrangularIMG;
    private ImageIcon dialogoOvalIMG;
    private ImageIcon imaginacaoIMG;
    private ImageIcon coracaoIMG;
   
    private ImageIcon retanguloComArestaIMG;
    private ImageIcon retanguloSemArestasIMG;
    private ImageIcon ovalIMG;
    private ImageIcon retaIMG;
    private ImageIcon estrelaIMG;
    
    private ImageIcon ContornoIMG;
    
    private ImageIcon preencherIMG;
    private ImageIcon gradienteIMG;
    
    private ImageIcon seleCoresIMG;
    
    
    private TelaPainelVisao telaJP;
        
    private Fundo painelOpcoesJRP;
    
    private JTabbedPane telaPainelTAB;
    private JTabbedPane paineisOpcoesTAB;
       
    private GridBagLayout layoutGBL;
    private GridBagConstraints decoradorGBC;
    
    private Container contentor;
    
    private Font fonte;
    private Font fonteCheck;
    
    private Color cor;
    
    private Color primeiraCorPreencher;
    private Color segundaCorPreencher;
    
    private JFileChooser ficheirosJFS;
    private JColorChooser coresJCS;
    
    
    private TrataEventosMenus ouvinteItens;
    private int paineisEmEdicao;
    private JSeparator separadorJS;
    private final JMenuItem inserirJM;
    private final JMenuItem imagemJMI;
    private final JMenuItem figuraJMI;
    private ArrayList<TelaPainelVisao> telasEmEdicao;   
    private TrataEventosBotoes ouvinteBotoes;
    
   
    JButton btnCorBranca, btnCorCastanhoClaro,btnCorVermelha, btnCorCastanhoEscuro, btnCorCastanho, btnCorRosa, btnCorAmarela, btnCorAzulClaro, btnCorVerde,btnCoAzulEscuro, btnCorPreta, btnCor;
    BackgroundButton btnSeleCor;
    
    private Color Cor_da_Figura = Color.BLACK;
    private Color Ultima_Cor = Color.BLACK;
    
    private FundoPropriedade corJP;
    private FundoPropriedade texturaJP;
    
    public JanelaPrincipalVisao()
    {
        super("ImageWork 1.0");
        
        
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/imgWork.png"));
        
         imgLogo = new JLabel(icon);
        ficheirosJFS = new JFileChooser();
        coresJCS = new JColorChooser(Color.yellow);

        cor=Color.BLUE;
        
        primeiraCorPreencher = Color.cyan;
        segundaCorPreencher = Color.GRAY;
        ouvinteItens = new TrataEventosMenus();
        ouvinteBotoes = new TrataEventosBotoes();
        
        telasEmEdicao = new ArrayList<>();
        separadorJS = new JSeparator(JSeparator.HORIZONTAL);
        
        Dimension minSize =new Dimension(900,700);
        
        setMinimumSize(minSize);

        String caminho = FicheiroControlo.criaCaminhoFicheiro("imagens","imageWork.png");
        setLayout(new BorderLayout(10, 10));
               
        layoutGBL = new GridBagLayout();
        decoradorGBC = new GridBagConstraints();
        
        contentor=new Container();
        contentor.setLayout(layoutGBL);
        
        borderRelevo=new BevelBorder(BevelBorder.RAISED);
        borderDepressao=new BevelBorder(BevelBorder.LOWERED);
        borderComposto=new CompoundBorder(borderRelevo, borderDepressao);
        
        fonte=new Font("Times New Roman", Font.PLAIN, 20);
        Color c = Color.WHITE;
        desenhoBorder= new TitledBorder(borderComposto, " Desenho ",  TitledBorder.LEFT,TitledBorder.TOP, fonte,c);
        exibirBorder= new TitledBorder(borderComposto, " Exibir ", TitledBorder.LEFT,TitledBorder.TOP,  fonte,c);
        figuraBorder= new TitledBorder(borderComposto, " Figura ", TitledBorder.LEFT, TitledBorder.TOP, fonte,c);
        fundoBorder= new TitledBorder(borderComposto, " Background ", TitledBorder.LEFT, TitledBorder.TOP, fonte,c);
        corBorder= new TitledBorder(borderComposto, " Cores ", TitledBorder.LEFT, TitledBorder.TOP, fonte,c);
        texturaBorder= new TitledBorder(borderComposto, " Texturas ", TitledBorder.LEFT, TitledBorder.TOP, fonte,c);
        imagemBorder= new TitledBorder(borderComposto, " Imagem ",  TitledBorder.LEFT,TitledBorder.TOP, fonte,c);
        
        aprontarDesenhoJP();
        aprontarFiguraJP();
        aprontarFundoPainel();
        
        
        telaInicial = new FundoInicial();
        
        telaJP=new TelaPainelVisao();
        telaJP.setLarguraFundo(700);
        telaJP.setHalturaFundo(700);
        telaJP.setCorContorno(corContornoJBT.getBackground());
        telaJP.setCorFundoFigura(primeiraCorPreencherJBT.getBackground());

        
        exibirJP=new FundoPropriedade(layoutGBL);

        imagemJP=new FundoPropriedade(layoutGBL);
              
        
        desenhoJP.setBorder(desenhoBorder);
        exibirJP.setBorder(exibirBorder);
        figuraJP.setBorder(figuraBorder);
        fundoPainel.setBorder(fundoBorder);
        corJP.setBorder(corBorder);
        texturaJP.setBorder(texturaBorder);

        borderComposto = new CompoundBorder( borderDepressao,borderRelevo);
                        
        painelOpcoesJRP = new Fundo();
        painelOpcoesJRP.setLayout(layoutGBL);
        
        //IPADX & Y
        dimensaoExata(90,10);
        decoradorGBC.insets = new Insets(5, 5, 5, 5);

        coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        adicionarItensAoPainel(desenhoJP,painelOpcoesJRP);
        
        dimensaoExata(10,10);
        coordenar(0,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        adicionarItensAoPainel(figuraJP,painelOpcoesJRP);
        
        decoradorGBC.insets = new Insets(5, 5, 5, 5);
        dimensaoExata(10,10);
        coordenar(0,2,1,1,GridBagConstraints.WEST,GridBagConstraints.NONE);
        adicionarItensAoPainel(fundoPainel,painelOpcoesJRP);
        
        decoradorGBC.insets = new Insets(5, 5, 30, 5);
        coordenar(0,3,1,1,GridBagConstraints.WEST,GridBagConstraints.NONE);
//        adicionarItensAoPainel(imagemJP,painelOpcoesJRP);        
                
        icone = new ImageIcon(caminho);
        barraMenuJMB = new JMenuBar();
        
        ficheiroJM = new JMenu("Ficheiro");
        sobreJM = new JMenu("Ajuda");
        
        
        sobreAplicacaoJM  = new JMenuItem("Sobre Aplicação");
        sobreAutorJM = new JMenuItem("Sobre Desenvolvedores");
        
        
        salvarJMI = new JMenuItem("Salvar");
        novoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "tela.png"));
        novoJMI = new JMenuItem("Novo",novoIMG);
        abrirJMI = new JMenuItem("Abrir");
        sairJMI = new JMenuItem("Sair");
        
        menuPopuptelaPainelTAB = new JPopupMenu("Tela de desenho");
        recortarJMI = new JMenuItem("Recortar");
        copiarJMI = new JMenuItem("Copiar");
        colarJMI = new JMenuItem("Colar");
        fecharTabuladorJMI = new JMenuItem("Fechar");
        mudarFundoJMI = new JMenuItem("Mudar cor do  Fundo");
        
        inserirJM = new JMenu("Inserir");
        imagemJMI = new JMenuItem("Imagem");
        figuraJMI = new JMenuItem("Figura");
        
        outrasOpcoesJM = new JMenu("Outras opções");
        
        //MenuPopup
        adicionarItensAosJPopupMenus(menuPopuptelaPainelTAB,recortarJMI,copiarJMI,colarJMI,outrasOpcoesJM,fecharTabuladorJMI);
        //MenuInserir
        adicionarItensAoJMenu(inserirJM,imagemJMI,figuraJMI);
        //MenuOutrasOpções
        adicionarItensAoJMenu(outrasOpcoesJM,mudarFundoJMI,inserirJM);
        
        animarItensMenu(recortarJMI,copiarJMI,colarJMI,outrasOpcoesJM,imagemJMI,fecharTabuladorJMI,mudarFundoJMI);        
                
        
        ficheiroJM.setMnemonic(KeyEvent.VK_F);
        novoJMI.setMnemonic(KeyEvent.VK_N);
        
        animarItensMenu(ficheiroJM,abrirJMI,novoJMI,sairJMI,salvarJMI);
        animarItensMenu(sobreJM,sobreAplicacaoJM,sobreAutorJM);
        
        paineisEmEdicao++;
        
        telaPainelTAB = new JTabbedPane(1);
        
        paineisOpcoesTAB = new JTabbedPane(1);
        
        telaJP.setBackground(new Color(255,255,255,255));
        telaJP.setMinimumSize(new Dimension(5000, 5000));
//        JScrollPane roll= new JScrollPane(telaInicial, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
// 
//        roll.setAutoscrolls(true);
        
        telaInicial.setLayout(new GridBagLayout());
		
  	telaInicial.add(imgLogo,  new GridBagConstraints(8, 1, 2, 1, 0, 0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));
        telaInicial.add(novoPalco,  new GridBagConstraints(0, 0, 1, 1, 0, 0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 40), 40, 20));
        telaInicial.add(abrirFicheiro,  new GridBagConstraints(0, 1, 1, 1, 0, 0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 40), 40, 20));
        telaInicial.add(sairAplicacao,  new GridBagConstraints(0, 2, 1, 1, 0, 0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 40), 40, 20));
             
        novoPalco.addActionListener(new TrataEventosMenus());
        abrirFicheiro.addActionListener(new TrataEventosMenus());
        sairAplicacao.addActionListener(new TrataEventosMenus());
        sobreAplicacaoJM.addActionListener(new TrataEventosMenus());
        
      
        telaPainelTAB.add("Página inicial", telaInicial);
       
        telasEmEdicao.add(telaJP);
        telaJP.addMouseListener(new TrataEventosMouse());
        
        telaPainelTAB.addMouseListener(new TrataEventosMouse());
        paineisEmEdicao++;
        
        telaPainelTAB.addMouseListener(new TrataEventosMouse());
        
        paineisOpcoesTAB.add("Base",painelOpcoesJRP);
        

        dimensaoExata(0, 0);
        decoradorGBC.weightx=0.01;
        decoradorGBC.weighty=0.9;
        decoradorGBC.insets = new Insets(10, 10, 10, 5);
        
        coordenar(0,0,1,1,GridBagConstraints.SOUTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(paineisOpcoesTAB,contentor);
        
        dimensaoExata(0, 200);
        decoradorGBC.weightx=0.5;
        decoradorGBC.weighty=0.5;
        decoradorGBC.insets = new Insets(10, 10, 10, 10);
        
        coordenar(1,0,2,1,GridBagConstraints.SOUTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(telaPainelTAB,contentor);
                
        adicionarItensAoJMenu(ficheiroJM,abrirJMI,salvarJMI,novoJMI);
        adicionarItensAoJMenu(sobreJM, sobreAplicacaoJM,sobreAutorJM);
        ficheiroJM.add(separadorJS);
        ficheiroJM.add(sairJMI);
        adicionarMenusABarraMenuJMB(ficheiroJM,sobreJM);
        setJMenuBar(barraMenuJMB);
        add(contentor);
        addMouseListener(new TrataEventosMouse());
        setIconImage(icone.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }
    

    public void coordenar(int ... coodenadas)
    {
        decoradorGBC.gridx=coodenadas[0];
        decoradorGBC.gridy=coodenadas[1];
        
        decoradorGBC.gridwidth=coodenadas[2];
        decoradorGBC.gridheight=coodenadas[3];
        
        decoradorGBC.anchor=coodenadas[4];
        decoradorGBC.fill=coodenadas[5];
    }
        
    public void dimensaoExata(int largura,int haltura)
    {
       decoradorGBC.ipadx=largura;
       decoradorGBC.ipady=haltura;
    }

    public void adicionarItensAoPainel(JComponent componente,Container contentor)
    {
        layoutGBL.setConstraints(componente,decoradorGBC);
        contentor.add(componente);
    }
    
    public void adicionarMenusABarraMenuJMB(JMenu ... itens)
    {
        for(JMenu item:itens)
        {
           barraMenuJMB.add(item);
        }
    }

    public void aprontarDesenhoJP()
    {
        desenhoJP=new FundoPropriedade(layoutGBL);
        dimensaoExata(0, 0);

        decoradorGBC.weightx=0.0;
        decoradorGBC.weighty=0.0;
        decoradorGBC.insets = new Insets(2, 2, 2, 2);
               
        pincelIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "pincel1.png"));
        textoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "texto.png"));
        selecionarIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "seta.png"));
        borrachaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "borracha.png"));
        lapisIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "lapis.png"));
        
        lapisJBT=new JButton(lapisIMG);
        pincelJBT=new JButton(pincelIMG);
        textoJBT=new JButton(textoIMG);
        selecionarJBT=new JButton(selecionarIMG);
        borrachaJBT=new JButton(borrachaIMG);
       
        //ADICIONA A LINHA 0 
        {
            coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(lapisJBT ,desenhoJP);

            coordenar(1,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(borrachaJBT,desenhoJP);
            
            coordenar(2,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(selecionarJBT,desenhoJP);
        }//FIM ADICIONA A LINHA 0 
        
        animarBotoes(lapisJBT,pincelJBT,textoJBT,selecionarJBT,borrachaJBT);
        
    }
    
    
    public void aprontarPainelCor()
    {   
        
        corJP = new FundoPropriedade(layoutGBL);
        dimensaoExata(20, 20);
        decoradorGBC.insets = new Insets(0, 0, 0, 0);
        decoradorGBC.weightx=0.0;
        decoradorGBC.weighty=0.0;
        
        corCheck  = new JCheckBox("Activar");
//        fonteCheck = new Font("Times New Roman", Font.PLAIN, 16);
//        corCheck.setFont(fonteCheck);
        
        btnCorBranca = new JButton();
        btnCorBranca.setBackground(Color.white);
        btnCorAzulClaro = new JButton();
        btnCorAzulClaro.setBackground(Color.CYAN);
        btnCorCastanhoClaro = new JButton();
        btnCorCastanhoClaro.setBackground(Color.LIGHT_GRAY);
        btnCorCastanho = new JButton();
        btnCorCastanho.setBackground(Color.GRAY);
        btnCorCastanhoEscuro = new JButton();
        btnCorCastanhoEscuro.setBackground(Color.DARK_GRAY);
        btnCorPreta = new JButton();
        btnCorPreta.setBackground(Color.black);
        btnCoAzulEscuro = new JButton();
        btnCoAzulEscuro.setBackground(Color.BLUE);
        btnCorVerde = new JButton();
        btnCorVerde.setBackground(Color.GREEN);
        btnCorAmarela = new JButton();
        btnCorAmarela.setBackground(Color.yellow);
        btnCorRosa = new JButton();
        btnCorRosa.setBackground(Color.pink);
        btnCorVermelha = new JButton();
        btnCorVermelha.setBackground(Color.red); 
     
        btnSeleCor = new BackgroundButton(new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "Cores.png")));
      
        
        coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorBranca, corJP);
        coordenar(1,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorCastanhoClaro, corJP);
        coordenar(2,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorCastanho, corJP);
        coordenar(3,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorCastanhoEscuro, corJP);
        
        coordenar(0,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorPreta, corJP);
        coordenar(1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorRosa, corJP);
        coordenar(2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorVermelha, corJP);
        coordenar(3,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(btnCorAmarela, corJP);
        
        coordenar(0,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        adicionarItensAoPainel(btnCorAzulClaro, corJP);
        coordenar(1,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        adicionarItensAoPainel(btnCorVerde, corJP);
        coordenar(2,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        adicionarItensAoPainel(btnCoAzulEscuro, corJP);
        coordenar(3,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        adicionarItensAoPainel(btnSeleCor, corJP);
        
        dimensaoExata(1, 1);
        coordenar(0,3,4,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        adicionarItensAoPainel(corCheck, corJP);
        
        btnCorBranca.addActionListener(new TrataEventosMenus()); 
        btnCorAzulClaro.addActionListener(new TrataEventosMenus()); 
        btnCorCastanhoClaro.addActionListener(new TrataEventosMenus()); 
        btnCorCastanho.addActionListener(new TrataEventosMenus()); 
        btnCorCastanhoEscuro.addActionListener(new TrataEventosMenus()); 
        btnCorPreta.addActionListener(new TrataEventosMenus()); 
        btnCoAzulEscuro.addActionListener(new TrataEventosMenus()); 
        btnCorVerde.addActionListener(new TrataEventosMenus()); 
        btnCorAmarela.addActionListener(new TrataEventosMenus()); 
        btnCorRosa.addActionListener(new TrataEventosMenus()); 
        btnCorVermelha.addActionListener(new TrataEventosMenus()); 
        btnSeleCor.addActionListener(new TrataEventosMenus()); 
        
        btnCorBranca.setEnabled (false); 
        btnCorAzulClaro.setEnabled (false);
        btnCorCastanhoClaro.setEnabled (false); 
        btnCorCastanho.setEnabled (false);
        btnCorCastanhoEscuro.setEnabled (false); 
        btnCorPreta.setEnabled (false); 
        btnCoAzulEscuro.setEnabled (false);
        btnCorVerde.setEnabled (false); 
        btnCorAmarela.setEnabled (false); 
        btnCorRosa.setEnabled (false); 
        btnCorVermelha.setEnabled (false); 
        btnSeleCor.setEnabled (false);
        
        corCheck.addActionListener(new TrataEventoCheckBox());

    }
    
    public void aprontarPainelTextura()
    {
    
        
        texturaJP = new FundoPropriedade(layoutGBL);
        dimensaoExata(20, 40);
        decoradorGBC.insets = new Insets(0, 0, 0, 0);
        decoradorGBC.weightx=0.0;
        decoradorGBC.weighty=0.0;
        
        texturaCheck = new JCheckBox("Activar");
//        fonteCheck = new Font("Times New Roman", Font.PLAIN, 16);
//        texturaCheck.setFont(fonteCheck);
//        
        
        imgFundo1 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo1.jpg"));
        imgFundo2 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo2.jpg"));
        imgFundo3= new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo3.jpg"));
        imgFundo4 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo4.jpg"));
        
        imgFundo5 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo5.jpg"));
        imgFundo6 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo6.jpg"));
        imgFundo7= new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo7.jpg"));
        imgFundo8 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo8.png"));
        
        imgFundo9 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo9.jpg"));
        imgFundo10 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo10.jpg"));
        imgFundo11 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo11.jpg"));
        imgFundo12 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo12.jpg"));
        
        imgFundo13 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo13.jpg"));
        imgFundo14 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo14.jpg"));
        imgFundo15 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo15.jpg"));
        imgFundo16 = new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo16.jpg"));
        
        fundo1BB = new BackgroundButton(imgFundo1);
        fundo2BB = new BackgroundButton(imgFundo2);
        fundo3BB = new BackgroundButton(imgFundo3);
        fundo4BB = new BackgroundButton(imgFundo4);
        
        fundo5BB = new BackgroundButton(imgFundo5);
        fundo6BB = new BackgroundButton(imgFundo6);
        fundo7BB = new BackgroundButton(imgFundo7);
        fundo8BB = new BackgroundButton(imgFundo8);
        
        fundo9BB = new BackgroundButton(imgFundo9);
        fundo10BB = new BackgroundButton(imgFundo10);
        fundo11BB = new BackgroundButton(imgFundo11);
        fundo12BB = new BackgroundButton(imgFundo12);
        
        fundo13BB = new BackgroundButton(imgFundo13);
        fundo14BB = new BackgroundButton(imgFundo14);
        fundo15BB = new BackgroundButton(imgFundo15);
        fundo16BB = new BackgroundButton(imgFundo16);
     
        coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo1BB,texturaJP);
        coordenar(1,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo2BB,texturaJP);
        coordenar(2,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo3BB,texturaJP);
        coordenar(3,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo4BB,texturaJP);
        
        coordenar(0,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo5BB,texturaJP);
        coordenar(1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo6BB,texturaJP);
        coordenar(2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo7BB,texturaJP);
        coordenar(3,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo8BB,texturaJP);
        
        coordenar(0,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo9BB,texturaJP);
        coordenar(1,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo10BB,texturaJP);
        coordenar(2,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo11BB,texturaJP);
        coordenar(3,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo12BB,texturaJP);
        
        coordenar(0,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo13BB,texturaJP);
        coordenar(1,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo14BB,texturaJP);
        coordenar(2,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo15BB,texturaJP);
        coordenar(3,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(fundo16BB,texturaJP);
        
        dimensaoExata(1, 1);
        coordenar(0,4,4,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(texturaCheck,texturaJP);
        
        texturaCheck.addActionListener(new TrataEventoCheckBox());
        
        fundo1BB.setEnabled(false);
        fundo2BB.setEnabled(false);
        fundo3BB.setEnabled(false);
        fundo4BB.setEnabled(false);
        fundo5BB.setEnabled(false);
        fundo6BB.setEnabled(false);
        fundo7BB.setEnabled(false);
        fundo8BB.setEnabled(false);
        fundo9BB.setEnabled(false);
        fundo10BB.setEnabled(false); 
        fundo11BB.setEnabled(false);
        fundo12BB.setEnabled(false);
        fundo13BB.setEnabled(false);
        fundo14BB.setEnabled(false);
        fundo15BB.setEnabled(false);
        fundo16BB.setEnabled(false);
        
        fundo1BB.addActionListener(new TrataEventosMenus()); 
        fundo2BB.addActionListener(new TrataEventosMenus()); 
        fundo3BB.addActionListener(new TrataEventosMenus()); 
        fundo4BB.addActionListener(new TrataEventosMenus()); 
        fundo5BB.addActionListener(new TrataEventosMenus()); 
        fundo6BB.addActionListener(new TrataEventosMenus()); 
        fundo7BB.addActionListener(new TrataEventosMenus()); 
        fundo8BB.addActionListener(new TrataEventosMenus()); 
        fundo9BB.addActionListener(new TrataEventosMenus()); 
        fundo10BB.addActionListener(new TrataEventosMenus()); 
        fundo11BB.addActionListener(new TrataEventosMenus());
        fundo12BB.addActionListener(new TrataEventosMenus());
        fundo13BB.addActionListener(new TrataEventosMenus());
        fundo14BB.addActionListener(new TrataEventosMenus());
        fundo15BB.addActionListener(new TrataEventosMenus());
        fundo16BB.addActionListener(new TrataEventosMenus());


    }

    public void aprontarFundoPainel(){
    
        fundoPainel = new FundoPropriedade(layoutGBL);
        dimensaoExata(48, 40);
        decoradorGBC.insets = new Insets(2, 2, 2, 2);
        decoradorGBC.weightx=0.0;
        decoradorGBC.weighty=0.0;
        
        aprontarPainelCor();
        aprontarPainelTextura();

//
//        JScrollPane roll= new JScrollPane(texturaJP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
// 
//        roll.setPreferredSize(new Dimension(20,100));
        

        dimensaoExata(10, 10);
        coordenar(0,0,4,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(corJP,fundoPainel);
        coordenar(0,1,4,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(texturaJP,fundoPainel);

        
  
    }
    public void aprontarFiguraJP()
    {
        figuraJP=new FundoPropriedade(layoutGBL);
        dimensaoExata(0, 0);
        decoradorGBC.insets = new Insets(2, 2, 2, 2);

        decoradorGBC.weightx=0.0;
        decoradorGBC.weighty=0.0;
        
        
        trianguloRetanguloIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "trianguloRetangulo.png"));
        trianguloEquilateroIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "trianguloEquilatero.png"));
        losangoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "lozango.png"));
        pentagnoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "pentagno.png"));
        setaFrenteIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "seta frente.png"));
        setaTrasIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "seta trás.png"));
        setaCimaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "seta cima.png"));
        setaBaixoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "seta baixo.png"));
        estrelaDe4IMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "estrela de 4 pes.png"));
        estrelaDe5IMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "estrela de 5 pes.png"));
        estrelaDe6IMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "estrela de 6 pes.png"));
        trovoadaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "trovoada.png"));
        dialogoQuadrangularIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "dialogo qudrangular.png"));
        dialogoOvalIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "dialogo oval.png"));
        imaginacaoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "imaginação.png"));
        coracaoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "coração.png"));
        //comessa aqui
        ContornoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "contorno.png"));
    
        preencherIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "preenchimento.png"));
        gradienteIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "gradiente.png"));
        //Termina aqui
        
        trianguloRetanguloJBT=new JButton(trianguloRetanguloIMG);
        trianguloEquilateroJBT=new JButton( trianguloEquilateroIMG);
        losangoJBT=new JButton(losangoIMG);
        pentagnoJBT=new JButton( pentagnoIMG);
        setaFrenteJBT=new JButton( setaFrenteIMG);
        setaTrasJBT=new JButton(setaTrasIMG);
        setaCimaJBT=new JButton(setaCimaIMG);
        setaBaixoJBT=new JButton(setaBaixoIMG);
        estrelaDe4JBT=new JButton( estrelaDe4IMG);
        estrelaDe5JBT=new JButton( estrelaDe5IMG);
        estrelaDe6JBT=new JButton( estrelaDe6IMG);
        trovoadaJBT=new JButton( trovoadaIMG);
        dialogoQuadrangularJBT=new JButton( dialogoQuadrangularIMG);
        dialogoOvalJBT=new JButton( dialogoOvalIMG);
        imaginacaoJBT=new JButton( imaginacaoIMG);
        coracaoJBT=new JButton( coracaoIMG);
        
        
        retanguloComArestaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "retangulo com  arestas.png"));
        retanguloSemArestasIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "retangulo sem  arestas.png"));
        ovalIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "circulo.png"));
        retaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "reta.png"));
        estrelaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "borracha.png"));
        
        retanguloComArestaJBT=new JButton(retanguloComArestaIMG);
        retanguloSemArestasJBT=new JButton(retanguloSemArestasIMG);
        ovalJBT=new JButton(ovalIMG);
        retaJBT=new JButton(retaIMG);
        estrelaJBT=new JButton(estrelaIMG);
        maisFigurasJBT = new JButton("+");
        
        //comessa aqui
        ContornoJCB = new JCheckBox("cotorno",true);
        
        ContornoJCMB = new JComboBox<>();
        inicializarContornos();
        ContornoJCMB.setToolTipText("Espessura do contorno em pixels");
        ContornoJCMB.setEditable(true);

        
        corContornoJBT = new JButton("   ");
        corContornoJBT.setBackground(Color.BLACK);
        corContornoJBT.setToolTipText("Cor do contorno");
        
        preencherJCB = new JCheckBox("Preencher");
        primeiraCorPreencherJBT = new JButton("    ");
        primeiraCorPreencherJBT.setBackground(primeiraCorPreencher);
        primeiraCorPreencherJBT.setEnabled(false);
        primeiraCorPreencherJBT.setToolTipText("A primera das duas cores a combinar");
        
        segundaCorPreencherJBT =  new JButton("    ");
        segundaCorPreencherJBT.setBackground(segundaCorPreencher);
        segundaCorPreencherJBT.setEnabled(false);
        segundaCorPreencherJBT.setToolTipText("A segunda das duas cores a combinar");
        
        gradienteJPC = new JPanelCorgradiente(Color.CYAN,Color.GRAY);
        gradienteJPC.setPonto1(new Point2D.Double(25, 0));
        gradienteJPC.setPonto2(new Point2D.Double(25, 15));
        gradienteJPC.setEnabled(false);
        animarPainelGradiente();
        
        //termina aqui
        
        //ADICIONAR À LINHA 0
        {
            coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(retanguloComArestaJBT,figuraJP);

            coordenar(1,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(retanguloSemArestasJBT,figuraJP);

            coordenar(2,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(ovalJBT,figuraJP);

            coordenar(3,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(retaJBT,figuraJP);
        }//FIM ADICIONAR À LINHA 0
        
        
        //ADICIONAR À LINHA 1
        {
            coordenar(0,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(setaFrenteJBT,figuraJP);

            coordenar(1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(setaTrasJBT,figuraJP);

            coordenar(2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(setaCimaJBT,figuraJP);

            coordenar(3,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(setaBaixoJBT,figuraJP);
        }//FIM ADICIONAR À LINHA 1
        
        
        //ADICIONAR À LINHA 2
        {
            coordenar(0,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(estrelaDe4JBT,figuraJP);

            coordenar(1,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(estrelaDe5JBT,figuraJP);

            coordenar(2,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(estrelaDe6JBT,figuraJP);

            coordenar(3,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
            adicionarItensAoPainel(trovoadaJBT,figuraJP);
        }//FIM ADICIONAR À LINHA 2
        
        //ADICIONAR À LINHA 3
        {
            coordenar(0,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(dialogoQuadrangularJBT,figuraJP);

            coordenar(1,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(dialogoOvalJBT,figuraJP);

            coordenar(2,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(imaginacaoJBT,figuraJP);

            coordenar(3,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(coracaoJBT,figuraJP);
        }//FIM ADICIONAR À LINHA 3
        
        //ADICIONAR À LINHA 4
        {
            coordenar(0,4,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(trianguloRetanguloJBT,figuraJP);

            coordenar(1,4,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(trianguloEquilateroJBT,figuraJP);

            coordenar(2,4,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(losangoJBT,figuraJP);

            coordenar(3,4,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(pentagnoJBT,figuraJP);
        }//FIM ADICIONAR À LINHA 4
        
        //ADICIONAR A LINHA 5
        {
            coordenar(0,5,4,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
            adicionarItensAoPainel(maisFigurasJBT,figuraJP);
        }//FIM ADICIONAR A LINHA 5
        
        //ADICIONAR A LINHA 6
        {
            coordenar(0,6,4,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
            adicionarItensAoPainel(new JSeparator(JSeparator.HORIZONTAL),figuraJP);
        }//FIM ADICIONAR A LINHA 6
        
        //ADICIONAR À LINHA 7
        {
            coordenar(0,7,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(ContornoJCB,figuraJP);

            coordenar(1,7,2,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(ContornoJCMB,figuraJP);

            coordenar(3,7,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(corContornoJBT,figuraJP);

        }//FIM ADICIONAR À LINHA 7
        
        //ADICIONAR À LINHA 8
        {
            coordenar(0,8,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(preencherJCB,figuraJP);

            coordenar(1,8,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(primeiraCorPreencherJBT,figuraJP);

            coordenar(2,8,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(segundaCorPreencherJBT,figuraJP);
            
            coordenar(3,8,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
            adicionarItensAoPainel(gradienteJPC,figuraJP);
        }//FIM ADICIONAR À LINHA 8

        animarBotoes(retanguloSemArestasJBT, ovalJBT, retaJBT ,retanguloComArestaJBT,maisFigurasJBT);
        animarBotoes(trianguloRetanguloJBT,trianguloEquilateroJBT,losangoJBT,pentagnoJBT,setaFrenteJBT);
        animarBotoes(setaTrasJBT,setaCimaJBT,setaBaixoJBT,estrelaDe4JBT,estrelaDe5JBT,estrelaDe6JBT);
        animarBotoes(trovoadaJBT,dialogoQuadrangularJBT,dialogoOvalJBT,imaginacaoJBT,coracaoJBT);
        
        ContornoJCMB.addActionListener(new TrataEventosBotoes());
        ContornoJCB.addActionListener(new TrataEventosBotoes());
        preencherJCB.addActionListener(new TrataEventosBotoes());
        animarBotoes(ovalJBT,retaJBT,corContornoJBT);
        animarBotoes(primeiraCorPreencherJBT,segundaCorPreencherJBT);
        
        exibirBotoes(false,trianguloRetanguloJBT,trianguloEquilateroJBT,losangoJBT,pentagnoJBT,setaFrenteJBT);
        exibirBotoes(false,setaTrasJBT,setaCimaJBT,setaBaixoJBT,estrelaDe4JBT,estrelaDe5JBT,estrelaDe6JBT);
        exibirBotoes(false,trovoadaJBT,dialogoQuadrangularJBT,dialogoOvalJBT,imaginacaoJBT,coracaoJBT);
        
        
    }

  public void aprontarExibirJP()
    {
        exibirJP=new FundoPropriedade(layoutGBL);
        dimensaoExata(0, 0);        
    }

    public void inicializarContornos()
    {
        ContornoJCMB.addItem("");
        
        for(int i = 1; i<=15; i++)
        {
            ContornoJCMB.addItem(i+" pixels");
        }
    }
    
    public void adicionarItensAoJMenu(JMenuItem menu,JMenuItem ... itens)
    {
        for(JMenuItem item:itens)
        {
           menu.add(item);
        }
    }
        
    public void animarItensMenu(JMenuItem ... itens)
    {
        for(JMenuItem item:itens)
        {
           item.addActionListener(ouvinteItens);
        }
    }
    
    public void animarBotoes(JButton ... itens)
    {
        for(JButton botao:itens)
        {
           botao.addActionListener(ouvinteBotoes);
        }
    }
    
    public void exibirBotoes(boolean exibir,JButton ... itens)
    {
        for(JButton botao:itens)
        {
           botao.setVisible(exibir);
        }
    }
    
    public void definirBorda(AbstractBorder borda,String [] titulos ,JComponent ... componentes)
    {
        for(JComponent componente:componentes)
        {
            componente.setBorder(borda);
        }
    }

    private void adicionarItensAosJPopupMenus(JPopupMenu menuPopup, JMenuItem ... itens) 
    {
        for(JMenuItem item:itens)
        {
           menuPopup.add(item);
        }
    }
    
      public void abreImagem(String path){
     
	File arquivo = new File(path);  
	bufferedImage = null;
					  
        try{
            
          bufferedImage = ImageIO.read(arquivo); 
          
        }
        catch(IOException exc){
          JOptionPane.showMessageDialog(null, 
                "Erro ao carregar a imagem: " + 
                exc.getMessage());
        }

        if(bufferedImage != null){
            
            TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());

            tela.desenharImagemFundo(bufferedImage);
            
            setBuffer(bufferedImage);
            
             

          repaint(); 


        }
      
     
     }
    public void abrirImagem()
    {
        try 
        {
            ficheirosJFS.showOpenDialog(this);
            TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
            tela.setImagem(ImageIO.read(ficheirosJFS.getSelectedFile()));
            tela.repaint();
        } catch (IOException ex) {
            Logger.getLogger(TelaPainelVisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvarImagem(BufferedImage imagem,String formato)
    {
        try 
        {
            ficheirosJFS.showSaveDialog(this);
            ImageIO.write(imagem, formato, new File(ficheirosJFS.getSelectedFile()+"."+formato)); 
        } catch (IOException ex) {
            Logger.getLogger(TelaPainelVisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void animarPainelGradiente()
    {
        gradienteJPC.addMouseListener(new MouseListener() 
        {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) 
            {
                if(preencherJCB.isSelected())
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    
                    if(!tela.isGradiente())
                    {
                        gradienteJPC.setBorder(new BevelBorder(BevelBorder.LOWERED));
                        tela.setGradiente(true);
                        gradienteJPC.setToolTipText("Modo gradiente ativado");
                    }
                    else 
                    {
                        gradienteJPC.setBorder(new BevelBorder(BevelBorder.RAISED));
                        tela.setGradiente(false);
                        gradienteJPC.setToolTipText("Modo gradiente desativado");
                    }      

                    tela.setCor1(primeiraCorPreencherJBT.getBackground());
                    tela.setCor2(segundaCorPreencherJBT.getBackground());
                    
                    if(tela.isGradiente())
                    {
                       tela.setGradienteGP(gradienteJPC.getGradiente());
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e)  {}

            @Override
            public void mouseEntered(MouseEvent e) 
            {
                TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
            }

            @Override
            public void mouseExited(MouseEvent e) 
            { 
                gradienteJPC.requestFocus(true);
            }
        });
    }

    /**
     * @return the buffer
     */
    public BufferedImage getBuffer() {
        return buffer;
    }

    /**
     * @param buffer the buffer to set
     */
    public void setBuffer(BufferedImage buffer) {
        this.buffer = buffer;
    }
    
    private class EventoPainelBotao implements MouseInputListener{
        
        JanelaPrincipalVisao janela = new JanelaPrincipalVisao();
        
        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
        
            janela.aprontarPainelTextura();
            
            if(texturaCheck.isSelected())
            {
                TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());

                if(!tela.isTextura())
                {
                    gradienteJPC.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    tela.setGradiente(true);
                    gradienteJPC.setToolTipText("Modo gradiente ativado");
                }
                else 
                {
                    gradienteJPC.setBorder(new BevelBorder(BevelBorder.RAISED));
                    tela.setGradiente(false);
                    gradienteJPC.setToolTipText("Modo gradiente desativado");
                }      

                tela.setCor1(primeiraCorPreencherJBT.getBackground());
                tela.setCor2(segundaCorPreencherJBT.getBackground());

                if(tela.isGradiente())
                {
                   tela.setGradienteGP(gradienteJPC.getGradiente());
                }
            }
            
            
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
        
    private class TrataEventosMenus implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            if(e.getSource() == sobreAplicacaoJM){
                try {

                       new AjudaAplicacao().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(JanelaPrincipalVisao.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            if(e.getSource()==abrirJMI)
            {
                abrirImagem();
            }
            
            if(e.getSource()==salvarJMI)
            {
                TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                salvarImagem(tela.getImagem(),"PNG");
            }
            
            if(e.getSource()==novoJMI)
            {
                try {
                    propriedades =new PropriedadesPainel();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(JanelaPrincipalVisao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 propriedades.setVisible(true);
                 TelaPainelVisao tela = new TelaPainelVisao();
                 tela.setLarguraFundo(propriedades.getLargura());
                 tela.setHalturaFundo(propriedades.getAltura());
                 tela.setCorFundo(propriedades.getCor());
                 
                 tela.addMouseListener(new TrataEventosMouse());
                 tela.setBorder(borderComposto);
                 tela.addMouseListener(new TrataEventosMouse());
                 tela.setBorder(borderComposto);
                 
                 if( propriedades.getAltura() != 1 && propriedades.getLargura() != 1){
                    
                    JScrollPane roll= new JScrollPane(tela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    roll.setPreferredSize(new Dimension(propriedades.getLargura(),propriedades.getAltura()));
                    roll.setAutoscrolls(true);
                    telaPainelTAB.add("Documento "+(paineisEmEdicao)+".png", roll);
                    telasEmEdicao.add(tela);
                    telaPainelTAB.setSelectedIndex(paineisEmEdicao-1);
                    paineisEmEdicao++;
                    
                 }

            }
            if(e.getSource()== novoPalco){
                try {
                    propriedades =new PropriedadesPainel();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(JanelaPrincipalVisao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 propriedades.setVisible(true);
                 TelaPainelVisao tela = new TelaPainelVisao();
                 tela.setLarguraFundo(propriedades.getLargura());
                 tela.setHalturaFundo(propriedades.getAltura());
                 tela.setCorFundo(propriedades.getCor());
                 tela.setPreferredSize(new Dimension(propriedades.getLargura(),propriedades.getAltura()));
                 tela.addMouseListener(new TrataEventosMouse());
                 tela.setBorder(borderComposto);
                 tela.addMouseListener(new TrataEventosMouse());
                 tela.setBorder(borderComposto);
                 
                 if( propriedades.getAltura() != 1 && propriedades.getLargura() != 1){
                    
                    JScrollPane roll= new JScrollPane(tela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    roll.setPreferredSize(new Dimension(propriedades.getLargura(),propriedades.getAltura()));
                    roll.setAutoscrolls(true);
                    telaPainelTAB.add("Documento "+(paineisEmEdicao)+".png", roll);
                    telasEmEdicao.add(tela);
                    telaPainelTAB.setSelectedIndex(paineisEmEdicao-1);
                    paineisEmEdicao++;
                    
                 }
            
            }
            
            if(e.getSource()==sairJMI)
            {
                System.exit(0);
            }
            if(e.getSource()==sairAplicacao)
            {
                System.exit(0);
            }
            
            if(e.getSource()==imagemJMI)
            {
                abrirImagem();
            }
            if(e.getSource()==abrirFicheiro)
            {
                TelaPainelVisao tela = new TelaPainelVisao();
                tela.addMouseListener(new TrataEventosMouse());
                tela.setBorder(borderComposto);
                tela.setPreferredSize(new Dimension(propriedades.getLargura(),propriedades.getAltura()));
                JScrollPane roll= new JScrollPane(tela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                roll.setPreferredSize(new Dimension(propriedades.getLargura(),propriedades.getAltura()));
                roll.setAutoscrolls(true);
                telaPainelTAB.add("Documento "+(paineisEmEdicao)+".png", roll);
                telasEmEdicao.add(tela);
                telaPainelTAB.setSelectedIndex(paineisEmEdicao-1);
                paineisEmEdicao++;
                abrirImagem();
            }            
            
            if(e.getSource()==fecharTabuladorJMI)
            {
                if(telaPainelTAB.getSelectedIndex()>=0)
                {
                    telaPainelTAB.remove(telaPainelTAB.getSelectedIndex());
                    paineisEmEdicao--;
                }
            } 
            
            if(e.getSource()==mudarFundoJMI)
            {
                if(telaPainelTAB.getSelectedIndex()>=0)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setCorFundo(JColorChooser.showDialog(contentor, "escole cores", cor));
                   
                }
            } 
            if(e.getSource()==btnCorBranca){
            
                    if(telaPainelTAB.getSelectedIndex()>=0)
                     {
                         TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                         //tela.setCorFundo(Color.WHITE);
                         tela.pintaFundo(Color.WHITE,getBuffer() );
                        
                     }
            
            }
            if(e.getSource()==btnCorCastanhoClaro){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.LIGHT_GRAY);

                 }
			}
            if(e.getSource()==btnCorCastanhoEscuro){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.DARK_GRAY);

                 }
            
            }
            if(e.getSource()==btnCorCastanho){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.GRAY);

                 }
                
            }
            if(e.getSource()==btnCorRosa){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.PINK);

                 }
            
            }
            if(e.getSource()==btnCorAmarela){
            
                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.YELLOW);

                 }
            
            }
            if(e.getSource()==btnCorAzulClaro){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.CYAN);

                 }
            
            }
            if(e.getSource()==btnCoAzulEscuro){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.BLUE);

                 }
            
            }
        
            if(e.getSource()==btnCorVerde){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.GREEN);

                 }
                
            }
            if(e.getSource()==btnCorVermelha){
            
                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.RED);

                 }
            
            
            }
            if(e.getSource()==btnCorPreta){

                if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(Color.BLACK);

                 }
            }
            if(e.getSource()==btnSeleCor){
            
                if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                     tela.setCorFundo(JColorChooser.showDialog(contentor, "escole cores", cor));

                 }
            
            }//FIM PAINEL CORES
            if(e.getSource()==fundo1BB){
            
                    if(telaPainelTAB.getSelectedIndex()>=0)
                     {
                         
                         caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo1.jpg");
                         abreImagem(caminho);

                     }
            
            }
            if(e.getSource()==fundo2BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo2.jpg");
                     abreImagem(caminho);

                 }
            }
            if(e.getSource()==fundo3BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo3.jpg");
                     abreImagem(caminho);

                 }
            
            }
            if(e.getSource()==fundo4BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo4.jpg");
                     abreImagem(caminho);

                 }
                
            }
            if(e.getSource()==fundo5BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo5.jpg");
                    abreImagem(caminho);

                 }
            
            }
            if(e.getSource()==fundo6BB){
            
                 if(telaPainelTAB.getSelectedIndex()>=0)
                 { 
                     caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo6.jpg");
                     abreImagem(caminho);

                 }
            
            }
            if(e.getSource()==fundo7BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                     caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo7.jpg");
                     abreImagem(caminho);

                 }
            
            }
            if(e.getSource()==fundo8BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo8.png");
                    abreImagem(caminho);

                 }
            
            }
        
            if(e.getSource()==fundo9BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo9.jpg");
                    abreImagem(caminho);

                 }
                
            }
            if(e.getSource()==fundo10BB){
            
                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo10.jpg");
                    abreImagem(caminho);

                 }
            
            
            }
            if(e.getSource()==fundo11BB){

                if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo11.jpg");
                    abreImagem(caminho);
                 }
            }
            if(e.getSource()==fundo12BB){
            
                if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo12.jpg");
                    abreImagem(caminho);

                 }
            
            } if(e.getSource()==fundo13BB){

                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo13.jpg");
                    abreImagem(caminho);

                 }
                
            }
            if(e.getSource()==fundo14BB){
            
                 if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo14.jpg");
                    abreImagem(caminho);

                 }
            
            
            }
            if(e.getSource()==fundo15BB){

                if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo15.jpg");
                    abreImagem(caminho);

                 }
            }
            if(e.getSource()==fundo16BB){
            
                if(telaPainelTAB.getSelectedIndex()>=0)
                 {
                    caminho = FicheiroControlo.criaCaminhoFicheiro("imagens", "fundo16.jpg");
                    abreImagem(caminho);

                 }
            
            }//FIM PAINEL TEXTURA
        }
    }
    
    private class TrataEventosBotoes implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //PAINEL PARA DESENHO
            {
                if(e.getSource()==lapisJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(1);
                }

                if(e.getSource()==borrachaJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(2);
                }

                if(e.getSource()==selecionarJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(3);
                }
                
            }//FIM PAINEL DESENHO
            
            //PAINEL PARA DESENHO DE FIGURAS GEOMETRICAS
            {
                if(e.getSource()==retanguloSemArestasJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(5);
                }

                if(e.getSource()==retaJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(7);
                }

                if(e.getSource()==maisFigurasJBT)
                {                    
                    if(maisFigurasJBT.getText().equals("+")) 
                    {
                        exibirBotoes(true,trianguloRetanguloJBT,trianguloEquilateroJBT,losangoJBT,pentagnoJBT,setaFrenteJBT);
                        exibirBotoes(true,setaTrasJBT,setaCimaJBT,setaBaixoJBT,estrelaDe4JBT,estrelaDe5JBT,estrelaDe6JBT);
                        exibirBotoes(true,trovoadaJBT,dialogoQuadrangularJBT,dialogoOvalJBT,imaginacaoJBT,coracaoJBT);
                    }
                    else
                    {
                        exibirBotoes(false,trianguloRetanguloJBT,trianguloEquilateroJBT,losangoJBT,pentagnoJBT,setaFrenteJBT);
                        exibirBotoes(false,setaTrasJBT,setaCimaJBT,setaBaixoJBT,estrelaDe4JBT,estrelaDe5JBT,estrelaDe6JBT);
                        exibirBotoes(false,trovoadaJBT,dialogoQuadrangularJBT,dialogoOvalJBT,imaginacaoJBT,coracaoJBT);
                    }
                    maisFigurasJBT.setText((maisFigurasJBT.getText().equals("+"))?"-":"+");
                }

                if(e.getSource()==trianguloRetanguloJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(9);
                }                
                               
                if(e.getSource()==trianguloEquilateroJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(10);
                }
                
                if(e.getSource()==losangoJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(11);
                }        
                
                if(e.getSource()==pentagnoJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(12);
                }
                
                if(e.getSource()==setaFrenteJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(13);
                }                
                 
                if(e.getSource()==setaTrasJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(14);
                } 
              
                if(e.getSource()==setaCimaJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(15);
                }        
                
                if(e.getSource()==setaBaixoJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(16);
                }
                
                if(e.getSource()==estrelaDe4JBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(17);
                }                
              
                if(e.getSource()==estrelaDe5JBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(18);
                }     
 
                if(e.getSource()==estrelaDe6JBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(19);
                }                
                                
                if(e.getSource()==trovoadaJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(20);
                }                

                if(e.getSource()==dialogoQuadrangularJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(21);
                }                

                if(e.getSource()==dialogoOvalJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(22);
                }                

                if(e.getSource()==imaginacaoJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(23);
                }             

                if(e.getSource()==coracaoJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setOpcao(24);
                }                
                if(e.getSource()==retanguloComArestaJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    preencherJCB.setEnabled(true);
                    tela.setOpcao(25);
                }  
                   
                if(e.getSource()==retanguloSemArestasJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    preencherJCB.setEnabled(true);
                    tela.setOpcao(26);
                }                
                             
                if(e.getSource()==ovalJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    preencherJCB.setEnabled(true);
                    tela.setOpcao(27);
                }
                
                if(e.getSource()==retaJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    preencherJCB.setEnabled(false);
                    tela.setOpcao(28);
                }
               
                if(e.getSource()==ContornoJCB)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    tela.setContorno(ContornoJCB.isSelected());
                    corContornoJBT.setEnabled(ContornoJCB.isSelected());
                    ContornoJCMB.setEnabled(ContornoJCB.isSelected());
                    
                }
                
                if(e.getSource()==ContornoJCMB)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    int i = ContornoJCMB.getSelectedIndex();
                    
                    if(i>0)
                    {
                        tela.setEspessuraContorno(new BasicStroke(i));
                    }
                    else
                    {
                        try
                        {
                           i = Integer.parseInt((String)ContornoJCMB.getSelectedItem());
                        }
                        catch(Exception pe)
                        {
                            JOptionPane.showConfirmDialog(null, "Espessura invalida","Espessura do contorno",JOptionPane.ERROR_MESSAGE);
                            i=1;
                        }
                        finally{ tela.setEspessuraContorno(new BasicStroke(i)); }
                    }
                }       
                
                if(e.getSource()==corContornoJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    corContornoJBT.setBackground(JColorChooser.showDialog(corContornoJBT, "Escolha uma cor ", cor));
                    tela.setCorContorno(corContornoJBT.getBackground());
                }
                
                if(e.getSource()==preencherJCB)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    
                    tela.setPreencher(preencherJCB.isSelected());
                    gradienteJPC.setEnabled(preencherJCB.isSelected());
                    primeiraCorPreencherJBT.setEnabled(preencherJCB.isSelected());
                    segundaCorPreencherJBT.setEnabled(preencherJCB.isSelected());
                }                
               
                if(e.getSource()==primeiraCorPreencherJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    primeiraCorPreencherJBT.setBackground(JColorChooser.showDialog(corContornoJBT, "Escolha uma cor ", cor));
                    tela.setCor1(primeiraCorPreencherJBT.getBackground());
                    tela.setCorFundoFigura(primeiraCorPreencherJBT.getBackground());
                    gradienteJPC.setCor1(primeiraCorPreencherJBT.getBackground());
                }                
                if(e.getSource()==segundaCorPreencherJBT)
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    segundaCorPreencherJBT.setBackground(JColorChooser.showDialog(corContornoJBT, "Escolha uma cor ", cor));
                    tela.setCor2(segundaCorPreencherJBT.getBackground());
                    gradienteJPC.setCor2(segundaCorPreencherJBT.getBackground());
                }
            }//FIM PAINEL FIGURAS
            
            
            
        }
        
        
    }
    
    private class TrataEventosMouse implements MouseInputListener
    {

        @Override
        public void mouseClicked(MouseEvent e) 
        {
        }

        @Override
        public void mousePressed(MouseEvent e) 
        {
        }

        @Override
        public void mouseReleased(MouseEvent e) 
        {
           if(e.isPopupTrigger())
           {
               menuPopuptelaPainelTAB.show(telaPainelTAB, e.getX(), e.getY());
           }
            
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
        }

        @Override
        public void mouseMoved(MouseEvent e) 
        {
        }
    }
    
    private class TrataEventoCheckBox implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
       
            if(corCheck.isSelected())
            {

                btnCorBranca.setEnabled (true); 
                btnCorAzulClaro.setEnabled (true);
                btnCorCastanhoClaro.setEnabled (true); 
                btnCorCastanho.setEnabled (true);
                btnCorCastanhoEscuro.setEnabled (true); 
                btnCorPreta.setEnabled (true); 
                btnCoAzulEscuro.setEnabled (true);
                btnCorVerde.setEnabled (true); 
                btnCorAmarela.setEnabled (true); 
                btnCorRosa.setEnabled (true); 
                btnCorVermelha.setEnabled (true); 
                btnSeleCor.setEnabled (true); 
                
                texturaCheck.setSelected(false);


            }
            if(!corCheck.isSelected())
            {

                btnCorBranca.setEnabled (false); 
                btnCorAzulClaro.setEnabled (false);
                btnCorCastanhoClaro.setEnabled (false); 
                btnCorCastanho.setEnabled (false);
                btnCorCastanhoEscuro.setEnabled (false); 
                btnCorPreta.setEnabled (false); 
                btnCoAzulEscuro.setEnabled (false);
                btnCorVerde.setEnabled (false); 
                btnCorAmarela.setEnabled (false); 
                btnCorRosa.setEnabled (false); 
                btnCorVermelha.setEnabled (false); 
                btnSeleCor.setEnabled (false);


            }
            if(texturaCheck.isSelected()){
            
                
                fundo1BB.setEnabled(true);
                fundo2BB.setEnabled(true);
                fundo3BB.setEnabled(true);
                fundo4BB.setEnabled(true);
                fundo5BB.setEnabled(true);
                fundo6BB.setEnabled(true);
                fundo7BB.setEnabled(true);
                fundo8BB.setEnabled(true);
                fundo9BB.setEnabled(true);
                fundo10BB.setEnabled(true); 
                fundo11BB.setEnabled(true);
                fundo12BB.setEnabled(true);
                fundo13BB.setEnabled(true);
                fundo14BB.setEnabled(true);
                fundo15BB.setEnabled(true);
                fundo16BB.setEnabled(true);
                
                corCheck.setSelected(false);
            
            }
            if(!texturaCheck.isSelected()){
            
                
                fundo1BB.setEnabled(false);
                fundo2BB.setEnabled(false);
                fundo3BB.setEnabled(false);
                fundo4BB.setEnabled(false);
                fundo5BB.setEnabled(false);
                fundo6BB.setEnabled(false);
                fundo7BB.setEnabled(false);
                fundo8BB.setEnabled(false);
                fundo9BB.setEnabled(false);
                fundo10BB.setEnabled(false); 
                fundo11BB.setEnabled(false);
                fundo12BB.setEnabled(false);
                fundo13BB.setEnabled(false);
                fundo14BB.setEnabled(false);
                fundo15BB.setEnabled(false);
                fundo16BB.setEnabled(false);
            
            }

            
            
            
        }
    }
}
