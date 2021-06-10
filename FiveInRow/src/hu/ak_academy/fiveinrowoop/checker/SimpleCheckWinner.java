package hu.ak_academy.fiveinrowoop.checker;

import hu.ak_academy.fiveinrowoop.Board;
import hu.ak_academy.fiveinrowoop.Coordinates;

public class SimpleCheckWinner implements Checker {

	private final String mark;
	private final Board board;

	public SimpleCheckWinner(Board board, String mark) {
		this.board = board;
		this.mark = mark;
	}

	@Override
	public boolean check() {
		int counter = 0;
		for (int row = 0; row < board.getTableDimension()
				.getHeight(); row++) {
			counter = 0;
			for (int column = 0; column < board.getTableDimension()
					.getWidth(); column++) {
				if (board.getMark(new Coordinates(row, column))
						.equals(mark)) {
					counter++;
					if (counter == 5) {
						return true;
					}
				} else {
					counter = 0;
				}
			}
		}
		for (int column = 0; column < board.getTableDimension()
				.getWidth(); column++) {
			counter = 0;
			for (int row = 0; row < board.getTableDimension()
					.getHeight(); row++) {
				if (board.getMark(new Coordinates(row, column))
						.equals(mark)) {
					counter++;
					if (counter == 5) {
						return true;
					}
				} else {
					counter = 0;
				}
			}
		}
		for (int startingRow = 0; startingRow < board.getTableDimension()
				.getHeight() - 5 + 1; startingRow++) {
			int i = startingRow;
			counter = 0;
			for (int startingColumn = 0; startingColumn < board.getTableDimension()
					.getWidth()
					&& i < board.getTableDimension()
							.getWidth(); startingColumn++, i++) {
				if (board.getMark(new Coordinates(i, startingColumn))
						.equals(mark)) {
					counter++;
					if (counter == 5) {
						return true;
					}
				} else {
					counter = 0;
				}
			}

		}
		for (int column = 0; column < board.getTableDimension()
				.getWidth() - 5 + 1; column++) {
			int i = column;
			counter = 0;
			for (int row = 0; row < board.getTableDimension()
					.getHeight()
					&& i < board.getTableDimension()
							.getHeight(); row++, i++) {
				if (board.getMark(new Coordinates(row, i))
						.equals(mark)) {
					counter++;
					if (counter == 5) {
						return true;
					}
				} else {
					counter = 0;
				}
			}

		}
		for (int column = board.getTableDimension()
				.getWidth() -1 ; column >= 4; column--) {
			int i = column;
			counter = 0;
			for (int row = 0; row < board.getTableDimension()
					.getHeight() && i >= 0; row++, i--) {
				if (board.getMark(new Coordinates(row, i))
						.equals(mark)) {
					counter++;
					if (counter == 5) {
						return true;
					}
				} else {
					counter = 0;
				}
			}
		}
		return false;
	}
}
