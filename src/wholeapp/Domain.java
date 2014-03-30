package wholeapp;

public enum Domain {
	ENG("com"), 
	FR("fr");
	
	String urlValue;

	private Domain(String urlValue) {
		this.urlValue = urlValue;
	}
}


