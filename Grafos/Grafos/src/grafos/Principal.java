package grafos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class Principal {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        Grafo gr = new Grafo();
        int from, to;
        
        gr.montarGrafo();
        
        System.out.print("Digite o vertice de partida: ");
        from = scan.nextInt();
        System.out.print("\nDigite o vertice de destino: ");
        to = scan.nextInt();
        System.out.print("\n");
        
        gr.zeraEtiquetaVerticeInicial(from);
        
        gr.Dijkstra();
        
        System.out.println(gr.menorCaminho(from, to));
    }
}