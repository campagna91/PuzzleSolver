package common;

import java.rmi.*;
import common.Puzzle;

public interface Solvable extends Remote {
		public void solve(Puzzle puzzleToSolve) throws RemoteException;

}