package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch(){
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }
    public Color getCurrentPlayer() {
        return currentPlayer;
    }


    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i< board.getRows(); i++){
            for (int j=0; j< board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition soursePosition, ChessPosition targetPosition){
        Position source = soursePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if (capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }
    private void validateSourcePosition(Position position){
        if (!board.thereIsApiece(position)) {
            throw new ChessExeption("Nao existe peça nesta posição de origem");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessExeption ("A peça escolhida nao é SUA !");
        }
        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessExeption("Nao existe movimentos possivies para a peça escolhida ");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if (!board.piece(source).possibleMove(target)){
            throw new ChessExeption("A peça escolhida nao pode ser movida para posição de destino");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BlACK : Color.WHITE;
    }
    //esse metodo recebe as cordenadas do xadrez
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup(){
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BlACK));
        placeNewPiece('c', 8, new Rook(board, Color.BlACK));
        placeNewPiece('d', 7, new Rook(board, Color.BlACK));
        placeNewPiece('e', 7, new Rook(board, Color.BlACK));
        placeNewPiece('e', 8, new Rook(board, Color.BlACK));
        placeNewPiece('d', 8, new King(board, Color.BlACK));
    }
}
