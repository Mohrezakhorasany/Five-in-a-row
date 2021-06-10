package hu.ak_academy.fiveinrowoop;

import java.util.Scanner;

import hu.ak_academy.fiveinrowoop.validator.TableDimensionValidator;

public class UserInputHandler {
	// read whole number and read text
	private Scanner scanner;

	public UserInputHandler(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getPlayerName(String wholemsg) {
		System.out.println(wholemsg);
		return scanner.nextLine();
	}

	public Coordinates readCoordinates() {
		System.out.print("Please provide next row: ");
		int row = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Please provide next column: ");
		int column = scanner.nextInt();
		scanner.nextLine();
		return new Coordinates(row - 1, column - 1);
	}

	public TableDimension readTableDimension() {
		boolean tableDimensionValid;
		TableDimension tableDimension;
		do {
			System.out.print("Please provide the height of the table: ");
			int height = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please provide the width of the table: ");
			int width = scanner.nextInt();
			scanner.nextLine();
			tableDimension = new TableDimension(height, width);
			TableDimensionValidator tableDimensionValidator = new TableDimensionValidator(tableDimension);
			tableDimensionValid = tableDimensionValidator.isValid();
			if (!tableDimensionValid) {
				System.out.println(tableDimensionValidator.getErrorMessage());
			}
		} while (!tableDimensionValid);
		return tableDimension;
	}
}
