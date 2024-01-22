package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private ChessGame.TeamColor teamColor;
    private ChessPiece.PieceType type;
    ChessBoard board = new ChessBoard();
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
        Collection <ChessMove> validMoves = new HashSet<>();
//        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn()), null));

        int y = myPosition.getRow();
        int x = myPosition.getColumn();
//////////////////add subclass of each move type

        switch(type) {
            case KING:
                //diagonal up right
                if(myPosition.getColumn()<8 && myPosition.getRow()<8) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow()+1,myPosition.getColumn()+1)).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow()+1,myPosition.getColumn()+1)).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), null));///////////////////////
                    }

                }
                //diagonal up left
                if(myPosition.getColumn()>1 && myPosition.getRow()<8) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow()-1,myPosition.getColumn()+1)).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow()-1,myPosition.getColumn()+1)).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), null));///////////////////////
                    }
//                    validMoves.add(new ChessMove(myPosition.getColumn()-1,myPosition.getRow()+1);
                }
                //diagonal down right
                if(myPosition.getColumn()<8 && myPosition.getRow()>1) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow()+1,myPosition.getColumn()-1)).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow()+1,myPosition.getColumn()-1)).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), null));///////////////////////
                    }
//                    validMoves.add(myPosition.getColumn()+1,myPosition.getRow()-1);
                }
                //diagonal down left
                if(myPosition.getColumn()>1 && myPosition.getRow()>1) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow()-1,myPosition.getColumn()-1)).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow()-1,myPosition.getColumn()-1)).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), null));///////////////////////
                    }
//                    validMoves.add(myPosition.getColumn()-1,myPosition.getRow()-1);
                }
                //up
                if(myPosition.getColumn()<8) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow()+1,myPosition.getColumn())).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow()+1,myPosition.getColumn())).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()  ), null));///////////////////////
                    }
//                    validMoves.add(myPosition.getColumn()+1,myPosition.getRow());
                }
                //down
                if(myPosition.getColumn()>1) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow()-1,myPosition.getColumn() )).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow()-1,myPosition.getColumn() )).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()  ));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()  ), null));///////////////////////
                    }
//                    validMoves.add(myPosition.getColumn()-1,myPosition.getRow());
                    }
                //right
                if(myPosition.getRow()<8) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow() ,myPosition.getColumn()+1)).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow() ,myPosition.getColumn()+1)).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow()  , myPosition.getColumn() + 1));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow()  , myPosition.getColumn() + 1), null));///////////////////////
                    }
//                    validMoves.add(myPosition.getColumn(),myPosition.getRow()+1);
                    }
                //left
                if(myPosition.getRow()>1) {
                    if (board.getPiece(new ChessPosition(myPosition.getRow() ,myPosition.getColumn()-1)).getTeamColor() == null) {
                        if(board.getPiece(new ChessPosition(myPosition.getRow() ,myPosition.getColumn()-1)).getTeamColor() != teamColor) {
                            board.removePiece(new ChessPosition(myPosition.getRow()  , myPosition.getColumn() - 1));
                        }
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow()  , myPosition.getColumn() - 1), null));///////////////////////
                    }
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

                y = myPosition.getRow() + 2;
                x = myPosition.getColumn() + 1;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() + 2;
                x = myPosition.getColumn() - 1;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() - 2;
                x = myPosition.getColumn() + 1;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() - 2;
                x = myPosition.getColumn() - 1;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() + 1;
                x = myPosition.getColumn() + 2;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() - 1;
                x = myPosition.getColumn() + 2;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() + 1;
                x = myPosition.getColumn() - 2;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }

                y = myPosition.getRow() - 1;
                x = myPosition.getColumn() - 2;
                if(x <= 8 && x >= 1 && y <= 8 && y >= 1){
//                    validMoves.add(x,y);
                }


                break;


            case ROOK:
                //up
                for(int i = 0; i < 7; i++){

                    if(board.getPiece(new ChessPosition(myPosition.getRow() +  i, myPosition.getColumn())) == null && myPosition.getRow() < 8){
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() +  i, myPosition.getColumn()), null));
                    }else if(board.getPiece(new ChessPosition(myPosition.getRow() +  i, myPosition.getColumn())).getTeamColor() == teamColor){
                        break;
                    }else {
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + i + 1, myPosition.getColumn()), null));
                        break;
                    }
                }
                //down
                for(int i = 0; i < 7; i++){

                    if(board.getPiece(new ChessPosition(myPosition.getRow() -  i, myPosition.getColumn())) == null && myPosition.getRow() < 8){
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - i, myPosition.getColumn()), null));
                    }else if(board.getPiece(new ChessPosition(myPosition.getRow() - i, myPosition.getColumn())).getTeamColor() == teamColor){
                        break;
                    }else {
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - i - 1, myPosition.getColumn()), null));
                        break;
                    }
                }
                //right
                for(int i = 0; i < 7; i++){

                    if(board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() +  i)) == null && myPosition.getRow() < 8){
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() +  i), null));
                    }else if(board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() +  i)).getTeamColor() == teamColor){
                        break;
                    }else {
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() + i + 1), null));
                        break;
                    }
                }
                //left
                for(int i = 0; i < 7; i++){

                    if(board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() -  i)) == null && myPosition.getRow() < 8){
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() - i), null));
                    }else if(board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() - i)).getTeamColor() == teamColor){
                        break;
                    }else {
                        pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() - i - 1), null));
                        break;
                    }
                }




//                for(int i = 1; i <= 7; i++){
//                    if((myPosition.getRow() + i) < 8){
//                        if (board.getPiece(new ChessPosition(myPosition.getRow()+i, myPosition.getColumn())).getTeamColor() == teamColor){
//                            break;
//                        }else if(board.getPiece(new ChessPosition(myPosition.getRow()+i, myPosition.getColumn())).getTeamColor() != teamColor && board.getPiece(new ChessPosition(myPosition.getRow()+i, myPosition.getColumn())).getTeamColor() != null){
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow()+i, myPosition.getColumn()), null));
//                            break;
//                        }else{
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow()+i, myPosition.getColumn()), null));
//                        }
//
//                    }
//
//                }////////////////////Maybe search for a piece first then run possible code up until there
//                /////////////////////Error because getTeamColor returns null, maybe just check if there is a piece, doesn't have to be just the color???
//
//                //down
//                for(int i = 1; i <= 7; i++){
//                    if((myPosition.getRow() + i) > 1){
//                        if (board.getPiece(new ChessPosition(myPosition.getRow()-i, myPosition.getColumn())).getTeamColor() == teamColor){
//                            break;
//                        }else if(board.getPiece(new ChessPosition(myPosition.getRow()-i, myPosition.getColumn())).getTeamColor() != teamColor && board.getPiece(new ChessPosition(myPosition.getRow()-i, myPosition.getColumn())).getTeamColor() != null){
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow()-i, myPosition.getColumn()), null));
//                            break;
//                        }else{
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow()-i, myPosition.getColumn()), null));
//                        }
//
//                    }
//
//                }
//
//                //right
//                for(int i = 1; i <= 7; i++){
//                    if((myPosition.getColumn() + i) < 8){
//                        if (board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn()+i)).getTeamColor() == teamColor){
//                            break;
//                        }else if(board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn()+i)).getTeamColor() != teamColor && board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn()+i)).getTeamColor() != null){
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn()+i), null));
//                            break;
//                        }else{
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn()+i), null));
//                        }
//
//                    }
//
//                }
//                //left
//                for(int i = 1; i <= 7; i++){
//                    if((myPosition.getColumn()   - i) < 8){
//                        if (board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn()  -i)).getTeamColor() == teamColor){
//                            break;
//                        }else if(board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn()  -i)).getTeamColor() != teamColor && board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn()  -i)).getTeamColor() != null){
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn()  -i), null));
//                            break;
//                        }else{
//                            pieceMoves(board, myPosition).add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn()  -i), null));
//                        }
//
//                    }
//
//                }

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
    return validMoves;//Not sure on this one
    }

//    private ChessMove kingMoves



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return teamColor == that.teamColor && type == that.type && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamColor, type, board);
    }
}
