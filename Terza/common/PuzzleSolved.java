package common;

import java.util.ArrayList;
import java.io.Serializable;
import common.Puzzle;
import common.Solvable;
import common.PuzzleTile;

public class PuzzleSolved extends Puzzle {
	private ArrayList<PuzzleTile> tilesOrdered = new ArrayList<PuzzleTile>();

	public PuzzleSolved() {
	}
	public PuzzleTile tile(int row, int column) {
		System.out.println("require row " + row + " on " + column + "° element ");
		return tilesOrdered.get(row * columns() + column);
	}
	public ArrayList<PuzzleTile> tiles() {
		return tilesOrdered;
	}
	public String toString() {
		StringBuilder aux = new StringBuilder();
		for(int r = 0; r < rows(); r++) {
			System.out.println("require row " + r + " on " + rows() + " rows");
		  aux.append(System.getProperty("line.separator"));
		  for(int c = 0; c < columns(); c++) {
		  	System.out.println("require column  " + c + " on " + columns() + " columns");
			  aux.append(tile(r, c).character());
			  aux.append(" ");
		  }
	  }
	  aux.append(System.getProperty("line.separator") + System.getProperty("line.separator"));
	  aux.append(rows());
	  aux.append(" ");
	  aux.append(columns());
	  return aux.toString();
	}
}