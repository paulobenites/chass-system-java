package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
	 
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
		try {	
		UI.clearScreem();	
		UI.printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Source: ");
		ChessPosition source = UI.readChassPosition(sc);
		
		boolean [][] possibleMoves = chessMatch.possibleMoves(source);
		UI.clearScreem();
		UI.printBoard(chessMatch.getPieces(),possibleMoves);
		
		System.out.println();
		System.out.println("Target: ");
		ChessPosition target = UI.readChassPosition(sc);
		
	    ChessPiece capturedPice = chessMatch.performChessMove(source, target);
		}
		catch(ChessException e){
			System.out.println(e.getMessage());
			sc.nextLine();
	    }
		catch(InputMismatchException e){
			System.out.println(e.getMessage());
			sc.nextLine();
	    }
	 }
  }
}
