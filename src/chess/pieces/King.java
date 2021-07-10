package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
//ATTRIBUTES
	private ChessMatch chessMatch;
	
//CONSTRUCTOR
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

//METHODS
	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		if(p == null || p.getColor() != getColor()) {
			return true;
		}
		return false;
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		
		if(p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean moves[][] = new boolean[getBoard().getRows()][getBoard().getColumns()]; 
		
		Position p = new Position(0, 0);
				
		//above
		p.setValues(position.getRow() -1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		// below
		p.setValues(position.getRow() +1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//nw
		p.setValues(position.getRow() -1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//ne
		p.setValues(position.getRow() -1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//sw
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//se
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		//castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//short castling
			p.setValues(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(p)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					Position origin = new Position(position.getRow(), position.getColumn());
					Boolean noChecks = true;
					getBoard().removePiece(position);
					getBoard().placePiece(this, p1);
					noChecks = (!chessMatch.testCheck(getColor())) ? true : false;
					
					if(noChecks) {
						getBoard().removePiece(p1);
						getBoard().placePiece(this, p2);
						noChecks = (!chessMatch.testCheck(getColor())) ? true : false;
						getBoard().removePiece(p2);
						getBoard().placePiece(this, origin);
					} else {
						getBoard().removePiece(p1);
						getBoard().placePiece(this, origin);
					}
					
					if(noChecks) {
						moves[position.getRow()][position.getColumn() + 2] = true;
					}
				}
			}
			
			//long castling
			p.setValues(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(p)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					Position origin = new Position(position.getRow(), position.getColumn());
					Boolean noChecks = true;
					getBoard().removePiece(position);
					getBoard().placePiece(this, p1);
					noChecks = (!chessMatch.testCheck(getColor())) ? true : false;
					if(noChecks) {
						getBoard().removePiece(p1);
						getBoard().placePiece(this, p2);
						noChecks = (!chessMatch.testCheck(getColor())) ? true : false;
					} else {
						getBoard().removePiece(p1);
						getBoard().placePiece(this, origin);
					}
					if(noChecks) {
						getBoard().removePiece(p2);
						getBoard().placePiece(this, p3);
						noChecks = (!chessMatch.testCheck(getColor())) ? true : false;
						getBoard().removePiece(p3);
						getBoard().placePiece(this, origin);
					} else {
						getBoard().removePiece(p2);
						getBoard().placePiece(this, origin);
					}
					
					if(noChecks) {
						moves[position.getRow()][position.getColumn() - 2] = true;
					}
				}
				
			}
		}
		
		return moves;
	}
	
}
