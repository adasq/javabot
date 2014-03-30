package wholeapp;

public class NoMoreBattlesException extends Exception {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreBattlesException(){
		super("No more battles available");
	}
}
