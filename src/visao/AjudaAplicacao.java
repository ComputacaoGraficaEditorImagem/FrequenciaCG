/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class AjudaAplicacao extends JDialog {
    
    JLabel fundo = new JLabel();

    JButton jbOK = new JButton("OK");
  
    
    private Color corFundo = null;
    private Color corFundoActual = null;
    
    JPanel painelCentro = new JPanel();
    JPanel painelBotoes = new JPanel();
    FundoAjuda painelPrincipal = new FundoAjuda();
    
  
    public AjudaAplicacao() throws MalformedURLException{
     
        this.setUndecorated(true); 
        this.setModal(true);        
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        
         fundo.setIcon(new ImageIcon(getClass().getResource("/img/sobreAplicacao.png"))); 

         fundo.setLayout(new BorderLayout());
         
         painelCentro.setBackground(Color.white);		

         
         jbOK.setPreferredSize(new Dimension(120,20));
   
         
	 painelBotoes.add(jbOK);
         
         painelCentro.setLayout(new GridBagLayout());
         
         painelCentro.setPreferredSize(new Dimension(185,60));
         painelCentro.setBorder(BorderFactory.createTitledBorder("Novo Documento"));
 
 

         painelPrincipal.setLayout(new BorderLayout());


         painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);


         fundo.add(painelPrincipal);
         add(painelPrincipal);
         

         jbOK.addActionListener(new Evento());


    }
    private class Evento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            

            if(e.getSource() == jbOK)
            {
               dispose();
            }
            

            }
      
        }
    
    
    
    }
  
    
