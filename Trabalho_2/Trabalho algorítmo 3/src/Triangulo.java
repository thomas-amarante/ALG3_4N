public class Triangulo {
	private Ponto p0, p1, p2;

	public void setVertices(Ponto p0, Ponto p1, Ponto p2){
		this.p0 = p0;
		this.p1 = p1;
		this.p2 = p2;
	}

	public void desenhaTriangulo(Cor cor, Imagem img) {
		Reta reta = new Reta();
		reta.setVertices(p0, p1);
		reta.desenhaReta(cor, img);

		reta.setVertices(p0, p2);
		reta.desenhaReta(cor, img);

		reta.setVertices(p2, p1);
		reta.desenhaReta(cor, img);		
	}
}