package wholeapp;
import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
 

public class JsoupRequestHandler implements RequestHandler {

	private final String USERAGENT = "";
	private final boolean FOLLOW_REDIRECTIONS = false;
	private URLManager urlManager;
 

	public JsoupRequestHandler() {
	}

	@Override
	public boolean sendPostRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendGetRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setURLManager(URLManager urlManager) {
		// TODO Auto-generated method stub
		this.urlManager = urlManager;

	}

	@Override
	public Response sendLoginRequest(String trooperName, String trooperPassword) {

		org.jsoup.Connection.Response response = null;

		try {
			if (trooperPassword != null) {
				response = Jsoup.connect(urlManager.getLoginURL())
						.header("User-Agent", USERAGENT)
						.followRedirects(FOLLOW_REDIRECTIONS)
						.data("login", trooperName, "pass", trooperPassword)
						.method(Method.POST).execute();
			} else {
				response = Jsoup.connect(urlManager.getLoginURL())
						.header("User-Agent", USERAGENT)
						.followRedirects(FOLLOW_REDIRECTIONS)
						.data("login", trooperName).method(Method.POST)
						.execute();
			}
			System.out.println(response.statusMessage());

			return new Response(response.url().toString(), response.headers(),
					response.cookies());

		} catch (IOException e) {
			return null;
		}
	}

	public Response sendMainTrooperRequest() {

		org.jsoup.Connection.Response response = null;

		try {
			response = Jsoup.connect(urlManager.getMainTrooperURL())
					.header("User-Agent", USERAGENT)
					.followRedirects(FOLLOW_REDIRECTIONS).method(Method.GET)
					.execute();
		} catch (IOException e) {
			return null;
		}
		return new Response(response.url().toString(), response.headers(),
				response.cookies());
	}

	@Override
	public Response sendBattleRequest(String trooperId, String ssid) {

		org.jsoup.Connection.Response response = null;

		try {
			response = Jsoup.connect(urlManager.getBattleURL())
					.header("User-Agent", USERAGENT)
					.data("friend", "nopls", "chk", trooperId)
					.cookie("ssid", ssid)
					.followRedirects(FOLLOW_REDIRECTIONS)
					.method(Method.GET).execute();
		} catch (IOException e) {
			return null;
		}
		return new Response(response.url().toString(), response.headers(),
				response.cookies());

	}

}
