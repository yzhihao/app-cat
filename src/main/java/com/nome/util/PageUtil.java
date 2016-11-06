package com.nome.util;

import java.util.List;

public class PageUtil<T> {
public static int DEFAULT_PAGESIZE = 10;
	
	private int fromIndex;
	// 每页显示的条数
	private int pageSize = 15;
	// 总共的条数
	private int recordCount;
	// 当前页面
	private int currentPage;

	private int pageCount;

	private T object;

	private List<T> objectLists;

	public PageUtil() {
		pageSize = DEFAULT_PAGESIZE;
	}

	public PageUtil(int pageSize, int recordCount, int currentPage, T object) {
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		setCurrentPage(currentPage);
		this.object = object;
	}
	
	public PageUtil(int pageSize, int recordCount, int currentPage) {
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		setCurrentPage(currentPage);
	}

	// 构造方法
	public PageUtil(int pageSize, int recordCount, T object) {
		this(pageSize, recordCount, 1, object);
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// 总页数
	public int getPageCount() {
		// 总条数/每页显示的条数=总页数
		int size = recordCount / pageSize;
		// 最后一页的条数
		int mod = recordCount % pageSize;
		if (mod != 0)
			size++;
		return recordCount == 0 ? 1 : size;
	}

	// 包含，起始索引为0
	public int getFromIndex() {
		return (currentPage - 1) * pageSize;
	}

	// 不包含
	public int getToIndex() {
		return Math.min(recordCount, currentPage * pageSize);
	}

	// 得到当前页
	public int getCurrentPage() {
		return currentPage;
	}

	// 设置当前页
	public void setCurrentPage(int currentPage) {
		int validPage = currentPage <= 0 ? 1 : currentPage;
		validPage = validPage > getPageCount() ? getPageCount() : validPage;
		this.currentPage = validPage;
	}
	
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}

	// 得到每页显示的条数
	public int getPageSize() {
		return pageSize;
	}

	// 设置每页显示的条数
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 得到总共的条数
	public int getRecordCount() {
		return recordCount;
	}

	// 设置总共的条数
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
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
	
	public void setFromIndex(int fromIndex) {
		this.fromIndex = fromIndex;
	}
}
