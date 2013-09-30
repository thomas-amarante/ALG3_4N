public class Cor {

	private int red;
	private int green;
	private int yellow;
	private int grey;

	public Cor(int red, int green, int yellow) {
		this.red = red;
		this.green = green;
		this.yellow = yellow;
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

	public int getyellow() {
		return yellow;
	}

	public int getGrey() {
		return grey;
	}

}