package client;

import java.rmi.*;
import common.Solvable;
import common.Puzzle;
import common.PuzzleUnsolved;
import common.PuzzleSolved;
import client.puzzleIO.*;
import java.io.Serializable;

class PuzzleSolver {
	private static final String HOST = "localhost";
	
	public static void main(String args[]) {
		PuzzleWriter writer = null;
		PuzzleReader reader = null;

		try {
			String inputFile = args[0], outputFile = args[1], serverName = args[2];
			writer = new PuzzleWriter();
			reader = new PuzzleReader();
			
			System.out.println("primo");
			Puzzle solved = new PuzzleSolved();
			Puzzle unsolved = new PuzzleUnsolved();
			reader.read(unsolved, inputFile);
			writer.write(unsolved, outputFile, false);

			System.out.println("secondo");
			Solvable ref = (Solvable) Naming.lookup("rmi://" + HOST + "/" + serverName);
			solved = ref.solve((PuzzleUnsolved)unsolved);

			System.out.println(solved.rows() + " X " + solved.columns() + " con size " + solved.tiles().size());
			writer.write(solved, outputFile, true);
			System.out.println("fine");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			if(args.length == 0)
				System.out.println("E' necessario specificare il file di input e di output");
			if(args.length == 1)
				System.out.println("File di output assente");
			if(args.length == 2)
				System.out.println("E' necessario specificare un nome per il server");
		}
		catch(ConnectException c) {
			System.out.println("Problema di connessione con il server");
		}
		catch(Exception e) {
			System.out.println("Si è verificato un problema nell'esecuzione");	
			e.printStackTrace();
		}


	}
}