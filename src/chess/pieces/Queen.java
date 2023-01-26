package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //acima da peça
        p.setValues(position.getRow() - 1, position.getColum() );
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //esquerda
        p.setValues(position.getRow() , position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //direita
        p.setValues(position.getRow() , position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //para baixo
        p.setValues(position.getRow() + 1, position.getColum() );
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //noroeste
        p.setValues(position.getRow() - 1, position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() -1 );
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //nordeste
        p.setValues(position.getRow() - 1, position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() + 1 );
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //sudeste
        p.setValues(position.getRow() + 1  , position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() + 1 );
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //sudoeste
        p.setValues(position.getRow() + 1, position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() - 1 );
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        return mat;
    }
}
