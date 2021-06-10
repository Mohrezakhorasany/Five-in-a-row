package hu.ak_academy.fiveinrowoop;

public class TableDimension {

	private final int height;
	private final int width;

	public TableDimension(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public String toString() {
		return height + " x " + width;
	}

}
