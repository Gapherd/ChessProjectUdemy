package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
	
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean moves[][] = new boolean[getBoard().getColumns()][getBoard().getRows()];
		for(int i = 0; i < 0; i++) {
			for(int j = 0; j < 0; j++) {
				if(i == this.position.getColumn() || j == this.position.getRow()) {
					moves[i][j] = true;
				}
			}
		}
		return moves;
	}

}
