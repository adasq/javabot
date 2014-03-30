package wholeapp;
public class TrooperFactory {

	public TrooperFactory() {

	}

	private TrooperBase getTrooperByDomain(Domain domain) {

		TrooperBase newTrooper = null;

		switch (domain) {
		case ENG:
			newTrooper = new TrooperEnglish();
			break;
		case FR:
			newTrooper = new TrooperFrench();
			break;
		default:

			break;
		}
		return newTrooper;

	}


	 
	
	public Trooper createTrooper(Domain domain, String trooperName, String trooperPassword) {
		
		TrooperBase newTrooper= null;
		
		URLManager urlManager = new URLManager();
		urlManager.setAccountName(trooperName);
		urlManager.setDomain(domain.urlValue);
	
		RequestHandler requestHandler = new JsoupRequestHandler();
		requestHandler.setURLManager(urlManager);
			
		newTrooper = this.getTrooperByDomain(domain);
		newTrooper.setRequestHandler(requestHandler);
		
		newTrooper.setTrooperPassword(trooperPassword);
		newTrooper.setTrooperName(trooperName);
			
		return newTrooper;
	}



}
