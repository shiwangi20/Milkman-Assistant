package billLog;

public class BillHistoryBean {
public BillHistoryBean(String mobile, float cqT, float bqT, float cBill, float bBill, float total, int status,
			int month, int year) {
		super();
		this.mobile = mobile;
		this.cqT = cqT;
		this.bqT = bqT;
		CBill = cBill;
		BBill = bBill;
		Total = total;
		Status = status;
		this.month = month;
		this.year = year;
	}
public BillHistoryBean(){}
String mobile;	
float cqT;
float bqT;
float CBill;	
float BBill;
float Total;
int	Status;	
int	month;	
int	year;
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public float getCqT() {
	return cqT;
}
public void setCqT(float cqT) {
	this.cqT = cqT;
}
public float getBqT() {
	return bqT;
}
public void setBqT(float bqT) {
	this.bqT = bqT;
}
public float getCBill() {
	return CBill;
}
public void setCBill(float cBill) {
	CBill = cBill;
}
public float getBBill() {
	return BBill;
}
public void setBBill(float bBill) {
	BBill = bBill;
}
public float getTotal() {
	return Total;
}
public void setTotal(float total) {
	Total = total;
}
public int getStatus() {
	return Status;
}
public void setStatus(int status) {
	Status = status;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

}
