package puzzleObject;

public class PuzzleTile {
	String id, letter, top, right, down, left;

	public PuzzleTile(String property[]) {
		id = property[0];
		letter = property[1];
		top = property[2];
		right = property[3];
		down = property[4];
		left = property[5];
	}

	public String getTop() {
		return top;
	}
	public String geRight() {
		return right;
	}
	public String getDown() {
		return down;
	}
	public String getLeft() {
		return left;
	}
	public String getLetter() {
		return letter;
	}

}