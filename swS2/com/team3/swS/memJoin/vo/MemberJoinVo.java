package team3.swS.memJoin.vo;

import java.io.Serializable;

public class MemberJoinVo implements Serializable {
	
	private static final long serialVersionUID = -3137100146925491126L;
	
	private String mem_no;			// 회원번호
	private String mem_password;	// 비밀번호
	private String mem_nick;		// 닉네임
	private String mem_interrest;	// 관심분야
	private String mem_email;		// 이메일
	private String mem_mileage;		// 마일리지
	private String mem_telno;		// 전화번호
	private String mem_id;			// 아이디
	private String mem_stop;		// 정지여부
	private String mem_author;		// 관리자권한
	private String mem_endday;
	private String cmile_order_no;  // 회원주문번호
	private String cmile_date;  // 회원주문날짜
	
	
	public String getMem_endday() {
		return mem_endday;
	}
	public void setMem_endday(String mem_endday) {
		this.mem_endday = mem_endday;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_interrest() {
		return mem_interrest;
	}
	public void setMem_interrest(String mem_interrest) {
		this.mem_interrest = mem_interrest;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_mileage() {
		return mem_mileage;
	}
	public void setMem_mileage(String mem_mileage) {
		this.mem_mileage = mem_mileage;
	}
	public String getMem_telno() {
		return mem_telno;
	}
	public void setMem_telno(String mem_telno) {
		this.mem_telno = mem_telno;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_stop() {
		return mem_stop;
	}
	public void setMem_stop(String mem_stop) {
		this.mem_stop = mem_stop;
	}
	public String getMem_author() {
		return mem_author;
	}
	public void setMem_author(String mem_author) {
		this.mem_author = mem_author;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCmile_order_no() {
		return cmile_order_no;
	}
	public void setCmile_order_no(String cmile_order_no) {
		this.cmile_order_no = cmile_order_no;
	}
	public String getCmile_date() {
		return cmile_date;
	}
	public void setCmile_date(String cmile_date) {
		this.cmile_date = cmile_date;
	}
	
	

	
}
