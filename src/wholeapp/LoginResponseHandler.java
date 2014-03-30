package wholeapp;

public class LoginResponseHandler extends ResponseHandler {

	public LoginResponseHandler(Response response) {
		super(response);
	}

	@Override
	public String getSsidContent() {
		try {
			return splitedSsid[2].substring(0, 6);
		} catch (Exception e) {
			return null;
		}
	}

}