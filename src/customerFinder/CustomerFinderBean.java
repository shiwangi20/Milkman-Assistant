package customerFinder;

public class CustomerFinderBean {
	public CustomerFinderBean(String mobile, String cName, String address, String area, String city, float cq, float cp,
			float bq, float bp, String date) {
		super();
		this.mobile = mobile;
		CName = cName;
		Address = address;
		Area = area;
		City = city;
		this.cq = cq;
		this.cp = cp;
		this.bq = bq;
		this.bp = bp;
		this.date = date;
	}
	String mobile;								
	String CName;							
	String Address;								
	String Area;							
	String City;						
    float cq;			
	float cp;			
	float bq;			
	float bp;							
	String	date;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public float getCq() {
		return cq;
	}
	public void setCq(float cq) {
		this.cq = cq;
	}
	public float getCp() {
		return cp;
	}
	public void setCp(float cp) {
		this.cp = cp;
	}
	public float getBq() {
		return bq;
	}
	public void setBq(float bq) {
		this.bq = bq;
	}
	public float getBp() {
		return bp;
	}
	public void setBp(float bp) {
		this.bp = bp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	

}
