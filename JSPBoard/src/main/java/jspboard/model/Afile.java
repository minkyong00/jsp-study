package jspboard.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Afile implements Serializable {

	public static final long serialVersionUID = 4654654655646545L;

	private int afid;
	private String afsfname;
	private String afcfname;
	private Timestamp afregdate;
	private String afdelyn;
	private String mid;
	private int aid;

	public Afile() {
	}

	public Afile(int afid, String afsfname, String afcfname, Timestamp afregdate, String afdelyn, String mid, int aid) {
		this.afid = afid;
		this.afsfname = afsfname;
		this.afcfname = afcfname;
		this.afregdate = afregdate;
		this.afdelyn = afdelyn;
		this.mid = mid;
		this.aid = aid;
	}

	public int getAfid() {
		return afid;
	}

	public void setAfid(int afid) {
		this.afid = afid;
	}

	public String getAfsfname() {
		return afsfname;
	}

	public void setAfsfname(String afsfname) {
		this.afsfname = afsfname;
	}

	public String getAfcfname() {
		return afcfname;
	}

	public void setAfcfname(String afcfname) {
		this.afcfname = afcfname;
	}

	public Timestamp getAfregdate() {
		return afregdate;
	}

	public void setAfregdate(Timestamp afregdate) {
		this.afregdate = afregdate;
	}

	public String getAfdelyn() {
		return afdelyn;
	}

	public void setAfdelyn(String afdelyn) {
		this.afdelyn = afdelyn;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "Afile [afid=" + afid + ", afsfname=" + afsfname + ", afcfname=" + afcfname + ", afregdate=" + afregdate
				+ ", afdelyn=" + afdelyn + ", mid=" + mid + ", aid=" + aid + "]";
	}

}
