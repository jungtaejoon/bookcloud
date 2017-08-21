package bookcloud.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
	
	@NotNull
	@Size(min=5, max=18)
	private String ISBN;

	@NotNull
	@Size(min=5, max=45)
	private String title;
	
	@NotNull
	@Size(min=5, max=45)
	private String author;

	@NotNull
	private int price;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



}
