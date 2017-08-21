package bookcloud.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Pub {
	
	@NotNull
	@Size(min=5, max=18)
	private String pubNum;

	@NotNull
	private String pubName;
	
	@NotNull
	private String pubCeo;

	private String pubAddress;
	
	private String workStyle;
	
	private String workType;

	@NotNull
	private String pubEmail;

	public String getPubNum() {
		return pubNum;
	}

	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getPubCeo() {
		return pubCeo;
	}

	public void setPubCeo(String pubCeo) {
		this.pubCeo = pubCeo;
	}

	public String getPubAddress() {
		return pubAddress;
	}

	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}

	public String getWorkStyle() {
		return workStyle;
	}

	public void setWorkStyle(String workStyle) {
		this.workStyle = workStyle;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getPubEmail() {
		return pubEmail;
	}

	public void setPubEmail(String pubEmail) {
		this.pubEmail = pubEmail;
	}


	
}
