package common;

import java.rmi.*;
import common.PuzzleUnsolved;
import common.PuzzleSolved;

public interface Solvable extends Remote {
		public PuzzleSolved solve(PuzzleUnsolved puzzleToSolve) throws RemoteException;

}