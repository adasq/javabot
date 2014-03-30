package wholeapp;

public interface Trooper {

	public void login() throws LoginException;
	public void makeMission();
	public void makeRaid();
	public void makeBattle()  throws BattleException, NoMoreBattlesException;
	public String toString();
	
}
