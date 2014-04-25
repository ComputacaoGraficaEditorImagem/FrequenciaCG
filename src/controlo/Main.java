
package controlo;

import animacao.ExemploAnimacao;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import visao.JanelaPrincipalVisao;


public class Main 
{
    
    public static void main(String [] args) 
    {
        try
        {
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { }
        
        finally{JanelaPrincipalVisao principal = new JanelaPrincipalVisao();}
        
    }
}
