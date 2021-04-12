package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {
//ATTRIBUTES
	private Color color;
	
//CONSTRUCTOR
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

//GETS & SETS
	public Color getColor() {
		return color;
	}
}
