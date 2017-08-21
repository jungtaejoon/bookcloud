package bookcloud.dto;


import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Sales {
	
	@NotNull(message = "Null 값이 올 수 없습니다.")
	@Size(max=10)
	private String bsnum;

	@NotNull(message = "Null 값이 올 수 없습니다.")
	@Size(max=45)
	private String name;
	
	@NotNull(message = "Null 값이 올 수 없습니다.")
	@Size(min=5, max=18)
	private String ISBN;

	@Size(max=45)
	private String title;

	@NotNull(message = "Null 값이 올 수 없습니다.")
	private Date sDate;

	@NotNull(message = "Null 값이 올 수 없습니다.")
	private int amount;

	@NotNull(message = "Null 값이 올 수 없습니다.")
	private int sPrice;

	@NotNull(message = "Null 값이 올 수 없습니다.")
	private int totalPrice;

	public String getBsnum() {
		return bsnum;
	}

	public void setBsnum(String bsnum) {
		this.bsnum = bsnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}



}
