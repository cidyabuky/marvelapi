package br.com.marvelapi.model;

import java.io.Serializable;

public class DefaultDataContainer implements Serializable {

	private static final long serialVersionUID = -7015778104295647640L;

	private Integer offset;
	private Integer limit;
	private Integer total;
	private Integer count;

	public DefaultDataContainer() {
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DefaultDataContainer [offset=" + offset + ", limit=" + limit + ", total=" + total + ", count=" + count + "]";
	}

}
