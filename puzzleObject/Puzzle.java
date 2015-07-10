package puzzleObject;

import java.util.ArrayList;
import puzzleIO.*;
import puzzleObject.PuzzleTile;


public abstract class Puzzle{

	protected ArrayList<PuzzleTile> tiles;
	private int rows, cols;
	private PuzzleReader reader = new PuzzleReader();

	public Puzzle(String file) {
		reader.loadPuzzle(this,file);
	}
	public int numRows(){
		return rows;
	}
	public int numCols(){
		return cols;
	}
	public void setNumCols(int cols) {
		this.cols = cols;
	}
	public void setNumRows(int rows) {
		this.rows = rows;
	}
	public void push(PuzzleTile tile) {
		tiles.add(tile);
	}
	public PuzzleTile tile(int row, int col) {
		return tiles.get(row*this.cols*cols);
	}
	public ArrayList<PuzzleTile> tiles() {
		return tiles;
	}
	public void print() {

	}
	abstract protected String stringfy();

}