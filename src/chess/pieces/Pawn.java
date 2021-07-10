package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
//ATTRIBUTES
	private ChessMatch chessMatch;
	
//CONSTRUCTOR
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

//METHODS
	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			//above
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				
				//double above
				p.setValues(position.getRow() - 2, position.getColumn());
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() <= 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
			
			//diagonal left capture
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				
			}
			
			//diagonal right capture
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			Position pAux = new Position(0, 0);
			//en passant right
			p.setValues(position.getRow(), position.getColumn() + 1);
			pAux.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && getBoard().positionExists(pAux)) {
				if(getBoard().piece(p) == chessMatch.getEnPassantVulnerable() && !getBoard().thereIsAPiece(pAux)) {
					mat[pAux.getRow()][pAux.getColumn()] = true;
				}
			}
			
			//en passant left
			p.setValues(position.getRow(), position.getColumn() - 1);
			pAux.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && getBoard().positionExists(pAux)) {
				if(getBoard().piece(p) == chessMatch.getEnPassantVulnerable() && !getBoard().thereIsAPiece(pAux)) {
					mat[pAux.getRow()][pAux.getColumn()] = true;
				}
			}
			
		} else {
			//above
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				
				//double above
				p.setValues(position.getRow() + 2, position.getColumn());
				if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() <= 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
			
			//diagonal left capture
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//diagonal right capture
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			Position pAux = new Position(0, 0);
			//en passant right
			p.setValues(position.getRow(), position.getColumn() + 1);
			pAux.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && getBoard().positionExists(pAux)) {
				if(getBoard().piece(p) == chessMatch.getEnPassantVulnerable() && !getBoard().thereIsAPiece(pAux)) {
					mat[pAux.getRow()][pAux.getColumn()] = true;
				}
			}
			
			//en passant left
			p.setValues(position.getRow(), position.getColumn() - 1);
			pAux.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && getBoard().positionExists(pAux)) {
				if(getBoard().piece(p) == chessMatch.getEnPassantVulnerable() && !getBoard().thereIsAPiece(pAux)) {
					mat[pAux.getRow()][pAux.getColumn()] = true;
				}
			}
		}
		return mat;
	}
	
}
