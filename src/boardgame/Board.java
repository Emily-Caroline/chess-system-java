package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece [] [] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardExeption("Erro criando Tabuleiro: É necessário que haja ao menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if (!positionExists(row,column)){
            throw new BoardExeption("Posição nao existe no tabuleiro ");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardExeption("Posição nao existe no tabuleiro ");
        }
        return pieces[position.getRow()][position.getColum()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsApiece(position)) {
            throw new BoardExeption("Existe uma peça nessa posição " + position);
        }
       pieces[position.getRow()][position.getColum()] = piece;
       piece.position = position;
    }

    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardExeption("Posição nao existe no tabuleiro");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColum()] = null;
        return aux;
    }


    private boolean positionExists(int row, int column){
        return row >=0  && row < rows && column >=0 && column< columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColum());
    }

    public boolean thereIsApiece(Position position){
        if (!positionExists(position)){
            throw new BoardExeption("Posição nao existe no tabuleiro");
        }
        return piece(position) != null;
    }

}
