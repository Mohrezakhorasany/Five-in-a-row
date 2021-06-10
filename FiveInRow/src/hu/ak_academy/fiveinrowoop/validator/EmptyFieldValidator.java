package hu.ak_academy.fiveinrowoop.validator;

import hu.ak_academy.fiveinrowoop.Board;
import hu.ak_academy.fiveinrowoop.Coordinates;

public class EmptyFieldValidator implements UserInputValidator {
	private final Coordinates coordinates;
	private final Board board;

	public EmptyFieldValidator(Coordinates coordinates, Board board) {
		this.coordinates = coordinates;
		this.board = board;
	}

	@Override
	public boolean isValid() {
		return board.getMark(coordinates)
				.equals(" ");
	}

	@Override
	public String getErrorMessage() {
		return "The cell is not empty!";
	}

}
