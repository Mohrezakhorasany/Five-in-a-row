package hu.ak_academy.fiveinrowoop;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputHandler userInputHandler = new UserInputHandler(scanner);
			System.out.println("Welcome to five in a row game!");
			String playerXName = userInputHandler.getPlayerName("Player X, Please provide your name: ");
			String playerOName = userInputHandler.getPlayerName("Player O, Please provide your name: ");
			Player playerX = new Player(playerXName, "X");
			Player playerO = new Player(playerOName, "O");
			TableDimension tableDimension = userInputHandler.readTableDimension();
			Player[] players = { playerX, playerO };
			FiveInRowGame fiveInRowGame = new FiveInRowGame(players, tableDimension, userInputHandler);
			fiveInRowGame.run();
		}

	}

}
