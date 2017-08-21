package bookcloud.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookStore {
	
	@NotNull
	@Size(max=10)
	private String bsnum;

	@NotNull
	@Size(max=45)
	private String name;
	
	@NotNull
	@Size(max=50)
	private String ceo;

	@Size(max=50)
	private String email;

	@Size(max=100)
	private String address;

	private float per;

	@NotNull
	private String yc;

	
	
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

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}

	public String getYc() {
		return yc;
	}

	public void setYc(String yc) {
		this.yc = yc;
	}
	
	


}
