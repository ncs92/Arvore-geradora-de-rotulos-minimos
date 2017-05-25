/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nani
 */
public class Grafo implements Cloneable {
    private  Map<Object, ArrayList<Object>> grafo = new HashMap<>();

    public Grafo() {
    }
    
    @Override
    public Grafo clone() throws CloneNotSupportedException {
        try {
        return (Grafo)super.clone();
      }
      catch (CloneNotSupportedException ex) {
        ex.printStackTrace();
        return null;
      }
    }
    
    public  Map<Object, List<Object>> getGrafo(){
        return null;
    }

    public void inserirVerticeGrafo(Object v) { 
        if (this.grafo != null) {
            if(this.grafo.containsKey(v)){
                System.out.println("\n O grafo já contem este valor como key.");
            }else{
                this.grafo.put(v, null);
            }           
        } 
    }

    public  void inserirArestaGrafo(Object v, Object a) {
        ArrayList<Object> auxiliar = new ArrayList();
        if (this.grafo.containsKey(v)) {
            if (this.grafo.get(v) != null) {
                auxiliar = (ArrayList<Object>) this.grafo.get(v);
            }
        }
        auxiliar.add(a);
        this.grafo.put(v, auxiliar);
    }

    public void removeKeyGrafo(Object v){
       this.grafo.remove(v);
    }

    public void removerTodasKeyGrafo(){
        this.grafo.clear();
    }
    
    public ArrayList<Object> getArestasVertice(Object v ){
        return (ArrayList<Object>) this.grafo.get(v);
    }
    
    public Set<Object> getAllKeys(){
        return  this.grafo.keySet();
    }
    
        
    public Collection<ArrayList<Object>> todosValoresGrafo(){
        return this.grafo.values();
    }
    
   
}
