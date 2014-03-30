package wholeapp;

public interface RequestHandler {
	
	public boolean sendPostRequest();
	public boolean sendGetRequest();
	public Response sendLoginRequest(String trooperName, String trooperPassword);
	public Response sendMainTrooperRequest();
	public String toString();
	public void setURLManager(URLManager urlManager);
	public Response sendBattleRequest(String trooperId, String ssid);
	
}
