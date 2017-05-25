/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author a899607
 */
public class LeituraArquivo {

    public ArrayList<Grafo> lerArquivo(String caminho) throws CloneNotSupportedException {
        String texto;
        Grafo grafo = new Grafo();
        File file = new File(caminho);
        int linhaAtual = 0;
        int quantidadeLinha = 0;
        int quantidadeColuna = 0;
        String rotulo = "";
        ArrayList<Grafo> todosGrafos = new ArrayList();
        int cont = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((texto = br.readLine()) != null) {
                if (cont == 0) {
                    quantidadeLinha = Integer.parseInt(texto.split(" ")[0]) - 2;
                    quantidadeColuna = Integer.parseInt(texto.split(" ")[1]) - 2; 
                    rotulo = texto.split(" ")[0];
                    linhaAtual = quantidadeLinha+1;
                } else if (linhaAtual < 0) {                    
                    todosGrafos.add((Grafo) grafo.clone());
                    grafo = new Grafo();
                    linhaAtual = quantidadeLinha+1;
                } else {                    
                    grafo.inserirVerticeGrafo(linhaAtual);
                    int totalPesos = texto.split(" ").length;
                    for (int j = 0; j < totalPesos; j++) {
                        String peso = texto.split(" ")[j];
                        if(!peso.equals(rotulo)){
                            Vertice adjacente = new Vertice();
                            adjacente.setNome(String.valueOf(j));                        
                            Aresta a = new Aresta();
                            a.setV1(adjacente);
                            a.setPeso(peso);
                            grafo.inserirArestaGrafo(linhaAtual, a);
                        }                        
                    }
                }
                linhaAtual--;
                cont++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todosGrafos;
    }
}
