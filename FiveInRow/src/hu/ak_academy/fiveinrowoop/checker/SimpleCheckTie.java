package hu.ak_academy.fiveinrowoop.checker;

import hu.ak_academy.fiveinrowoop.Board;
import hu.ak_academy.fiveinrowoop.Coordinates;

public class SimpleCheckTie implements Checker {
	private final Board board;

	public SimpleCheckTie(Board board) {
		this.board = board;
	}

	@Override
	public boolean check() {
		for (int row = 0; row < board.getTableDimension()
				.getHeight(); row++) {
			for (int column = 0; column < board.getTableDimension()
					.getWidth(); column++) {
				if (board.getMark(new Coordinates(row, column))
						.equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}

}
