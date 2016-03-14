package modelo;

public class Countries {
	
	private String countryID;
	private String countryName;
	private int regionID;
	
	
	
	public Countries() {
		//super();
		this.countryID = "P0";
		this.countryName = "sin nombre";
		this.regionID = 0;
	}

		
	public Countries(String countryID, String countryName, int regionID) {
		//super();
		this.countryID = countryID;
		this.countryName = countryName;
		this.regionID = regionID;
	}
	
	
	public String getCountryID() {
		return countryID;
	}
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegionID() {
		return regionID;
	}
	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return countryID+","+countryName+","+ regionID;
	}
	
	

}//clase
