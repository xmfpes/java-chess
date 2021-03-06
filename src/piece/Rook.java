package piece;

import move.UnlimitedMovingStrategy;

public class Rook extends Piece{

	public Rook(Color color, Position position) {
		super(color, Piece.Type.ROOK, position, Direction.linearDirection(), new UnlimitedMovingStrategy());
		// TODO Auto-generated constructor stub
	}
	
	public static Rook createWhite(Position position) {
        return new Rook(Color.WHITE, position);
    }
    
    public static Rook createBlack(Position position) {
        return new Rook(Color.BLACK, position);
    }

}
