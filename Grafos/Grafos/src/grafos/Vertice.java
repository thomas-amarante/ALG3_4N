package grafos;

import java.util.ArrayList;


public class Vertice {
    private int id;
    private int etiqueta = Integer.MAX_VALUE;
    private boolean visitado = false;
    private int precedente = -1;
    private ArrayList<Integer> verticesVizinhos = new ArrayList<Integer>();
    private ArrayList<Integer> peso = new ArrayList<Integer>();
    
    public int getEtiqueta() {
        return etiqueta;
    }

    public int getPrecedente() {
        return precedente;
    }

    public void setPrecedente(int precedente) {
        this.precedente = precedente;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getVerticeVizinhos() {
        return verticesVizinhos;
    }

    public void setVerticeVizinhos(int are) {
        this.verticesVizinhos.add(are);
    }

    public ArrayList<Integer> getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso.add(peso);
    }
    
}