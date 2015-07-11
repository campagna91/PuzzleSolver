package puzzleObject;

import puzzleIO.*;
import puzzleObject.Solvable;
import puzzleObject.PuzzleTile;
import java.util.ArrayList;


public abstract class Puzzle{

	private int rows, columns;
	private PuzzleReader reader;
	protected ArrayList<PuzzleTile> tiles;

	public Puzzle() {
	}
	public int rows(){
		return rows;
	}
	public int columns(){
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void addTile(PuzzleTile t) {
		tiles.add(t);
	}
	public PuzzleTile tile(int row, int column) {
		return tiles.get(row * columns + column);
	}
	public ArrayList<PuzzleTile> tiles() {
		return tiles;
	}
	public void loadFromFile(String inputFile) {
		tiles = new ArrayList<PuzzleTile>();
		reader = new PuzzleReader();
		reader.read(this, inputFile);
	}
	public abstract String toString();	
}