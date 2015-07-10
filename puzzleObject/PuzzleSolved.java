package puzzleObject;

import java.util.ArrayList;
import puzzleObject.Puzzle;
import puzzleObject.PuzzleUnsolved;

public class PuzzleSolved extends Puzzle {
	private ArrayList<PuzzleTile> tilesOrdered;

	public PuzzleSolved(String file, PuzzleUnsolved puzzle) {
		super(file);
		solveTopLeftAngle(puzzle);
		// solveRemaining(puzzle);
	}

	public void solveTopLeftAngle(Puzzle puzzle) {
		boolean found = false;
		for(int r = 0; r < puzzle.numRows() && !found; ++r) {
			for(int c = 0; c < puzzle.numCols(); ++c) {
				if(puzzle.tile(r,c).getTop().equals("VUOTO") && puzzle.tile(r,c).getLeft().equals("VUOTO")) {
					tilesOrdered.add(0,puzzle.tile(r,c));
					found = true;
				}
			}
		}
	}
	public void solveRemaining(Puzzle puzzle) {

	}
	protected String stringfy() {
		StringBuilder aux = new StringBuilder();
	  for(int i = 0; i < super.numRows(); ++i) {
		  aux.append(System.getProperty("line.separator"));
		  for(int j=0; j < super.numCols(); ++j) {
			  aux.append(tiles.get(i * super.numCols() + j).getLetter());
		  }
	  }
	  return aux.toString();
	}

}