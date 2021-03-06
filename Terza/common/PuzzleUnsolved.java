package common;

import java.io.Serializable;
import common.Puzzle;
import common.Solvable;

public class PuzzleUnsolved extends Puzzle implements Serializable {

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
	public void solve(Puzzle puzzleToSolve) {
	}
}