public class Cor {

	private int red;
	private int green;
	private int blue;
	private int grey;

	public Cor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public Cor(int cinza) {
		this.grey = cinza;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getblue() {
		return blue;
	}

	public int getGrey() {
		return grey;
	}

}