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


	// contructor por defecto
	public GamerDTO() {
	}

	// sobrecarga
	public GamerDTO(String nickName, int id) {
		this.nickName = nickName;
		this.idGamer = id;

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


}
