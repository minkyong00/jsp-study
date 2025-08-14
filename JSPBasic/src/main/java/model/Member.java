package model;

import java.io.Serializable;

/* 
	Javabeans 규약(= VO, DO, POJO)
	1. public class : 외부에서 클래스에 접근할 수 있도록
	2. private member variable : 외부에서 데이터의 직접 접근을 불허
	3. public constructor : 외부에서 객체를 생성할 수 있도록
	4. public getter/setter : 외부에서 데이터를 조회하거나 변경할 수 있도록
	5. toString() / equals() 오버라이딩 (선택)
	6. Serializable 인터페이스를 구현하고 serialVersionUID를 생성 (선택)
*/

public class Member implements Serializable {

	private static final long serialVersionUId = 5454354154354343541L;

	private String mid; // 회원아이디
	private String mpass; // 회원 비밀번호
	private String mname; // 회원 이름
	private int mage; // 회원 나이
	private String mcp; // 회원 휴대폰 번호
	private String memail; // 회원 이메일

	public Member() {
	}

	public Member(String mid, String mpass, String mname, int mage, String mcp, String memail) {
		this.mid = mid;
		this.mpass = mpass;
		this.mname = mname;
		this.mage = mage;
		this.mcp = mcp;
		this.memail = memail;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMage() {
		return mage;
	}

	public void setMage(int mage) {
		this.mage = mage;
	}

	public String getMcp() {
		return mcp;
	}

	public void setMcp(String mcp) {
		this.mcp = mcp;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpass=" + mpass + ", mname=" + mname + ", mage=" + mage + ", mcp=" + mcp
				+ ", memail=" + memail + "]";
	}

}
