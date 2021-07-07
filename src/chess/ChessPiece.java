package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
//ATTRIBUTES
	private Color color;
	private int moveCount;
	
//CONSTRUCTOR
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

//GETS & SETS
	public Color getColor() {
		return color;
	}

	public int getMoveCount(){
		return moveCount;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

//METHODS
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}

}
