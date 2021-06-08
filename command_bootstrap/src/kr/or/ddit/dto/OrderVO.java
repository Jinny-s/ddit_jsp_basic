package kr.or.ddit.dto;

import java.util.Date;

public class OrderVO {

	private int ono;			// 주문번호(PK)
	private String id;			// 주문자ID
	private int totalprice;		// 총주문금액
	private Date orderdate;		// 주문일자
	private String orderstatus;	// 주문상태 (주문완료/주문취소)
	
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
}
