package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskSolution {
	
	List<Game> games = new ArrayList<Game>();
	
    public void fillGameList() {
        ReadDataFromFile readDataFromFileObj = new ReadDataFromFile();
        games = readDataFromFileObj.readDataFromCsv();
    }
    
    public void printAllGameData() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %s%n", "Név", "Azonosító", "Elvitel órája", "Elvitel perce", "Visszahozatal órája", "Visszahozatal perce");
        int limit = Math.min(10, games.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(games.get(i).toStringDivider());
        }
    }
    
    public void PS45Games() {
    	List<Game> totalGames = new ArrayList<Game>();
    	for (Game game : games) {
			if (game.getPlatform().equals("PS4/PS5")&& game.getOpenCritic() >= 90) {
				System.out.println(game.toStringDivider());
				totalGames.add(game);
			}
		}
    	System.out.println("\nPS4-re és PS5-re összesen " + totalGames.size() + "db játék érhető el, ami legalább 90%-os értékelést kapott: ");
    	for (Game game : totalGames) {
			System.out.println(game.getName());
		}
    }
    
    public void GroupRatings() {
    	int[] ratings = new int[4];
    	String[] group = new String[4];
    	for (Game game : games) {
    		if (game.getOpenCritic() > 90) {
    			ratings[0]++;
    			group[0] = "Kiváló (91-100)";
    		}
    		else if (game.getOpenCritic() > 80) {
    			ratings[1]++;
    			group[1] = "Jó (81-90)";
    		}
    		else if (game.getOpenCritic() > 70) {
    			ratings[2]++;
                group[2] = "Játszható (71-80)";
    		}
    		else if (game.getOpenCritic() >= 0){
                ratings[3]++;
                group[3] = "Rossz (0-70)";
            }
    	}
    	System.out.println("Játékértékelések: ");
    	for (int i = 0; i < group.length; i++) {
            System.out.printf("%s: %d db%n", group[i], ratings[i]);
        }
    }
    
    public Boolean Search(String game) {
    	int i = 0;
    	while (i < games.size() &&!games.get(i).getName().equals(game)) {
            i++;
        }
    	return i < games.size();
    }
    
    public void bestGame() {
        Game bestGame = games.get(0);
        for (Game game : games) {
            if (game.getOpenCritic() > bestGame.getOpenCritic()) {
                bestGame = game;
            }
        }
        System.out.println("Legjobb játék: " + bestGame.getName() + " (" + bestGame.getOpenCritic() + ")");
    }
    
    public void Multiplayer() {
    	int[] playerCount = new int[3];
    	String[] ratingName = new String[3];
    	for (Game game : games) {
			if (game.getMultiplayer().equals("Online")) {
				playerCount[0]++;
                ratingName[0] = "Online: ";
			}
			else if (game.getMultiplayer().equals("Local")) {
                playerCount[1]++;
                ratingName[1] = "Local: ";
            }
			else if (game.getMultiplayer().equals("Both")) {
                playerCount[2]++;
                ratingName[2] = "Both: ";
            }
		}
    	System.out.println("Multiplayer játszhatóság");
    	for (int i = 0; i < ratingName.length; i++) {
            System.out.printf("%s%d db%n", ratingName[i], playerCount[i]);
        }
    }

    
}
