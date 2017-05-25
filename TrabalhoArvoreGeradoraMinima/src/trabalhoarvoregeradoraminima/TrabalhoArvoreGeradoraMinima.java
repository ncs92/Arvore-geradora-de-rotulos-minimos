/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoarvoregeradoraminima;

import classes.Grafo;
import classes.LeituraArquivo;
import java.util.ArrayList;

/**
 *
 * @author a899607
 */
public class TrabalhoArvoreGeradoraMinima {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Grafo> todosGrafos = new ArrayList();
        LeituraArquivo leitura = new LeituraArquivo();
        todosGrafos = leitura.lerArquivo("/home/todos/alunos/cm/a899607/Documentos/Arvore-geradora-de-rotulos-minimos/TrabalhoArvoreGeradoraMinima/src/instancias/GROUP1/HDGraph20_20.txt");
    }
    
}
