public class Reta {

	private Ponto p0, p1;
	private Ponto ponto = new Ponto();

	public void setVertices(Ponto p0, Ponto p1) {
		this.p0 = p0;
		this.p1 = p1;
	}

	public void desenhaReta(Cor c, Imagem img) {
		img.SetPixel(p0, c);
		img.SetPixel(p1, c);

		int x, y, erro, deltaX, deltaY;
		erro = 0;
		x = p0.x;
		y = p0.y;
		deltaX = p1.x - p0.x;
		deltaY = p1.y - p0.y;

		if ((Math.abs(deltaY) >= Math.abs(deltaX) && p0.y > p1.y)
				|| (Math.abs(deltaY) < Math.abs(deltaX) && deltaY < 0)) {
			x = p1.x;
			y = p1.y;
			deltaX = p0.x - p1.x;
			deltaY = p0.y - p1.y;
		}
		if (deltaX >= 0) {
			if (Math.abs(deltaX) >= Math.abs(deltaY)) {

				for (int i = 1; i < Math.abs(deltaX); i++) {
					if (erro < 0) {
						x++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaY;
					} else {
						x++;
						y++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaY - deltaX;
					}
				}
			} else {

				for (int i = 1; i < Math.abs(deltaY); i++) {
					if (erro < 0) {
						x++;
						y++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaY - deltaX;
					} else {
						y++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro -= deltaX;
					}
				}
			}
		} else {
			if (Math.abs(deltaX) >= Math.abs(deltaY)) {

				for (int i = 1; i < Math.abs(deltaX); i++) {
					if (erro < 0) {
						x--;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaY;
					} else {
						x--;
						y++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaY + deltaX;
					}
				}
			} else {

				for (int i = 1; i < Math.abs(deltaY); i++) {
					if (erro < 0) {
						x--;
						y++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaY + deltaX;
					} else {
						y++;
						ponto.x = x;
						ponto.y = y;
						img.SetPixel(ponto, c);
						erro += deltaX;
					}
				}
			}
		}
	}

}