import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;



public class Sistema {


private static Scanner sc = new Scanner(System.in);

static Imagem img = new Imagem(0,0,"");

public static void main(String[] args) throws IOException {
	
	
	
	System.out.println("Digite a forma geométrica que você deseja:");
	while(sc.hasNext()){
		String comando = sc.next().toLowerCase();
		
		switch (comando) {
		
		case "fim": System.exit(0);
			break;
		
		case"imagem": TrataComandoImagem();
			break;
		
		case "Circulo": TrataComandoCirculo();
			break;
			
		case "Triangulo": TrataComandoTriangulo();
			break;
			
		case "Reta": TrataComandoReta();
			break;
		
		case "Retangulo": TrataComandoRetangulo();
			break;
		
		case "Cor": TrataComandoCor();
			break;
		
		case "salvar":
			try{
			TrataComandoSalvar();
			}
			catch (Exception e){
				System.out.println(e);
			}
			break;

		default:TrataComandoErrado();
			break;
	
			}
		}
	}
	
	public static void TrataComandoImagem(){
		
		int width = sc.nextInt();
		int heigth = sc.nextInt();
		String type = sc.next();
		
		img.setAlt(heigth);
		img.setLar(width);
		img.setCor(type);
		
		
		img = new Imagem (heigth, width, type);
		
	}
	
	
	public static void TrataComandoCirculo(){
		Ponto p = new Ponto();
		
		p.x= sc.nextInt();
		p.y= sc.nextInt();
		int Raio = sc.nextInt();
		Circulo circulo = new Circulo();
		
		circulo.setCentro(p.x, p.y);
		circulo.setRaio(Raio);
	}
	
	public static void TrataComandoErrado () {
	
		System.out.println("Comando inválido!");
	}
	
	public static void TrataComandoSalvar() throws IOException{
		
		String aux = sc.next();
		img.Salvar(aux);	
		
	}
	
    public static void TrataComandoRetangulo(){
    	Ponto p0 = new Ponto();
    	Ponto p1 = new Ponto();
		
		p0.x= sc.nextInt();
		p0.y= sc.nextInt();
		
		p1.x= sc.nextInt();
		p1.y= sc.nextInt();
		
		Retangulo retangulo = new Retangulo();
		retangulo.setVertices(p0, p1);
	}
    
    public static void TrataComandoReta(){
    	Ponto p0 = new Ponto();
    	Ponto p1 = new Ponto();
		
		p0.x= sc.nextInt();
		p0.y= sc.nextInt();
		
		p1.x= sc.nextInt();
		p1.y= sc.nextInt();
		
		Reta reta = new Reta();
		reta.setVertices(p0, p1);
	}
    
    public static void TrataComandoTriangulo(){
    	Ponto p0 = new Ponto();
    	Ponto p1 = new Ponto();
		Ponto p2 = new Ponto();
		
		p0.x= sc.nextInt();
		p0.y= sc.nextInt();
		
		p1.x= sc.nextInt();
		p1.y= sc.nextInt();
		
		p2.x= sc.nextInt();
		p2.y= sc.nextInt();
		
		Triangulo triangulo = new Triangulo();
		triangulo.setVertices(p0, p1, p2);
	}
    
    public static void TrataComandoCor(){
		int R = sc.nextInt();
		int G = sc.nextInt();
		int B = sc.nextInt();
		
    	Cor cor = new Cor(R, G, B);
		
    }

}