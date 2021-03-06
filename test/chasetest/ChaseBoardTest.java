package chasetest;

import static org.junit.Assert.assertEquals;
import static util.StringUtils.appendNewLine;

import org.junit.Before;
import org.junit.Test;

import chess.ChessBoard;
import exception.InvalidPositionException;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Position;
import piece.Queen;
import piece.Rook;

public class ChaseBoardTest {
	ChessBoard board = new ChessBoard();
	final String blankRank = appendNewLine("........");

	@Before
	public void setUp() {
		board = new ChessBoard();
	}

	@Test
	public void boardTest() {

		board.initialize();
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), board.showBoard());
	}

	@Test
	public void getPieceCountTest() {

//		board.initialize();
//		assertEquals(1, board.getPieceCount(Piece.Color.WHITE, Piece.Type.KING));
//		assertEquals(2, board.getPieceCount(Piece.Color.WHITE, Piece.Type.ROOK));
//		assertEquals(8, board.getPieceCount(Piece.Color.BLACK, Piece.Type.PAWN));
//
//		assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
//		assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
//		assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
//		assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
	}

	@Test
	public void move() throws Exception {

		board.initializeEmpty();

		String position1 = "b5";
		String position2 = "b8";
		Piece piece = King.createBlack(new Position(position1));
//		board.move("b5", piece);
		Piece piece2 = Queen.createWhite(new Position(position1));
//		board.move("b8", piece2);

		assertEquals(piece, board.findPiece(position1));
		
		System.out.println("퀸 이동 테스트");
		piece2.setPossibilityPosition(board, piece2);
		System.out.println("move move");
		for(int i=0; i<piece2.getPossibilityPosition().size(); i++) {
			System.out.println(piece2.getPossibilityPosition().get(i).getX() + ", " + piece2.getPossibilityPosition().get(i).getY());
		}
		System.out.println();
		System.out.println("king : " + piece.getPosition().getX() + "," + piece.getPosition().getY());
		System.out.println("queen : "  + piece2.getPosition().getX() +", " + piece2.getPosition().getY());
		System.out.println("이동 노");
		System.out.println(board.showBoard());
		board.move(position2, position1);
		assertEquals(piece2, board.findPiece(new Position("b5")));
		
		assertEquals(4, piece.getPosition().getY());
		assertEquals(1, piece.getPosition().getX());
		
		System.out.println("------------------------");
		assertEquals("b5", new Position("b5").getPosition());
		assertEquals("d5", new Position(3,4).getPosition());
	}

	@Test
	public void caculcatePoint() throws Exception {

		board.initializeEmpty();

		addPiece("b6", Pawn.createBlack(new Position("b6")));
		addPiece("e6", Queen.createBlack(new Position("e6")));
		addPiece("b8", King.createBlack(new Position("b8")));
		addPiece("c8", Rook.createBlack(new Position("c8")));

		addPiece("f2", Pawn.createWhite(new Position("f2")));
		addPiece("g2", Pawn.createWhite(new Position("g2")));
		addPiece("e1", Rook.createWhite(new Position("e1")));
		addPiece("f1", King.createWhite(new Position("f1")));

		assertEquals(15.0, board.caculcatePoint(Piece.Color.BLACK), 0.01);
		assertEquals(7.0, board.caculcatePoint(Piece.Color.WHITE), 0.01);

		System.out.println(board.showBoard());
	}
	@Test
	public void moveBishopTest() {
		board.initializeEmpty();
		addPiece("c6", Bishop.createBlack(new Position("c6")));
		addPiece("b7", Queen.createBlack(new Position("b7")));
		addPiece("e4", King.createWhite(new Position("e4")));
		addPiece("e2", Rook.createWhite(new Position("e2")));
		addPiece("b4", Knight.createWhite(new Position("b4")));
		
		Piece bishop = (Bishop)board.findPiece(new Position("c6"));
		Piece rook = board.findPiece(new Position("e2"));
		Piece knight = board.findPiece(new Position("b4"));
		Piece king = board.findPiece(new Position("e4"));
		bishop.setPossibilityPosition(board, bishop);
		System.out.println(bishop.getPosition().getX() + " : " + bishop.getPosition().getY());
		System.out.println();
		rook.setPossibilityPosition(board, rook);
		System.out.println();
		knight.setPossibilityPosition(board, knight);
		System.out.println();
		king.setPossibilityPosition(board, king);
		System.out.println("bishop move test");
		System.out.println(board.showBoard());
		
	}
	
	@Test
	public void trycatch() throws Exception{
		try {
			new Position(null);
		} catch(InvalidPositionException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(expected = InvalidPositionException.class)
	public void create_isNull() throws Exception{
		new Position(null);
	}
//	@Test
//	public void calculatePawnExceptionPoint() {
//		board.initializeEmpty();
//
//		addPiece("b8", Piece.createBlackKing());
//		addPiece("c8", Piece.createBlackRook());
//		addPiece("a7", Piece.createBlackPawn());
//		addPiece("c7", Piece.createBlackPawn());
//		addPiece("d7", Piece.createBlackBishop());
//		addPiece("b6", Piece.createBlackPawn());
//		addPiece("e6", Piece.createBlackQueen());
//		
//		addPiece("f4", Piece.createWhiteKnight());
//		addPiece("g4", Piece.createWhiteQueen());
//		
//		addPiece("f3", Piece.createWhitePawn());
//		addPiece("h3", Piece.createWhitePawn());
//		addPiece("f2", Piece.createWhitePawn());
//		addPiece("g2", Piece.createWhitePawn());
//		
//		addPiece("e1", Piece.createWhiteRook());
//		addPiece("f1", Piece.createWhiteKing());
//
//		assertEquals(20.0, board.caculcatePoint(Piece.Color.BLACK), 0.01);
//		assertEquals(19.5, board.caculcatePoint(Piece.Color.WHITE), 0.01);
//	}
//	
	private void addPiece(String position, Piece piece) {
//		board.move(position, piece);
	}
//	
//	 @Test
//	    public void moveTest() throws Exception {
//	        board.initialize();
//
//	        String sourcePosition = "b2";
//	        String targetPosition = "b3";
//	        board.move(sourcePosition, targetPosition);
//	        assertEquals(Piece.createBlank(new Position(sourcePosition)), board.findPiece(sourcePosition));
//	        assertEquals(Piece.createWhitePawn(), board.findPiece(targetPosition));
//	        
//	    }
}
