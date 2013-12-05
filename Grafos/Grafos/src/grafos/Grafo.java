package grafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Grafo {

    Scanner scan;
    private ArrayList<Vertice> grafo = new ArrayList<Vertice>();
    private ArrayList<Integer> caminho = new ArrayList<Integer>();
    int verticeExiste = -1;
    int vizinhoExiste = -1;

    public Grafo() throws FileNotFoundException {
        this.scan = new Scanner(new FileReader("Grafo.txt"));
    }

    public void montarGrafo() throws FileNotFoundException, IOException {
        String idVertice, vizinho;

        idVertice = scan.next(); // ler primeiro número do arquivo

        Vertice ver = new Vertice();
        ver.setId(Integer.parseInt(idVertice));// atribui por parâmetro
        vizinho = scan.next(); // ler segundo número do arquivo 
        this.vizinhoExiste = vizinhoExiste(Integer.parseInt(vizinho));
        if (this.vizinhoExiste == -1) { // se vizinhoExiste não existir
            Vertice ver3 = new Vertice();

            ver3.setId(Integer.parseInt(vizinho));

            grafo.add(ver3);
        }
        ver.setVerticeVizinhos(Integer.parseInt(vizinho));//atribui vizinho a partir da var vizinho
        ver.setPeso(Integer.parseInt(scan.next())); //ler 3º parâmetro e setando como peso 

        grafo.add(ver);

        while (scan.hasNext()) { // enquanto houverem linhas para serem analisadas
            idVertice = scan.next(); // ler e atribuir valor para essa variável

            this.verticeExiste = verticeExiste(Integer.parseInt(idVertice)); // conversao para integer e passagem de parametro para o metodo
            if (this.verticeExiste != -1) { // verifica se existe vizinho
                vizinho = scan.next(); // se sim, lê segundo numero do arquivo
                vizinhoExiste = vizinhoExiste(Integer.parseInt(vizinho));
                if (vizinhoExiste == -1) { // se não, cai dentro do if
                    Vertice ver4 = new Vertice();

                    ver4.setId(Integer.parseInt(vizinho));

                    grafo.add(ver4);
                }
                grafo.get(this.verticeExiste).setVerticeVizinhos(Integer.parseInt(vizinho)); // seta o vertice vizinho para o grafo
                grafo.get(this.verticeExiste).setPeso(Integer.parseInt(scan.next())); // lê 3º numero da linha no arquivo e seta o peso do grafo
            } else {
                Vertice ver1 = new Vertice();
                ver1.setId(Integer.parseInt(idVertice));
                vizinho = scan.next();
                this.vizinhoExiste = vizinhoExiste(Integer.parseInt(vizinho));
                if (this.vizinhoExiste == -1) {
                    Vertice ver5 = new Vertice();

                    ver5.setId(Integer.parseInt(vizinho));

                    grafo.add(ver5);
                }
                ver1.setVerticeVizinhos(Integer.parseInt(vizinho));
                ver1.setPeso(Integer.parseInt(scan.next()));
                grafo.add(ver1);
            }
        }
    }

    public int verticeExiste(int id) {
        this.verticeExiste = -1;
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == id) {
                this.verticeExiste = i;
                break;
            }
        }
        return this.verticeExiste;
    }
    
    public int vizinhoExiste(int id) {
        this.vizinhoExiste = -1;
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == id) {
                this.vizinhoExiste = i;
                break;
            }
        }
        return this.vizinhoExiste;
    }

    public void zeraEtiquetaVerticeInicial(int from) { // zera o peso inicial do nodo de origem
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == from) {
                grafo.get(i).setEtiqueta(0);
                break;
            }
        }
    }

    public void Dijkstra() {
        int existeVerticeNaoVisitado;
        int menorEtiquetaNaoVisitada = Integer.MAX_VALUE;
        do {
            existeVerticeNaoVisitado = 0;

            for (int i = 0; i < grafo.size(); i++) {
                if (grafo.get(i).getEtiqueta() <= menorEtiquetaNaoVisitada && (grafo.get(i).isVisitado() == false)) {
                    menorEtiquetaNaoVisitada = grafo.get(i).getEtiqueta();
                }
            }

            for (int i = 0; i < grafo.size(); i++) {
                if (grafo.get(i).getEtiqueta() == menorEtiquetaNaoVisitada && (grafo.get(i).isVisitado() == false)) {
                    grafo.get(i).setVisitado(true);

                    for (int j = 0; j < grafo.get(i).getVerticeVizinhos().size(); j++) {
                        int id = grafo.get(i).getVerticeVizinhos().get(j);
                        
                        for(int k = 0; k < grafo.size(); k++){
                            if(grafo.get(k).getId() == id){
                                id = k;
                                break;
                            }
                        }
                        
                        int soma = grafo.get(i).getEtiqueta() + grafo.get(i).getPeso().get(j);
                        if(soma < 0){
                            soma = Integer.MAX_VALUE;
                        }
                        
                        if (grafo.get(id).getEtiqueta() > soma) {
                            grafo.get(id).setEtiqueta(grafo.get(i).getEtiqueta() + grafo.get(i).getPeso().get(j));
                            grafo.get(id).setPrecedente(grafo.get(i).getId());
                        }
                    }
                    menorEtiquetaNaoVisitada = Integer.MAX_VALUE;
                    break;
                }
            }

            for (int i = 0; i < grafo.size(); i++) {
                if (!grafo.get(i).isVisitado()) {
                    existeVerticeNaoVisitado++;
                }
            }

        } while (existeVerticeNaoVisitado != 0);
    }

    public String menorCaminho(int from, int to) {
        String menorCaminho = "";
        this.caminho.add(to);

        for (int i = 0; i < this.grafo.size(); i++) {
            if (this.grafo.get(i).getId() == to && to != from) {
                this.caminho.add(this.grafo.get(i).getPrecedente());
                to = this.grafo.get(i).getPrecedente();
                i = 0;
            }
        }

        for (int i = caminho.size() - 1; i >= 0; i--) {
            menorCaminho = menorCaminho + this.caminho.get(i);
            if(i != 0){
                 menorCaminho = menorCaminho + " --> ";
            }
        }

        return menorCaminho;
    }
}
