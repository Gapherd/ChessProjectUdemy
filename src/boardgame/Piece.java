package boardgame;

public class Piece {
//ATTRIBUTES
	protected Position position;
	private Board board;
	
//CONSTRUCTOR
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

//GETS & SETS
	protected Board getBoard() {
		return board;
	}
	
	protected void setPosition(Position position) {
		this.position = position;
	}

}
