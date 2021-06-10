package hu.ak_academy.fiveinrowoop.checker;

public enum CheckDirection {
	HORIZONTAL(0, 1), VERTICAL(1, 0), SLASH(-1, +1), BACKSLASH(+1, +1);

	private final int rowDelta;
	private final int columnDelta;

	private CheckDirection(int rowDelta, int columnDelta) {
		this.rowDelta = rowDelta;
		this.columnDelta = columnDelta;
	}

	public int getRowDelta() {
		return rowDelta;
	}

	public int getColumnDelta() {
		return columnDelta;
	}

}
