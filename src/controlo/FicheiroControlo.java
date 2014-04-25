package controlo;

import java.io.*;
import java.nio.file.Files;

public class FicheiroControlo implements Serializable{
    
  /*******************************************************************************************
    * Objectivo: Criar o caminho para um ficheiro                                                                            *
    * Entrada: O diretorio e o nome do ficheiro                                                                                 *
    * Sa�da: O caminho do ficheiro                                                                                                        *
    * ******************************************************************************************/
    public static String mensagem=null;
    
    public static String criaCaminhoFicheiro(String directorio,String nomeFicheiro)
    {
        return new File(directorio).getAbsolutePath()+"\\"+nomeFicheiro;
    }
        
  /*******************************************************************************************
    * Objectivo: Gravar um objecto permanentemente                                                                    *
    * Entrada: O objecto e o caminho do mesmo                                                                               *
    * Sa�da: O ficheiro desejado                                                                                                             *
    * *****************************************************************************************/
    public static void gravar(Object objecto,String caminho)
    {
        try(FileOutputStream fos=new FileOutputStream(caminho))
        {
            try(ObjectOutputStream oos=new ObjectOutputStream(fos))
            {
                oos.writeObject(objecto);
            }
        }
        catch(FileNotFoundException fnfe)
        {
            mensagem="Erro! \"Ficheiro não encontrado \"";
            fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            mensagem="Erro! \" Caminho invãlido \"";
            e.printStackTrace();
        }
    }
    
  /*******************************************************************************************
    * Objectivo: Recuperar um ficheiro � partir do nome                                                                *
    * Entrada: O nome do ficheiro                                                                                                         *
    * Sa�da: O ficheiro desejado                                                                                                              *
    * *****************************************************************************************/
    public static Object ler(String caminho)
    {
        Object objecto=null;
        
        try(FileInputStream fis=new FileInputStream(new File(caminho).getAbsolutePath()) )
        {
            try(ObjectInputStream ois=new ObjectInputStream(fis))
            {
                objecto = ois.readObject();
            }
        }
        catch(FileNotFoundException fnfe)
        {
            mensagem="Erro! \"Ficheiro não encontrado \"";
            fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            mensagem="Erro! \" Caminho inválido \"";
            e.printStackTrace();
        }

        return objecto;
    }
    
/*******************************************************************************************
   * Objectivo: Recuperar um ficheiro � partir do nome                                                                *
   * Entrada: O nome do ficheiro                                                                                                         *
   * Sa�da: O ficheiro desejado                                                                                                              *
   * *****************************************************************************************/
    public static boolean existe(String caminhoAbstracto)
    {
        mensagem=(!Files.exists(new File(caminhoAbstracto).toPath()))?"Erro! \" Caminho n�o existe \"":"Erro! \" Caminho Existe \"";
        return  Files.exists(new File(caminhoAbstracto).toPath());
    }
        
}