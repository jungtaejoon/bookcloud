package bookcloud.controller;

import org.springframework.stereotype.Component;

@Component
public class PrePath {
	
	private final String PATH_FOR_BOOKSTORE = "bookstore/";
	private final String PATH_FOR_BOOK = "book/";
	private final String PATH_FOR_SALES = "sales/";
	private final String PATH_FOR_PUB = "pub/";
	private final String PATH_FOR_TAX = "tax/";
	private final String PATH_FOR_BOOKCLOUDHOME = "bookcloudHome/";
	
	public String getPATH_FOR_BOOKCLOUDHOME() {
		return PATH_FOR_BOOKCLOUDHOME;
	}
	public String getPATH_FOR_BOOKSTORE() {
		return PATH_FOR_BOOKSTORE;
	}
	public String getPATH_FOR_BOOK() {
		return PATH_FOR_BOOK;
	}
	public String getPATH_FOR_SALES() {
		return PATH_FOR_SALES;
	}
	public String getPATH_FOR_PUB() {
		return PATH_FOR_PUB;
	}
	public String getPATH_FOR_TAX() {
		return PATH_FOR_TAX;
	}

	
}
