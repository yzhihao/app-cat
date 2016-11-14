package com.nome.util;

import java.util.List;

public class PageUtil<T> {
	public static final int DEFAULT_PAGESIZE = 10;		//默认每页的个数
	public static final int DEFAULT_PAGE = 1;			//默认页数
	public static final int DEFAULT_INDEX = 0;			//默认索引
	
	private int fromIndex;
	// 每页显示的条数
	private int pageSize;
	// 总共的条数
	private int recordCount;
	// 当前页面
	private int currentPage;

	private int pageCount;

	private T object;

	private List<T> objectLists;

	public PageUtil() {
		pageSize = DEFAULT_PAGESIZE;
		currentPage = DEFAULT_PAGE;
		fromIndex = DEFAULT_INDEX;
	}

	//****************************************************get and set *************************************************************************
	
	/**
	 * 总页数
	 * @return
	 */
	public int getPageCount() {
		int size = recordCount / pageSize;
		int mod = recordCount % pageSize;
		if (mod != 0) size++;
		return recordCount == 0 ? 1 : size;
	}
	
	/**
	 * 设置起始索引
	 * @return
	 */
	public int getFromIndex() {
		return (currentPage - 1) * pageSize;
	}

	public int getToIndex() {
		return Math.min(recordCount, currentPage * pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		int validPage = this.currentPage <= 0 ? 1 : this.currentPage;
		validPage = validPage > getPageCount() ? getPageCount() : validPage;
		this.currentPage = validPage;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public List<T> getObjectLists() {
		return objectLists;
	}

	public void setObjectLists(List<T> objectLists) {
		this.objectLists = objectLists;
	}

}
