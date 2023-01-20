package Model;

public class Employee {
	
	private int eid;
	private String ename;
	private String eaddress;
	private String ephone;
	private int wage;
	private int egpmid;
	private int epid;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int eid, String ename, String eaddress, String ephone, int wage, int egpmid, int epid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.ephone = ephone;
		this.wage = wage;
		this.egpmid = egpmid;
		this.epid = epid;
	}


	public int getWage() {
		return wage;
	}


	public void setWage(int wage) {
		this.wage = wage;
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
				+ ", egpmid=" + egpmid + ", epid=" + epid + "]";
	}
	
	
	
	
	
	

}
