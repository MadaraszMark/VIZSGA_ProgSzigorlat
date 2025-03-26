package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		TaskSolution taskSolutionObj = new TaskSolution();
        taskSolutionObj.fillGameList();
        taskSolutionObj.printAllGameData();
        
        System.out.println("\n4.Feladat");
        taskSolutionObj.PS45Games();
        
        System.out.println("\n5.Feladat");
        taskSolutionObj.GroupRatings();
        
        System.out.println("\n6.Feladat");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Adja meg a keresett játék nevét: ");
        String game;
		try {
			game = br.readLine();
			Boolean b = taskSolutionObj.Search(game);
			if (b) {
				System.out.print("A keresett játék létezik az adatbázisban!");
			}
			else {
                System.out.print("A keresett játék nem létezik az adatbázisban!");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
        System.out.println("\n7.Feladat");
        taskSolutionObj.bestGame();
        
        System.out.println("\n8.Feladat");
        taskSolutionObj.Multiplayer();
	}
	

}
