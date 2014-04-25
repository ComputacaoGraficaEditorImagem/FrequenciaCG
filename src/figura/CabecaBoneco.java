
package figura;


import animacao.Transformavel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.ArrayList;

public class CabecaBoneco extends Componente implements Transformavel
{
    ArrayList<Figura> figuras;
    private Area areaRosto;
    
    public CabecaBoneco()
    {
        areaRosto = new Area();
        figuras = new ArrayList<>();
        cor=Color.BLUE;
    }
    
    public CabecaBoneco(Figura s)
    {
        this();
        areaRosto = new Area(s.getForma());
        figuras.add(s);
        
        areaRosto=new Area(s.getForma());
    }
    
    @Override
    public void desenhar(Graphics2D g2d) 
    {
        g2d.setColor(this.cor);
        
        g2d.fill(areaRosto);
        
        for(Figura detalheRosto:figuras)
        {
          g2d.setColor(detalheRosto.cor);
          detalheRosto.desenhar(g2d);
        }
    }

    @Override
    public void adicionarFigura(Figura figura) 
    {
        figuras.add(figura);
    }

    @Override
    public Area getArea() 
    {
        return areaRosto;
    }

    @Override
    public void transformar() 
    {
        
    }
    
}
