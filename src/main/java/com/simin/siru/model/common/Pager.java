package com.simin.siru.model.common;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class Pager {
	private int totalRecord;
	private int pageSize = 12;
	private int totalPage;
	private int blockSize = 10;
	private int currentPage = 1;
	private int firstPage;
	private int lastPage;
	private int currentPosition;
	private int number;

	public void init(HttpServletRequest request, int total_record) {
		this.totalRecord = total_record;
		totalPage = (int)Math.ceil((float)total_record / pageSize);
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage - (currentPage - 1) % blockSize;
		lastPage = firstPage + blockSize - 1;
		currentPosition = (currentPage - 1) * pageSize;
		number = total_record - currentPosition;
	}
}
