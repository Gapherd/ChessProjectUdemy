package boardgame;

public abstract class Piece {
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

//METHODS
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean moves[][] = possibleMoves();
		
		for(int i = 0; i < moves.length; i++) {
			for(int j = 0; j < moves.length; j++) {
				if (moves[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
}
