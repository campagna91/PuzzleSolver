package common;

import java.util.Arrays;
import java.io.Serializable;

public class PuzzleTile implements Serializable{
	String id, letter, top, right, bottom, left;

	public PuzzleTile(String id, String c, String t, String r, String b, String l) {
		this.id = id;
		letter = c;
		top = t;
		right = r;
		bottom = b;
		left = l;
	}
	public String id() {
		return id;
	}
	public String top() {
		return top;
	}
	public String right() {
		return right;
	}
	public String bottom() {
		return bottom;
	}
	public String left() {
		return left;
	}
	public String character() {
		return letter;
	}
}