package wholeapp;
public class ResponseHandler {

	private Response response;
	private final String SSID = "ssid";
	private final String MAINPAGE_URL = "http://minitroopers.com";
	private final String HEADER_LOCATION = "Location";
	protected int ssidLength;
	private String trooperId;
	protected String ssidValue;
	protected String[] splitedSsid;

	public ResponseHandler(Response response) {
		
		this.response = response;
		System.out.println(this.toString());
		
	}
	
	public void computeSsid() throws Exception{
		try{
			this.ssidValue = this.response.cookies.get(SSID);
			this.splitedSsid = ssidValue.split(":");
			this.ssidLength = splitedSsid.length;	
		}catch(Exception e){
			throw new Exception("nie mzna sparsowac");
		}
		
	}

	public String getSsidContent() {
		System.out.println("ResponseHandler handleSsid");
		return null;
		
	}

	public String getSsidValue() {
		return ssidValue;
	}

	@Override
	public String toString() {
		return "\tResponseHandler[url: "+response.url+", ssidLength=" + ssidLength + ", trooperId=" + trooperId
				+ "]\n\t"+response.cookies.toString()+"\n\t"+response.headers.toString();
	}

	protected int getSsidLength() {
		return ssidLength;
	}

	protected boolean isRedirectionToMainPage() { 
		return (this.response.headers.get(HEADER_LOCATION).equals(MAINPAGE_URL));

	}
	
	protected boolean isRedirection() {
		return !(this.response.headers.get(HEADER_LOCATION) == null);
	}
	
	protected String getRedirection() {
		return this.response.headers.get(HEADER_LOCATION);
	}
	
	protected String getTrooperId() {
		return trooperId;
	}	
	
}