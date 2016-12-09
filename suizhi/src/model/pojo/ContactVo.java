package model.pojo;

import java.util.List;

import model.pojo.Contact;

public class ContactVo {
	private List<Contact> messages;//咨询
	private int page;//当前页
	private int pages;//总页数
	private long total;
	
	public List<Contact> getMessages() {
		return messages;
	}
	public void setMessages(List<Contact> messages) {
		this.messages = messages;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
