package chess;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private ChessGame.TeamColor teamColor;
    private ChessPiece.PieceType type;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.teamColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return teamColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ArrayList <ChessMove> validMoves = new ArrayList<ChessMove>();

        int y = myPosition.getRow();
        int x = myPosition.getColumn();

        switch(type) {
            case KING:
                //diagonal up right
                if(myPosition.getColumn()<8 && myPosition.getRow()<8) {
//                        validMoves.add(myPosition.getColumn()+1,myPosition.getRow()+1);
                }
                //diagonal up left
                if(myPosition.getColumn()>1 && myPosition.getRow()<8) {
//                    validMoves.add(myPosition.getColumn()-1,myPosition.getRow()+1);
                }
                //diagonal down right
                if(myPosition.getColumn()<8 && myPosition.getRow()>1) {
//                    validMoves.add(myPosition.getColumn()+1,myPosition.getRow()-1);
                }
                //diagonal down left
                if(myPosition.getColumn()>1 && myPosition.getRow()>1) {
//                    validMoves.add(myPosition.getColumn()-1,myPosition.getRow()-1);
                }
                //up
                if(myPosition.getColumn()<8) {
//                    validMoves.add(myPosition.getColumn()+1,myPosition.getRow());
                }
                //down
                if(myPosition.getColumn()>1) {
//                    validMoves.add(myPosition.getColumn()-1,myPosition.getRow());
                    }
                //right
                if(myPosition.getRow()<8) {
//                    validMoves.add(myPosition.getColumn(),myPosition.getRow()+1);
                    }
                //left
                if(myPosition.getRow()>1) {
//                    validMoves.add(myPosition.getColumn(),myPosition.getRow()-1);
                    }
                //check stuff???
                break;


            case QUEEN:
                //diagonal up right
                if(myPosition.getColumn()<8 && myPosition.getRow()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x++;
                        y++;
//                        validMoves.add(x,y);
                    }while(x<8 && y<8);
                }
                //diagonal up left
                if(myPosition.getColumn()>1 && myPosition.getRow()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x--;
                        y++;
//                        validMoves.add(x,y);
                    }while(x>1 && y<8);
                }
                //diagonal down right
                if(myPosition.getColumn()<8 && myPosition.getRow()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x++;
                        y--;
//                        validMoves.add(x,y);
                    }while(x<8 && y>1);
                }
                //diagonal down left
                if(myPosition.getColumn()>1 && myPosition.getRow()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x--;
                        y--;
//                        validMoves.add(x,y);
                    }while(x>1 && y>1);
                }
                //up
                if(myPosition.getColumn()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x++;
//                        validMoves.add(x,y);
                    }while(x<8);
                }
                //down
                if(myPosition.getColumn()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x--;
//                        validMoves.add(x,y);
                    }while(x>1);
                }
                //right
                if(myPosition.getRow()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        y++;
//                        validMoves.add(x,y);
                    }while(y<8);
                }
                //left
                if(myPosition.getRow()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        y--;
//                        validMoves.add(x,y);
                    }while(y>1);
                }

                break;


            case BISHOP:
                //diagonal up right
                if(myPosition.getColumn()<8 && myPosition.getRow()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x++;
                        y++;
//                        validMoves.add(x,y);
                    }while(x<8 && y<8);
                }
                //diagonal up left
                if(myPosition.getColumn()>1 && myPosition.getRow()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x--;
                        y++;
//                        validMoves.add(x,y);
                    }while(x>1 && y<8);
                }
                //diagonal down right
                if(myPosition.getColumn()<8 && myPosition.getRow()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x++;
                        y--;
//                        validMoves.add(x,y);
                    }while(x<8 && y>1);
                }
                //diagonal down left
                if(myPosition.getColumn()>1 && myPosition.getRow()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x--;
                        y--;
//                        validMoves.add(x,y);
                    }while(x>1 && y>1);
                }

                break;


            case KNIGHT:

                do{

                }while();

                break;


            case ROOK:
                //up
                if(myPosition.getColumn()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x++;
//                        validMoves.add(x,y);
                    }while(x<8);
                }
                //down
                if(myPosition.getColumn()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        x--;
//                        validMoves.add(x,y);
                    }while(x>1);
                }
                //right
                if(myPosition.getRow()<8) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        y++;
//                        validMoves.add(x,y);
                    }while(y<8);
                }
                //left
                if(myPosition.getRow()>1) {
                    y = myPosition.getRow();
                    x = myPosition.getColumn();
                    do {
                        y--;
//                        validMoves.add(x,y);
                    }while(y>1);
                }

                break;


            case PAWN:
                //white pawns
                if(myPosition.getRow() > 1 && getTeamColor() == ChessGame.TeamColor.WHITE){
                    if(x<=7){
//                        validMoves.add(myPosition.getRow() +1, myPosition.getColumn());
                    }else if(myPosition.getRow() == 7 && getTeamColor() == ChessGame.TeamColor.WHITE){
                        //promote piece and add move validMoves.add(myPosition.getRow() + 1, myPosition.getColumn());
                    }
                }

                //black pawns
                if(myPosition.getRow() <8 && getTeamColor() == ChessGame.TeamColor.BLACK){
                    if(x>=2){
//                        validMoves.add(myPosition.getRow() -1, myPosition.getColumn());
                    }else if(myPosition.getRow() == 2 && getTeamColor() == ChessGame.TeamColor.BLACK){
                        //promote piece and add move validMoves.add(myPosition.getRow() - 1, myPosition.getColumn());
                    }
                }
                //capture white
                //capture black

                //en passant white
                //en passant black

                break;

        }
    return validMoves;
    }
}
