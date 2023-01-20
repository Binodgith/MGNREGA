package Model;

public class GPM {
	
	public GPM() {
		super();
		// TODO Auto-generated constructor stub
	}


	private int gpmid;
	private String gpmname;
	private String gpmaddress;
	private String gpmphone;
	private String gpmpassword;
	
	public GPM(int gpmid, String gpmname, String gpmaddress, String gpmphone, String gpmpassword) {
		super();
		this.gpmid = gpmid;
		this.gpmname = gpmname;
		this.gpmaddress = gpmaddress;
		this.gpmphone = gpmphone;
		this.gpmpassword = gpmpassword;
	}

	public int getGpmid() {
		return gpmid;
	}

	public void setGpmid(int gpmid) {
		this.gpmid = gpmid;
	}

	public String getGpmname() {
		return gpmname;
	}

	public void setGpmname(String gpmname) {
		this.gpmname = gpmname;
	}

	public String getGpmaddress() {
		return gpmaddress;
	}

	public void setGpmaddress(String gpmaddress) {
		this.gpmaddress = gpmaddress;
	}

	public String getGpmphone() {
		return gpmphone;
	}

	public void setGpmphone(String gpmphone) {
		this.gpmphone = gpmphone;
	}

	public String getGpmpassword() {
		return gpmpassword;
	}

	public void setGpmpassword(String gpmpassword) {
		this.gpmpassword = gpmpassword;
	}

	
	@Override
	public String toString() {
		return "GPM [gpmid=" + gpmid + ", gpmname=" + gpmname + ", gpmaddress=" + gpmaddress + ", gpmphone=" + gpmphone
				+ ", gpmpassword=" + gpmpassword + "]";
	}
	
	
	
	
	
	
	

}
