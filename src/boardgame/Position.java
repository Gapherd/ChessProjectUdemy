package boardgame;

public class Position {
//ATTRIBUTES
	private int row;
	private int column;
	
//CONSTRUCTOR
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

//GETS & SETS
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
//METHODS
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return row + ", " + column;
	}
	
}
