
package animacao;

import java.awt.Dimension;
import javax.swing.JFrame;


public class ExemploAnimacao extends JFrame
{
    private Dimension dimensao;
    private CenaAnimada cenario;
    
    public ExemploAnimacao()
    {
        super("Exemplo anime");
        dimensao = new Dimension(500, 500);
        cenario = new CenaAnimada();
        cenario.comessar();
        add(cenario);
        
        setMinimumSize(dimensao);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
}
