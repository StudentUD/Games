package model.persistence;

import java.io.Serializable;

// implenatdo l ainterfaz seriisable 
public class GamerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;;
	private int idGamer;
	private int points;
	private String game;

	// contructor por defecto
	public GamerDTO() {
	}

	// sobrecarga
	public GamerDTO(String nickName, int id, int p, String g) {
		this.nickName = nickName;
		this.idGamer = id;
		this.points = p;
		this.game = g;
	}

	// gett y setter
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getIdGamer() {
		return idGamer;
	}

	public void setIdGamer(int idGamer) {
		this.idGamer = idGamer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

}
