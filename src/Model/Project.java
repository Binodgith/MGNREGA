package Model;

public class Project {
	
	private int pid;
	private String pname;
	private int pcost;
	private int pduration;
	private int pgpmid;
	
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(int pid, String pname, int pcost, int pduration, int pgpmid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pduration = pduration;
		this.pgpmid = pgpmid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getPcost() {
		return pcost;
	}


	public void setPcost(int pcost) {
		this.pcost = pcost;
	}


	public int getPduration() {
		return pduration;
	}


	public void setPduration(int pduration) {
		this.pduration = pduration;
	}


	public int getPgpmid() {
		return pgpmid;
	}


	public void setPgpmid(int pgpmid) {
		this.pgpmid = pgpmid;
	}


	
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", pduration=" + pduration
				+ ", pgpmid=" + pgpmid + "]";
	}
	
	
	
	
	
	

}
