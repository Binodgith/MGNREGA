package Model;

import java.util.Date;

public class Employee {
	
	private int eid;
	private String ename;
	private String eaddress;
	private String ephone;
	private int ewage;
	private Date eDate;
	private int egpmid;
	private int epid;
	

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Employee(int eid, String ename, String eaddress, String ephone, int ewage, Date eDate, int egpmid,
			int epid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.ephone = ephone;
		this.ewage = ewage;
		this.eDate = eDate;
		this.egpmid = egpmid;
		this.epid = epid;
	}




	public int getEid() {
		return eid;
	}




	public void setEid(int eid) {
		this.eid = eid;
	}




	public String getEname() {
		return ename;
	}




	public void setEname(String ename) {
		this.ename = ename;
	}




	public String getEaddress() {
		return eaddress;
	}




	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}




	public String getEphone() {
		return ephone;
	}




	public void setEphone(String ephone) {
		this.ephone = ephone;
	}




	public int getEwage() {
		return ewage;
	}




	public void setEwage(int ewage) {
		this.ewage = ewage;
	}




	public Date geteDate() {
		return eDate;
	}




	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}




	public int getEgpmid() {
		return egpmid;
	}




	public void setEgpmid(int egpmid) {
		this.egpmid = egpmid;
	}




	public int getEpid() {
		return epid;
	}




	public void setEpid(int epid) {
		this.epid = epid;
	}




	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", ephone=" + ephone
				+ ", ewage=" + ewage + ", eDate=" + eDate + ", egpmid=" + egpmid + ", epid=" + epid + "]";
	}
	
	
	
	
	
	
	
	

}
