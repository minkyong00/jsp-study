package member.model;

import java.io.Serializable;

public class Member implements Serializable {

	public static final long serialVersionUID = 5651651651654654L;

	private int mid;
	private String mpassword;
	private String mname;
	private String memail;

	public Member() {
	}

	public Member(int mid, String mpassword, String mname, String memail) {
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.memail = memail;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", memail=" + memail + "]";
	}

}
