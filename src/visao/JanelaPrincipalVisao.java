
package visao;

import controlo.FicheiroControlo;
import figura.Retangulo;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputListener;

public final class JanelaPrincipalVisao extends JFrame
{
    private ImageIcon icone;
    private JMenuBar barraMenuJMB;
    private JMenu ficheiroJM;
    private JMenuItem salvarJMI;
    private JMenuItem novoJMI;
    private JMenuItem abrirJMI;
    private JMenuItem sairJMI;
    
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
    private TitledBorder arquivoBorder;
    private TitledBorder imagemBorder;
    
    private JPanel desenhoJP;
    private JPanel exibirJP;
    private JPanel arquivoJP;
    private JPanel imagemJP;
    
    private JButton desenhoLivreJBT;
    private JButton pincelJBT;
    private JButton textoJBT;
    private JButton selecionarJBT;
    private JButton borrachaJBT;
       
    private ImageIcon pincelIMG;
    private ImageIcon    textoIMG;
    private ImageIcon selecionarIMG;
    private ImageIcon borrachaIMG;
    private ImageIcon desenhoLivreIMG;
    
    private TelaPainelVisao telaJP;
        
    private JRootPane painelOpcoesJRP;
    
    private JTabbedPane telaPainelTAB;
    private JTabbedPane paineisOpcoesTAB;
       
    private GridBagLayout layoutGBL;
    private GridBagConstraints decoradorGBC;
    
    private Container contentor;
    
    private Font fonte;
    private Color cor;
    
    private JFileChooser ficheirosJFS;
    private JColorChooser coresJCS;
    private EscolheCores serveCores;
    
    private TrataEventosMenus ouvinteItens;
    private int paineisEmEdicao;
    private JSeparator separadorJS;
    private final JMenuItem inserirJM;
    private final JMenuItem imagemJMI;
    private final JMenuItem figuraJMI;
    private ArrayList<TelaPainelVisao> telasEmEdicao;   
    private TrataEventosBotoes ouvinteBotoes;
    
    public JanelaPrincipalVisao()
    {
        super("UCAN editor 1.0");
        
        ficheirosJFS = new JFileChooser();
        coresJCS = new JColorChooser(Color.yellow);
        serveCores = new EscolheCores();
        cor=Color.BLUE;
        ouvinteItens = new TrataEventosMenus();
        ouvinteBotoes = new TrataEventosBotoes();
        
        telasEmEdicao = new ArrayList<>();
        separadorJS = new JSeparator(JSeparator.HORIZONTAL);
        
        Dimension minSize =new Dimension(900,700);
        
        setMinimumSize(minSize);

        String caminho = FicheiroControlo.criaCaminhoFicheiro("imagens","Ucan.png");
        setLayout(new BorderLayout(10, 10));
               
        layoutGBL = new GridBagLayout();
        decoradorGBC = new GridBagConstraints();
        
        contentor=new Container();
        contentor.setLayout(layoutGBL);
        
        borderRelevo=new BevelBorder(BevelBorder.RAISED);
        borderDepressao=new BevelBorder(BevelBorder.LOWERED);
        borderComposto=new CompoundBorder(borderRelevo, borderDepressao);
        
        fonte=new Font("Times New Roman", Font.PLAIN, 16);
        
        desenhoBorder= new TitledBorder(borderComposto, " Desenho ",  TitledBorder.LEFT,TitledBorder.TOP, fonte);
        exibirBorder= new TitledBorder(borderComposto, " Exibir ", TitledBorder.LEFT,TitledBorder.TOP,  fonte);
        arquivoBorder= new TitledBorder(borderComposto, " Arquivo ", TitledBorder.LEFT, TitledBorder.TOP, fonte);
        imagemBorder= new TitledBorder(borderComposto, " Imagem ",  TitledBorder.LEFT,TitledBorder.TOP, fonte);
        
        
        aprontarDesenhoJP();
        
        exibirJP=new JPanel(layoutGBL);
        arquivoJP=new JPanel(layoutGBL);
        imagemJP=new JPanel(layoutGBL);
        telaJP= new TelaPainelVisao(Color.WHITE,getWidth(),getHeight());
        
        desenhoJP.setBorder(desenhoBorder);
        exibirJP.setBorder(exibirBorder);
        arquivoJP.setBorder(arquivoBorder);
        imagemJP.setBorder(imagemBorder);

        borderComposto = new CompoundBorder( borderDepressao,borderRelevo);
        telaJP.setBorder(borderComposto);
                
        painelOpcoesJRP = new JRootPane();
        painelOpcoesJRP.setLayout(layoutGBL);
        
        //IPADX & Y
        dimensaoExata(10,10);
        decoradorGBC.insets = new Insets(5, 5, 5, 5);

        coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        adicionarItensAoPainel(desenhoJP,painelOpcoesJRP);
        
        dimensaoExata(150,90);
        coordenar(0,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        adicionarItensAoPainel(exibirJP,painelOpcoesJRP);
        
        coordenar(0,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        adicionarItensAoPainel(arquivoJP,painelOpcoesJRP);
        
        decoradorGBC.insets = new Insets(5, 5, 30, 5);
        coordenar(0,3,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        adicionarItensAoPainel(imagemJP,painelOpcoesJRP);        
                
        icone = new ImageIcon(caminho);
        barraMenuJMB = new JMenuBar();
        
        ficheiroJM = new JMenu("Ficheiro");
        
        salvarJMI = new JMenuItem("Salvar");
        novoJMI = new JMenuItem("Novo");
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
        
        
        paineisEmEdicao++;
        
        telaPainelTAB = new JTabbedPane(1);
        paineisOpcoesTAB = new JTabbedPane(1);
                
        System.out.println("x="+getWidth()+"\nY="+getHeight());
        
        telaPainelTAB.add("Página inicial", telaJP);
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
        ficheiroJM.add(separadorJS);
        ficheiroJM.add(sairJMI);
        adicionarMenusABarraMenuJMB(ficheiroJM);
        setJMenuBar(barraMenuJMB);
        add(contentor);
        addMouseListener(new TrataEventosMouse());
        setIconImage(icone.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    /*******************************************************************************************************
     * Objectivo: Alterar os campos gridx,gridy,gridwidth,gridheight e fill do objecto GridBagConstraints  *
     * Entrada: Os dados                                                                                   *                                                                           *
     * Autor:Filipe Tuza                                                                                   *                                                              *
     * Data:02/03/2014                                                                                     *                                                            *
     * *****************************************************************************************************/
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
    
    /*******************************************************************************************************
     * Objectivo: Adicionar um componente ao contentor                                                     *
     * Entrada: O componente e o contentor                                                                 *                                                                           *
     * Autor:Filipe Tuza                                                                                   *                                                              *
     * Data:9/04/2014                                                                                     *                                                            *
     * *****************************************************************************************************/
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
        desenhoJP=new JPanel(layoutGBL);
        dimensaoExata(0, 0);

        decoradorGBC.weightx=0.0;
        decoradorGBC.weighty=0.0;
        
        
        pincelIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "pincel.png"));
        textoIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fb_icon.gif"));
        selecionarIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fb_icon.gif"));
        borrachaIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fb_icon.gif"));
        desenhoLivreIMG=new ImageIcon(FicheiroControlo.criaCaminhoFicheiro("imagens", "fb_icon.gif"));
        desenhoLivreJBT=new JButton("b0",desenhoLivreIMG);
        pincelJBT=new JButton(pincelIMG);
        textoJBT=new JButton("b2",textoIMG);
        selecionarJBT=new JButton("b3",selecionarIMG);
        borrachaJBT=new JButton("b4",borrachaIMG);
               
        coordenar(0,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(pincelJBT,desenhoJP);
        
        coordenar(1,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(textoJBT,desenhoJP);
        
        coordenar(0,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(selecionarJBT,desenhoJP);
        
        coordenar(1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(borrachaJBT,desenhoJP);
        
        coordenar(0,2,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH);
        adicionarItensAoPainel(desenhoLivreJBT,desenhoJP);
        
        animarBotoes(desenhoLivreJBT,pincelJBT,textoJBT,selecionarJBT,borrachaJBT);
        
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
    

    public void abrirImagem()
    {
        try 
        {
            ficheirosJFS.showOpenDialog(this);
            TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
            tela.setImagem(ImageIO.read(ficheirosJFS.getSelectedFile()));
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
    
    private class TrataEventosMenus implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
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
                TelaPainelVisao tela = new TelaPainelVisao();
                tela.addMouseListener(new TrataEventosMouse());
                tela.setBorder(borderComposto);
                telaPainelTAB.add("Painel "+(paineisEmEdicao), tela);
                telasEmEdicao.add(tela);
                telaPainelTAB.setSelectedIndex(paineisEmEdicao-1);
                paineisEmEdicao++;

            }
            
            if(e.getSource()==sairJMI)
            {
                System.exit(0);
            }
            
            if(e.getSource()==imagemJMI)
            {
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
                    serveCores.setVisible(true);
                }
            } 
        }
    }
    
    private class TrataEventosBotoes implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            if(e.getSource()==desenhoLivreJBT)
            {
                TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                tela.setOpcao(1);
            }
            
            if(e.getSource()==pincelJBT)
            {
                TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                tela.setOpcao(2);
            }
        }
    }
    
    private class EscolheCores extends JFrame
    {
        JRootPane painelCoresJRP;
        JPanel paineOpcoesJP;
        JButton okJBT;
        JButton canselarJBT;
        Dimension dimensaoDM;
        
        
        public EscolheCores()
        {
            dimensaoDM = new Dimension(700, 500);
            
            setUndecorated(true);
            setMinimumSize(dimensaoDM);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);  
            
            painelCoresJRP = new JRootPane();
            painelCoresJRP.setLayout(new BorderLayout(5, 5));
            paineOpcoesJP=new JPanel();
            
            okJBT=new JButton("OK");
            canselarJBT=new JButton("Conselar");
            
            paineOpcoesJP.add(okJBT);
            paineOpcoesJP.add(canselarJBT);
                        
            okJBT.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    TelaPainelVisao tela = telasEmEdicao.get(telaPainelTAB.getSelectedIndex());
                    cor=tela.getCorFundo();
                    cor=coresJCS.getColor();
                    tela.setCorFundo(cor);
                    tela.repaint();
                    dispose();
                }
             });
            
            canselarJBT.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    dispose();
                }
             });
            
            
            
            painelCoresJRP.add(coresJCS,BorderLayout.CENTER);
            painelCoresJRP.add(paineOpcoesJP,BorderLayout.SOUTH);
            add(painelCoresJRP);
            
          
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
}
