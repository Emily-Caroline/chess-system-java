package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }


    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //para cima
        p.setValues(position.getRow() - 1, position.getColum());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //para baixo
        p.setValues(position.getRow() + 1, position.getColum());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //para esquerda
        p.setValues(position.getRow(), position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //para direita
        p.setValues(position.getRow(), position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //noroeste
        p.setValues(position.getRow() - 1, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //nordeste
        p.setValues(position.getRow() - 1, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //sudoeste
        p.setValues(position.getRow() + 1, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //sudeste
        p.setValues(position.getRow() + 1, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
