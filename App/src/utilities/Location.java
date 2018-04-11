package utilities;

public class Location {
	
	private String fullname;
	private String shortname;
	
	public Location(String fullname, String shortname) {
		this.fullname = fullname;
		this.shortname = shortname;
	}
	
	public String getFullname() { return fullname; }
	public String getShortname() { return shortname; }
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
}
