package wholeapp;
public class TrooperBase implements Trooper {

	private String trooperName = null;
	private String trooperPassword = null;
	protected Domain domain = null;
	private String trooperId = null;
	private String ssid = null;
	public Statistics statistics = null;
	protected RequestHandler requestHandler = null;

	public TrooperBase() {
		statistics = new Statistics();
		
	}

	protected RequestHandler getRequestHandler() {
		return requestHandler;
	}

	protected void setRequestHandler(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	@Override
	public void login() throws LoginException {

		Response response = this.getRequestHandler().sendLoginRequest(
				this.getTrooperName(), this.getTrooperPassword());

		if (response == null) {
			throw new LoginException("Internet connection error");
		}
	
		ResponseHandler responseHandler = new LoginResponseHandler(response);	
		try {
			responseHandler.computeSsid();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ssidContent = responseHandler.getSsidContent();
		
		if (this.isAccountProtected()) {

			System.out.println("password is setted");
			if (responseHandler.getSsidLength() != 6) {
				throw new LoginException("Invalid username / password");
			}

		} else {
			System.out.println("password is NOT setted");

			if (responseHandler.getSsidLength() == 5) {
				if (responseHandler.isRedirectionToMainPage()) {
					throw new LoginException("Trooper does not exsits");
				} else {
			System.out.println("is NOT RedirectionToMainPage");
					Response mainTrooperResponse = requestHandler
							.sendMainTrooperRequest();
					
					ResponseHandler mainTrooperResponseHandler = new ResponseHandler(
							mainTrooperResponse);
					if (mainTrooperResponseHandler.isRedirection()) {
						throw new LoginException(
								"This account is password-protected");
					}else{
						System.out.println("NO PASSWORD");
						}
				}
			} else {
				throw new LoginException("Unhandled custom error!");
			}

		}	
		
		
		this.ssid = responseHandler.getSsidValue();
		this.trooperId= ssidContent;

	}

	@Override
	public void makeMission() {
		// TODO Auto-generated method stub
		System.out.println("makeMission base");
	}

	@Override
	public void makeRaid() {
		// TODO Auto-generated method stub
		System.out.println("makeRaid base");
	}

	@Override
	public void makeBattle() throws BattleException, NoMoreBattlesException {
		
		if(this.statistics.getBattleStatistics().areBattlesDone()){
			throw new NoMoreBattlesException();
		}
		
		int resultCode= 0;
		Response response = this.getRequestHandler().sendBattleRequest(trooperId, ssid);

		if (response == null) {
			throw new BattleException("Internet connection error");
		}
	
		ResponseHandler responseHandler = new BattleResponseHandler(response);
		
		if(responseHandler.getRedirection().equals(Url.HEAQUARTERS)){
			throw new NoMoreBattlesException();
		}
		
		try {
			responseHandler.computeSsid();
			resultCode = Integer.parseInt(responseHandler.getSsidContent());
		} catch (Exception e) {
			throw new BattleException("Sth goes wrong dude...");
		}
		
		if (resultCode == Code.ENG_BATTLE_WIN) {
			this.statistics.getBattleStatistics().addBattlePoints(2);
		} else if (resultCode ==  Code.ENG_BATTLE_LOSE) {
			this.statistics.getBattleStatistics().addBattlePoints(1);
		}	
		
		
	}

	public String getTrooperName() {
		return trooperName;
	}

	public void setTrooperName(String trooperName) {
		this.trooperName = trooperName;
	}

	public String getTrooperPassword() {
		return trooperPassword;
	}

	private boolean isAccountProtected() {
		return !(this.getTrooperPassword() == null);
	}

	public void setTrooperPassword(String trooperPassword) {
		this.trooperPassword = trooperPassword;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.statistics.toString();
	}

	protected Domain getDomain() {
		return domain;
	}

	protected void setDomain(Domain domain) {
		this.domain = domain;
	}
}
