package server; 

import java.rmi.*;
import java.rmi.server.*;
import common.Puzzle;
import common.PuzzleSolved;
import server.puzzleObject.Solver;
import java.net.MalformedURLException;

class PuzzleSolver {
	private static final String HOST = "localhost";

	public static void main(String args[]) {
		try {
			String serverName = args[0];

			Solver solver = new Solver();
			String rmiObServer = "rmi://" + HOST + "/" + serverName;
			Naming.rebind(rmiObServer, solver);
			System.out.println("Server ready");
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Error! E' necessario specificare il nome del server");
		}
		catch(RemoteException r) {
			System.out.println("Error while rebind object");
			r.printStackTrace();
			System.exit(1);
		}
		catch(MalformedURLException m) {
			System.out.println("Error! Malformed url require");
		}
	}
}