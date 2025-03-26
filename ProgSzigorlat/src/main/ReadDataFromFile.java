package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromFile {
	
	public List<Game> readDataFromCsv() {
		List<Game> games = new ArrayList<Game>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("adatok/ps_extra_games_input.csv"), "UTF-8"));
			String header = br.readLine();
			while(br.ready()) {
				String row = br.readLine();
				games.add(getGame(row));
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("A fájl nem található!");
		} catch (IOException e) {
			System.err.println("IO Hiba történt!");
			e.printStackTrace();
		}
		return games;
	}
	
	public Game getGame(String row) {
		String[] rowData = row.split(";");
        return new Game(
                rowData[0],
                rowData[1],
                rowData[2],
                Integer.parseInt(rowData[3]),
                rowData[4],
                rowData[5],
                rowData[6]
        );
	}

}
