package com.br.enumerator;

public enum PlayersEnum {

	MANE(466),
	AGUERO(294);	
	
	
	public int playerId;

	private PlayersEnum(int playerId) {
		this.playerId = playerId;
	}
}
