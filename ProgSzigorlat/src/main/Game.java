package main;

public class Game {
	
	private String Platform;
	private String Played;
	private String Name;
	private int OpenCritic;
	private String Genre;
	private String Multiplayer;
	private String source;
	
	public Game(String platform, String played, String name, int openCritic, String genre, String multiplayer,
			String source) {
		super();
		Platform = platform;
		Played = played;
		Name = name;
		OpenCritic = openCritic;
		Genre = genre;
		Multiplayer = multiplayer;
		this.source = source;
	}

	public String getPlatform() {
		return Platform;
	}

	public String getPlayed() {
		return Played;
	}

	public String getName() {
		return Name;
	}

	public int getOpenCritic() {
		return OpenCritic;
	}

	public String getGenre() {
		return Genre;
	}

	public String getMultiplayer() {
		return Multiplayer;
	}

	public String getSource() {
		return source;
	}

	@Override
	public String toString() {
		return "Game [Platform=" + Platform + ", Played=" + Played + ", Name=" + Name + ", OpenCritic=" + OpenCritic
				+ ", Genre=" + Genre + ", Multiplayer=" + Multiplayer + ", source=" + source + "]";
	}
	
	public String toStringDivider() {
		return String.format("%-10s %-10s %-15s %-15s %n", Platform, Played, OpenCritic, Multiplayer, Name);
	}
	

}
