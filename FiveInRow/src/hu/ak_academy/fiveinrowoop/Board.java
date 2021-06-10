package hu.ak_academy.fiveinrowoop;

public class Board {
	private final TableDimension tableDimension;
	private String[][] state;

	// be able to create String representation of the board
	// it should be able to put mark at given coordinate

	public Board(TableDimension tableDimension) {
		this.tableDimension = tableDimension;
		state = new String[tableDimension.getHeight()][tableDimension.getWidth()];
		for (int row = 0; row < tableDimension.getHeight(); row++) {
			for (int column = 0; column < tableDimension.getWidth(); column++) {
				state[row][column] = " ";
			}
		}
	}

	public Board(Board otherBoard) {
		tableDimension = otherBoard.tableDimension;
		state = new String[tableDimension.getHeight()][tableDimension.getWidth()];
		for (int row = 0; row < tableDimension.getHeight(); row++) {
			for (int column = 0; column < tableDimension.getWidth(); column++) {
				state[row][column] = otherBoard.state[row][column];
			}
		}
	}

	public TableDimension getTableDimension() {
		return tableDimension;
	}

//	┌───┬───┬───┬───┬───┬───┬───┐
//	│   │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 1 │ X │ O │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 2 │ O │ X │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 3 │   │   │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 4 │   │   │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 5 │   │   │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 6 │   │   │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 7 │   │   │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 8 │   │   │   │   │   │   │
//	├───┼───┼───┼───┼───┼───┼───┤
//	│ 9 │   │   │   │   │   │   │
//	└───┴───┴───┴───┴───┴───┴───┘

	public String getMark(Coordinates coordinates) {
		return state[coordinates.getRow()][coordinates.getColumn()];
	}

	public void setMark(Coordinates coordinates, String mark) {
		state[coordinates.getRow()][coordinates.getColumn()] = mark;
	}

	@Override
	public String toString() {
		int gridHeight = tableDimension.getHeight() * 2 + 3;
		int gridWidth = tableDimension.getWidth() * 4 + 5;
		String[][] grid = new String[gridHeight][gridWidth];
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				grid[row][column] = " ";
			}
		}
		int lastColumnIndex = gridWidth - 1;
		int lastRowIndex = gridHeight - 1;
		grid[0][0] = "┌";
		grid[0][lastColumnIndex] = "┐";
		grid[lastRowIndex][0] = "└";
		grid[lastRowIndex][lastColumnIndex] = "┘";
		for (int rowIndex = 0; rowIndex <= lastRowIndex; rowIndex += 2) {
			drawHorizantalLine(grid, lastColumnIndex, rowIndex);
		}
		for (int columnIndex = 0; columnIndex <= lastColumnIndex; columnIndex += 4) {
			drawVerticalLine(grid, lastRowIndex, columnIndex);
		}

		for (int columnIndex = 4; columnIndex < lastColumnIndex; columnIndex += 4) {
			for (int rowIndex = 2; rowIndex < lastRowIndex; rowIndex += 2) {
				grid[rowIndex][columnIndex] = "┼";
			}
		}
		for (int columnIndex = 4; columnIndex < lastColumnIndex; columnIndex += 4) {
			grid[0][columnIndex] = "┬";
		}
		for (int rowIndex = 2; rowIndex < lastRowIndex; rowIndex += 2) {
			grid[rowIndex][0] = "├";
		}
		for (int rowIndex = 2; rowIndex < lastRowIndex; rowIndex += 2) {
			grid[rowIndex][lastColumnIndex] = "┤";
		}
		for (int columnIndex = 4; columnIndex < lastColumnIndex; columnIndex += 4) {
			grid[lastRowIndex][columnIndex] = "┴";
		}
		addRowNumbering(grid);
		addColumnNumbering(grid);
		addState(grid);
		StringBuilder builder = new StringBuilder();
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				builder.append(grid[row][column]);
			}
			builder.append("\n");
		}

		return builder.toString();
	}

	private void addState(String[][] grid) {
		for (int a = 0; a < tableDimension.getHeight(); a++) {
			for (int b = 0; b < tableDimension.getWidth(); b++) {
				int c = a * 2 + 3;
				int d = b * 4 + 6;
				grid[c][d] = state[a][b];
			}
		}
	}

	private void drawHorizantalLine(String[][] grid, int lastColumnIndex, int rowIndex) {
		for (int i = 1; i < lastColumnIndex; i++) {
			if (grid[rowIndex][i].equals(" ")) {
				grid[rowIndex][i] = "─";
			}
		}
	}

	private void drawVerticalLine(String[][] grid, int lastRowIndex, int columnIndex) {
		for (int i = 1; i < lastRowIndex; i++) {
			if (grid[i][columnIndex].equals(" ")) {
				grid[i][columnIndex] = "│";
			}
		}
	}

	private void addRowNumbering(String[][] grid) {
		for (int row = 1; row <= tableDimension.getHeight(); row++) {
			if (row > 9) {
				int tens = row / 10;
				int ones = row % 10;
				grid[row * 2 + 1][1] = Integer.toString(tens);
				grid[row * 2 + 1][2] = Integer.toString(ones);

			} else {
				grid[row * 2 + 1][2] = Integer.toString(row);
			}
		}
	}

	private void addColumnNumbering(String[][] grid) {
		for (int column = 1; column <= tableDimension.getWidth(); column++) {
			if (column > 9) {
				int tens = column / 10;
				int ones = column % 10;
				grid[1][column * 4 + 1] = Integer.toString(tens);
				grid[1][column * 4 + 2] = Integer.toString(ones);
			} else {
				grid[1][column * 4 + 2] = Integer.toString(column);
			}
		}
	}

}
