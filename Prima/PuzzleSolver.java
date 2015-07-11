import puzzleIO.*;
import puzzleObject.Puzzle;
import puzzleObject.PuzzleSolved;
import puzzleObject.PuzzleUnsolved;

class PuzzleSolver {
	public static void main(String args[]) {
		PuzzleWriter writer = null;
		try {
			writer = new PuzzleWriter();
			String inputFile = args[0], outputFile = args[1];
			Puzzle unsolved = new PuzzleUnsolved();
			unsolved.loadFromFile(inputFile);
			writer.write(unsolved, outputFile, false);

			Puzzle solved = new PuzzleSolved(unsolved);
			writer.write(solved, outputFile, true);
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			if(args.length == 0)
				System.out.println("E' necessario specificare il file di input e di output");
			if(args.length == 1)
				System.out.println("File di output assente");
		}
	}
}