package com.bolsadeideas.springboot.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;
	private int totalPages;
	private int elementsOfPage;
	private int actualPage;
	private List<PageItem> pages;
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		this.elementsOfPage = page.getSize();
		this.totalPages = page.getTotalPages();
		this.actualPage = page.getNumber() + 1;
		
		int from, to;
		if (totalPages <= elementsOfPage) {
			from = 1;
			to = totalPages;
		}else {
			if(actualPage <= elementsOfPage/2) {
				from = 1;
				to = elementsOfPage;
			}else if (actualPage >= totalPages - elementsOfPage/2) {
				from = totalPages - elementsOfPage + 1;
				to = elementsOfPage;		
			}else {
				from = actualPage - elementsOfPage/2;
				to = elementsOfPage;
			}
		}
		for (int i = 0; i < to; i++) {
			pages.add(new PageItem(from + i, actualPage == from + i));
		}
	}
	public String getUrl() {
		return url;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getActualPage() {
		return actualPage;
	}
	public List<PageItem> getPages() {
		return pages;
	}
	public boolean isFirst() {
		return page.isFirst();
	}
	public boolean isLast() {
		return page.isLast();
	}
	public boolean isNext() {
		return page.hasNext();
	}
	
	public boolean isPrevious() {
		return page.hasPrevious();
	}
}
