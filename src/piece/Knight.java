package piece;

import move.LimitedMovingStrategy;

public class Knight extends Piece{

	private Knight(Color color, Position position) {
        super(color, Type.KNIGHT, position, Direction.knightDirection(), new LimitedMovingStrategy());
    }
    
    public static Knight createWhite(Position position) {
        return new Knight(Color.WHITE, position);
    }
    
    public static Knight createBlack(Position position) {
        return new Knight(Color.BLACK, position);
    }

}
