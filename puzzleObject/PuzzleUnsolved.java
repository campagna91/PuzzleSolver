package puzzleObject;

import puzzleObject.Puzzle;

public class PuzzleUnsolved extends Puzzle {

	public PuzzleUnsolved(String file) {
		super(file);
	}
	
	protected String stringfy() {
		StringBuilder aux = new StringBuilder();
		for(int i = 0; i < tiles.size(); ++i)
			aux.append(tiles.get(i));
		return aux.toString();
	}

}