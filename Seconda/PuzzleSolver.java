import puzzleIO.*;
import puzzleObject.Puzzle;
import puzzleObject.PuzzleSolved;
import puzzleObject.PuzzleUnsolved;

class PuzzleSolver {
	public static void main(String args[]) {
		PuzzleWriter writer = null;
		PuzzleReader reader = null;
		try {
			String inputFile = args[0], outputFile = args[1];
			writer = new PuzzleWriter();
			reader = new PuzzleReader();

			Puzzle unsolved = new PuzzleUnsolved();
			reader.read(unsolved, inputFile);
			writer.write(unsolved, outputFile, false);

			Puzzle solved = new PuzzleSolved();
			solved.solve(unsolved);
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