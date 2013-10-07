import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Imagem {

	private int[][] img;
	private String cor = "";
	private int alt;
	private int lar;

	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	public int getLar() {
		return lar;
	}

	public void setLar(int lar) {
		this.lar = lar;
	}

	public Imagem(int alt, int lar, String cor) {
		this.img = new int[alt][lar];
		this.cor = cor;
	}

	public void SetPixel(Ponto p, Cor cor) {

		if (this.cor.equalsIgnoreCase("g")) {
			img[p.x][p.y] = cor.getGrey();
		}
	}

	public void Salvar(String nomeArq) throws IOException {

		BufferedWriter out = new BufferedWriter(
				new FileWriter(nomeArq + ".pnm"));

		if (this.cor.equalsIgnoreCase("g")) {
			out.write(String.format("P2\n%d %d\n255\n", img[0].length,
					img[0].length));
		} else {
			out.write(String.format("P3\n%d %d\n255\n", img[0].length,
					img[0].length));
		}

		for (int[] linha : img) {
			for (int l : linha) {
				out.write(String.format("%d ", l));
			}
		}
		out.close();
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	/*
	 * public ImageIcon GeraImagem (){
	 * 
	 * BufferedImage buffer = new BufferedImage( alt, lar,
	 * BufferedImage.TYPE_INT_RGB ); Graphics g = buffer.createGraphics();
	 * g.setColor( cor ); g.fillRect( 0, 0, alt, lar ); g.setColor( Color.BLACK
	 * ); g.drawLine( 0, 0, alt, lar ); return new ImageIcon( buffer ); }
	 */

}