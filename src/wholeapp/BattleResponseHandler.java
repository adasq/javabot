package wholeapp;

public class BattleResponseHandler extends ResponseHandler {

	public BattleResponseHandler(Response response) {
		super(response);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getSsidContent() {
		
		try {
			return splitedSsid[3].substring(4);
		} catch (Exception e) {
			return null;
		}
	}

}
