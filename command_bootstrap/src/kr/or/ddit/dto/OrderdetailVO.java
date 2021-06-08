package kr.or.ddit.dto;

public class OrderdetailVO {
	
	private int ono;		// 주문번호(PK/FK)
	private int pno;		// 상품번호(PK)
	private int qty;		// 주문수량
	private int price;		// 금액
	private String name;	// 수령인
	private String address;	// 수령주소
	private String phone;	// 수령인 핸드폰번호
	
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
