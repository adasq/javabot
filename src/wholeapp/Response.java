package wholeapp;
import java.util.Map;


public class Response {
	
	public Map<String, String> headers;
	public Map<String, String> cookies;
	public String url;
	
	public Response(String url, Map<String, String> headers, Map<String, String> cookies){
		this.headers=headers;
		this.cookies=cookies;
		this.url=url;
	}


}
