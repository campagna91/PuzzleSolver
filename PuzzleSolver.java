package Prima;

import puzzleObject.Puzzle;
import puzzleObject.PuzzleSolved;
import puzzleObject.PuzzleUnsolved;

class PuzzleSolver {
	public static void main(String args[]) {
		Puzzle unsolved = new PuzzleUnsolved(args[0]);
		Puzzle solved = new PuzzleSolved(args[1], (PuzzleUnsolved) unsolved);
		unsolved.print();
		solved.print();
	}
}