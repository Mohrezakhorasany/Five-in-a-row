package hu.ak_academy.fiveinrowoop.checker;

import hu.ak_academy.fiveinrowoop.Board;
import hu.ak_academy.fiveinrowoop.Coordinates;
import hu.ak_academy.fiveinrowoop.validator.BoardBoundValidator;

public class BestCheckWinner implements Checker {

	private final String mark;
	private final Board board;

	public BestCheckWinner(Board board, String mark) {
		this.board = board;
		this.mark = mark;
	}

	@Override
	public boolean check() {
		for (CheckDirection direction : CheckDirection.values()) {
			if (check(direction)) {
				return true;
			}
		}
		return false;
	}

	private boolean check(CheckDirection direction) {
		for (int startingRow = 0; startingRow < board.getTableDimension()
				.getHeight(); startingRow++) {
			columnLoop: for (int startingColumn = 0; startingColumn < board.getTableDimension()
					.getWidth(); startingColumn++) {
				int rowToCheckNext = startingRow;
				int columnToCheckNext = startingColumn;
				for (int counter = 0; counter < 5; counter++) {
					Coordinates coordinates = new Coordinates(rowToCheckNext, columnToCheckNext);
					if (!new BoardBoundValidator(board.getTableDimension(), coordinates).isValid() || !board.getMark(coordinates)
							.equals(mark)) {
						continue columnLoop;
					}
					rowToCheckNext += direction.getRowDelta();
					columnToCheckNext += direction.getColumnDelta();
				}
				return true;
			}
		}
		return false;
	}
}
