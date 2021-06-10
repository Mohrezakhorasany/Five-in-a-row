package hu.ak_academy.fiveinrowoop;

import hu.ak_academy.fiveinrowoop.checker.BestCheckTie;
import hu.ak_academy.fiveinrowoop.checker.BestCheckWinner;
import hu.ak_academy.fiveinrowoop.checker.Checker;
import hu.ak_academy.fiveinrowoop.validator.BoardBoundValidator;
import hu.ak_academy.fiveinrowoop.validator.EmptyFieldValidator;
import hu.ak_academy.fiveinrowoop.validator.UserInputValidator;

public class FiveInRowGame {

	private final Player[] players;
	private Player current;
	private int turnCounter;
	private final Board board;
	private final UserInputHandler userInputHandler;

	public FiveInRowGame(Player[] players, TableDimension tableDimension, UserInputHandler userInputHandler) {
		this.userInputHandler = userInputHandler;
		this.players = players;
		current = getNextPlayer();
		board = new Board(tableDimension);
	}

	public Player getNextPlayer() {
		return players[turnCounter % players.length];
	}

	public void run() {
		Checker checkTie = new BestCheckTie(board);
		System.out.println(board);
		Checker checkWinner;
		gameLoop: do {
			current = getNextPlayer();
			String nameOfPlayer = current.getName()
					.endsWith("s") ? current.getName() + "'" : current.getName() + "'s";
			System.out.println("It's " + nameOfPlayer + " turn.");
			checkWinner = new BestCheckWinner(board, current.getMark());
			Coordinates coordinates = userInputHandler.readCoordinates();
			UserInputValidator[] validators = { new BoardBoundValidator(board.getTableDimension(), coordinates), new EmptyFieldValidator(coordinates, board) };
			for (UserInputValidator validator : validators) {
				if (!validator.isValid()) {
					System.out.println(validator.getErrorMessage());
					continue gameLoop;
				}
			}
			board.setMark(coordinates, current.getMark());
			System.out.println(board);
			turnCounter++;
		} while (!checkWinner.check() && !checkTie.check());
		if (checkWinner.check()) {
			System.out.println("We have winner, winner is " + current.getName());
		}
		if (checkTie.check()) {
			System.out.println("We have a tie!");
		}
		System.out.println("Good Bye!");

	}

}
