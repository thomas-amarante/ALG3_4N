
import java.io.IOException;
import java.util.Scanner;


public class Sistema {


	private static Scanner sc = new Scanner(System.in);
	static Triangulo triangulo = new Triangulo();
	static Circulo circulo = new Circulo();
	static Retangulo retangulo = new Retangulo();
	static Reta reta = new Reta();
    
	int i = sc.nextInt();
	public static String cmd = "";


	public static void main(String[] args) {

		String cmd = "";
		Imagem img = new Imagem(0, 0, "");
		Cor cor = new Cor(0);

		if(cmd.equalsIgnoreCase("imagem")){
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			String p3 = sc.next();

			img = new Imagem(p1, p2, p3);
		}		

		if(cmd.equalsIgnoreCase("cor")){
			if(img.getCor().equalsIgnoreCase("g")){

				int cinza = sc.nextInt();
				cor = new Cor(cinza);				
			} 

			if(img.getCor().equalsIgnoreCase("c")){

				int red = sc.nextInt();
				int green = sc.nextInt();
				int blue = sc.nextInt();
				cor = new Cor(red, green, blue);
			}
		}

		if(cmd.equalsIgnoreCase("salvar")){
			String nomeArq = sc.next();			
			try {
				img.Salvar(nomeArq);
			} 
			catch (IOException e) {					
				e.printStackTrace();
			}
		}

		while (!cmd.equals("fim")) {
			cmd = sc.next();
			if(cmd.equals("triangulo")){
				entTriangulo();			
			}
			if(cmd.equals("circulo")){
				entCirculo();			
			}
			if(cmd.equals("retangulo")){
				entRetangulo();			
			}
			if(cmd.equals("reta")){
				entReta();				
			}
		}		
	}

	public static void entTriangulo(){
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();
		Ponto p2 = new Ponto();	

		Imagem img = new Imagem(0, 0, "");
		Cor cor = new Cor(0);

		if (cmd.equals("triangulo")) {
			p0.x = sc.nextInt();
			p0.y = sc.nextInt();		
			p1.x = sc.nextInt();
			p1.y = sc.nextInt();		
			p2.x = sc.nextInt();
			p2.y = sc.nextInt();		
			triangulo.setVertices(p0, p1, p2);
			triangulo.desenhaTriangulo(cor, img);
		}		
	}

	public static void entCirculo(){
		int x = sc.nextInt();
		int y = sc.nextInt();
		int raio = sc.nextInt();
		Imagem img = new Imagem(0, 0, "");
		Cor cor = new Cor(0);

		Circulo circulo = new Circulo( );
		circulo.setCentro(x, y);
		circulo.setRaio(raio);
		circulo.desenhaCirculo(cor, img);	
	}

	public static void entRetangulo(){
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();

		Imagem img = new Imagem(0, 0, "");
		Cor cor = new Cor(0);

		p0.x = sc.nextInt();
		p0.y = sc.nextInt();
		p1.x = sc.nextInt();
		p1.y = sc.nextInt();
		retangulo.setVertices(p0, p1);
		retangulo.desenhaRetangulo(cor, img);
	}

	public static void entReta(){
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();

		Imagem img = new Imagem(0, 0, "");
		Cor cor = new Cor(0);

		p0.x = sc.nextInt();
		p0.y = sc.nextInt();
		p1.x = sc.nextInt();
		p1.y = sc.nextInt();

		reta.setVertices(p0, p1);
		reta.desenhaReta(cor, img);
	}
}
