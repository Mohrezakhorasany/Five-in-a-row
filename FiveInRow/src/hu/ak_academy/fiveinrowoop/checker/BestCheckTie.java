package hu.ak_academy.fiveinrowoop.checker;

import hu.ak_academy.fiveinrowoop.Board;
import hu.ak_academy.fiveinrowoop.Coordinates;

public class BestCheckTie implements Checker {
	private final Board board;

	public BestCheckTie(Board board) {
		this.board = board;
	}

	@Override
	public boolean check() {
		Board forXMark = new Board(board);
		Board forOMark = new Board(board);
		inserMarkIfItsNotEmpty(forXMark, "X");
		inserMarkIfItsNotEmpty(forOMark, "O");
		BestCheckWinner bestCheckWinnerForX = new BestCheckWinner(forXMark, "X");
		BestCheckWinner bestCheckWinnerForO = new BestCheckWinner(forOMark, "O");
		return !bestCheckWinnerForO.check() && !bestCheckWinnerForX.check();
	}

	private void inserMarkIfItsNotEmpty(Board board, String mark) {
		for (int row = 0; row < board.getTableDimension()
				.getHeight(); row++) {
			for (int column = 0; column < board.getTableDimension()
					.getWidth(); column++) {
				Coordinates coordinates = new Coordinates(row, column);
				if (board.getMark(
						coordinates)
						.equals(" ")) {
					board.setMark(coordinates, mark);
				}
			}
		}
	}

}
