package com.gsearch.dto;

@lombok.Data
public class Data {

	private String title;

	private String content;

	private String url;

	public Data(String title, String content, String url) {
		this.title = title;
		this.content = content;
		this.url = url;
	}
}
