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

    public ArrayList<Grafo> lerArquivo(String caminho) {
        String texto;
        Grafo grafo = new Grafo();
        File file = new File(caminho);
        int linhaAtual = 0;
        int quantidadeLinha = 0;
        int quantidadeColuna = 0;
        ArrayList<Grafo> todosGrafos = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((texto = br.readLine()) != null) {
                if (linhaAtual == 0) {
                    quantidadeLinha = Integer.parseInt(texto.split(" ")[0]);
                    quantidadeColuna = Integer.parseInt(texto.split(" ")[1]);                    
                } else if (texto.trim().equals("")) {
                    todosGrafos.add(grafo);
                    grafo.removerTodasKeyGrafo();
                } else {
                    int totalPesos = texto.split(" ").length;
                    grafo.inserirVerticeGrafo(linhaAtual);
                    for (int j = 0; j < totalPesos; j++) {
                        Vertice adjacente = new Vertice();
                        adjacente.setNome(String.valueOf(j));
                        Aresta a = new Aresta();
                        a.setV1(adjacente);
                        a.setPeso(texto.split(" ")[j]);
                        grafo.inserirArestaGrafo(linhaAtual, j);
                    }

                }
                linhaAtual++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todosGrafos;
    }
}
