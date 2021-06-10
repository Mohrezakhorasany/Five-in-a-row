package hu.ak_academy.fiveinrowoop;

public class Player {
// to keep track of the mark and the name of the player
	private final String name;
	private final String mark;

	public Player(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public String getMark() {
		return mark;
	}

	@Override
	public String toString() {
		return "Player: " + name + "(" + mark + ")";
	}

}
