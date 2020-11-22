package model.persistence.Game;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;


// las funcionaleidad ee de partida
public class GameDTO implements Serializable {
	
	private LocalDateTime dateOfGame ;
	private int points;
	private int fk_idGamer;
	private String game; 
	
	public GameDTO( int fk, LocalDateTime dt, int p,String g) {
		this.dateOfGame =dt; 
		this.points = p; 
		this.fk_idGamer = fk; 	
		this.game =g; 
	}
	
	// gettern and setter 
	public LocalDateTime getDateOfGame() {
		return dateOfGame;
	}
	public void setDateOfGame(LocalDateTime dateOfGame) {
		this.dateOfGame = dateOfGame;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getFk_idGamer() {
		return fk_idGamer;
	}
	public void setFk_idGamer(int fk_idGamer) {
		this.fk_idGamer = fk_idGamer;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
	
	
}
