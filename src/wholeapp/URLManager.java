package wholeapp;
public class URLManager {
	
	private String accountName; 
	private String domain;
	private String protocol;
	
	private final String MINITROOPERS = "minitroopers";
	
	
	private final String BATTLE = "b/battle";	
	private final String LOGIN = "login";
	private final String MAIN_TROOPER = "t/0";
	
	public URLManager(){
		this.setProtocol("http");
	}
	
	private String getBaseURL(){
		StringBuilder baseURL = new StringBuilder();
		baseURL.append(this.getProtocol());
		baseURL.append("://");
		baseURL.append(this.getAccountName());
		baseURL.append(".");
		baseURL.append(MINITROOPERS);
		baseURL.append(".");
		baseURL.append(this.getDomain());
		baseURL.append("/");
		return baseURL.toString();
	}
	
	public String getLoginURL(){			
			return this.getBaseURL()+LOGIN;
	}
	
	public String getMainTrooperURL(){			
		return this.getBaseURL()+MAIN_TROOPER;
	}
	
	public String getBattleURL(){			
		return this.getBaseURL()+BATTLE;
	}
	
	

	protected String getAccountName() {
		return accountName;
	}

	protected void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	protected String getDomain() {
		return domain;
	}

	protected void setDomain(String domain) {
		this.domain = domain;
	}

	protected String getProtocol() {
		return protocol;
	}

	protected void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	
	
	
}
