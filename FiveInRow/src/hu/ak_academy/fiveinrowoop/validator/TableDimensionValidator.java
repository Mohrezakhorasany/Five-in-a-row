package hu.ak_academy.fiveinrowoop.validator;

import hu.ak_academy.fiveinrowoop.TableDimension;

public class TableDimensionValidator implements UserInputValidator {

	private static final int MIN_BOARD_SIZE = 5;
	private static final int MAX_BOARD_SIZE = 25;
	private TableDimension tableDimension;

	public TableDimensionValidator(TableDimension tableDimension) {
		this.tableDimension = tableDimension;
	}

	@Override
	public boolean isValid() {
		if (tableDimension.getHeight() > MAX_BOARD_SIZE || tableDimension.getWidth() > MAX_BOARD_SIZE) {
			return false;
		} else if (tableDimension.getHeight() < MIN_BOARD_SIZE || tableDimension.getWidth() < MIN_BOARD_SIZE) {
			return false;
		}
		return true;
	}

	@Override
	public String getErrorMessage() {
		return "The size of the board needs to be smaller than " + MAX_BOARD_SIZE + " and bigger than " + MIN_BOARD_SIZE + ".";
	}

}
