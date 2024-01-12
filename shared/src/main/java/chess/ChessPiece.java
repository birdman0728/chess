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
//                if()
                break;
            case QUEEN:
                break;
            case BISHOP:
                //diagonal up left
                if(x < 8 && y < 8) {
                    x++;
                    y++;
                    validMoves.add()
                };
                //diagonal up right

                break;
            case KNIGHT:
                break;
            case ROOK:
                break;
            case PAWN:
                break;

        }
    return validMoves;
    }
}
