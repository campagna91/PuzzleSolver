package puzzleObject;

import puzzleObject.Puzzle;
import puzzleIO.*;

public class PuzzleUnsolved extends Puzzle {

	public PuzzleUnsolved() {
	}

	public String toString() {
		StringBuilder aux = new StringBuilder();
	  for(int r = 0; r < this.rows(); ++r) {
		  for(int c = 0; c < this.columns(); ++c) {
			  aux.append(this.tile(r, c).character());
			  aux.append(" ");
		  }
	  }
	  aux.append(System.getProperty("line.separator"));
	  return aux.toString();
	}
}