package hu.ak_academy.fiveinrowoop.checker;

import hu.ak_academy.fiveinrowoop.Board;
import hu.ak_academy.fiveinrowoop.Coordinates;

public class StringCheckWinner implements Checker {

	private final String mark;
	private final Board board;

	public StringCheckWinner(Board board, String mark) {
		this.board = board;
		this.mark = mark;
	}

	@Override
	public boolean check() {
		return checkHorizontal() || checkVertical() || checkBackSlash() || checkSlash();
	}

	private boolean checkHorizontal() {
		String winnerPattern = mark.repeat(5);
		StringBuilder horizontal = new StringBuilder(board.getTableDimension()
				.getHeight()
				* (board.getTableDimension()
						.getWidth() + 1));
		for (int row = 0; row < board.getTableDimension()
				.getHeight(); row++) {
			horizontal.append(" ");
			for (int column = 0; column < board.getTableDimension()
					.getWidth(); column++) {
				horizontal.append(board.getMark(new Coordinates(row, column)));
			}
		}
		return horizontal.toString()
				.contains(winnerPattern);
	}

	private boolean checkVertical() {
		String winnerPattern = mark.repeat(5);
		StringBuilder vertical = new StringBuilder((board.getTableDimension()
				.getHeight() + 1) * board.getTableDimension()
						.getWidth());
		for (int column = 0; column < board.getTableDimension()
				.getWidth(); column++) {
			vertical.append(" ");
			for (int row = 0; row < board.getTableDimension()
					.getHeight(); row++) {
				vertical.append(board.getMark(new Coordinates(row, column)));
			}
		}
		return vertical.toString()
				.contains(winnerPattern);
	}

	private boolean checkBackSlash() {
		String winnerPattern = mark.repeat(5);
		StringBuilder backSlash = new StringBuilder((board.getTableDimension()
				.getHeight() + 1)
				* (board.getTableDimension()
						.getWidth() + 1));
		int virtualColumn = 0;
		for (int column = -board.getTableDimension()
				.getHeight() + 1; column < board.getTableDimension()
						.getWidth(); column++) {
			backSlash.append(" ");
			virtualColumn = column;
			for (int row = 0; row < board.getTableDimension()
					.getHeight()
					&& virtualColumn < board.getTableDimension()
							.getWidth(); virtualColumn++, row++) {
				if (virtualColumn >= 0) {
					backSlash.append(board.getMark(new Coordinates(row, virtualColumn)));
				}
			}
		}
		return backSlash.toString()
				.contains(winnerPattern);
	}

	private boolean checkSlash() {
		String winnerPattern = mark.repeat(5);
		StringBuilder slash = new StringBuilder((board.getTableDimension()
				.getHeight() + 1) * board.getTableDimension()
						.getWidth()
				+ 1);
		int virtualColumn = 0;
		for (int column = (board.getTableDimension()
				.getHeight()
				+ board.getTableDimension()
						.getWidth())
				- 2; column >= 0; column--) {
			slash.append(" ");
			virtualColumn = column;
			for (int row = 0; row < board.getTableDimension()
					.getHeight() && virtualColumn >= 0; virtualColumn--, row++) {
				if (virtualColumn < board.getTableDimension()
						.getWidth()) {
					slash.append(board.getMark(new Coordinates(row, virtualColumn)));
				}
			}
		}
		return slash.toString()
				.contains(winnerPattern);
	}

}
