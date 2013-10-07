public class Circulo {

	private Ponto centro = new Ponto();
	private Ponto ponto = new Ponto();
	private int raio;

	public void setCentro(int x, int y) {
		this.centro.x = x;
		this.centro.y = y;
	}

	public void setRaio(int r) {

		this.raio = r;

	}

	public void desenhaCirculo(Cor cor, Imagem img) {

		int x = 0, y = raio, u = 1, v = 2 * raio - 1, E = 0;

		while (x < y) {
			ponto.x = centro.x + x;
			ponto.y = centro.y + y;
			img.SetPixel(ponto, cor);

			ponto.x = centro.x + y;
			ponto.y = centro.y - x;
			img.SetPixel(ponto, cor);

			ponto.x = centro.x - x;
			ponto.y = centro.y - y;
			img.SetPixel(ponto, cor);

			ponto.x = centro.x - y;
			ponto.y = centro.y + x;
			img.SetPixel(ponto, cor);

			x++;
			E += u;
			u += 2;

			if (v < 2 * E) {
				y--;
				E -= v;
				v -= 2;
			}
			if (x > y)
				break;

			ponto.x = centro.x + y;
			ponto.y = centro.y + x;
			img.SetPixel(ponto, cor);

			ponto.x = centro.x + x;
			ponto.y = centro.y - y;
			img.SetPixel(ponto, cor);

			ponto.x = centro.x - y;
			ponto.y = centro.y - x;
			img.SetPixel(ponto, cor);

			ponto.x = centro.x - x;
			ponto.y = centro.y + y;
			img.SetPixel(ponto, cor);
		}
	}

}