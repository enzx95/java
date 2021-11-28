package src.Model;

public class Piece {
	String name, color;
	int id, y, x;
	boolean queen;

	public Piece(String name, String color, int id, int y, int x, boolean queen) {
		super();
		this.name = name;
		this.color = color;
		this.id = id;
		this.y = y;
		this.x = x;
		this.queen = queen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return color;
	}

	public void setColour(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean queen() {
		return queen;
	}

	public void setQueen(boolean queen) {
		this.queen = queen;
	}

}