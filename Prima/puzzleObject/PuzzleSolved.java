package puzzleObject;

import java.util.ArrayList;
import puzzleObject.Puzzle;

public class PuzzleSolved extends Puzzle implements Solvable{
	private ArrayList<PuzzleTile> tilesOrdered = new ArrayList<PuzzleTile>();

	public PuzzleSolved() {
	}
	public PuzzleTile tile(int row, int column) {
		return tilesOrdered.get(row * columns() + column);
	}
	public void solve(Puzzle puzzle) {
		setColumns(puzzle.columns());
		setRows(puzzle.rows());	
		tiles.addAll(puzzle.tiles());
		tilesOrdered.addAll(puzzle.tiles());

		solveFirstColumn();
		solveRemaining();
	}
	private void solveFirstColumn() {
		String top = "VUOTO";
		for(int r = 0; r < rows(); ++r) {
			boolean notFound = true;
			for(int tile = 0; tile < tiles.size() && notFound; ++tile) {
				if(tiles.get(tile).left().equals("VUOTO")) {
					if(tiles.get(tile).top().equals(top)) {
						tilesOrdered.set(r * columns(), tiles.get(tile));
						top = tiles.get(tile).id();
						notFound = false;
					}
				}
			}
		}
	}
	private void solveRemaining() {
		for(int r = 0; r < rows(); ++r) {
			for(int c = 0; c < columns(); ++c) {
				boolean notFound = true;
				for(int tile = 0; tile < tiles.size() && notFound; ++tile) {
					if(tiles.get(tile).left().equals(tiles.get(r * columns() + c))) {						
						tilesOrdered.add(r * columns() + c, tiles.get(tile));
						notFound = false;
					}
				}
			}
		}
	}
	public String toString() {
		StringBuilder aux = new StringBuilder();
		for(int r = 0; r < rows(); r++) {
		  aux.append(System.getProperty("line.separator"));
		  for(int c = 0; c < columns(); c++) {
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