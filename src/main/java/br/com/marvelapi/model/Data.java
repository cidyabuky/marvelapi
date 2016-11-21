package br.com.marvelapi.model;

import java.util.List;

public class Data {

	private Integer offset;
	private Integer limit;
	private Integer total;
	private Integer count;
	private List<Characters> results;

	public Data() {
		// TODO Auto-generated constructor stub
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

	public List<Characters> getResults() {
		return results;
	}

	public void setResults(List<Characters> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Informacoes [offset=" + offset + ", limit=" + limit + ", total=" + total + ", count=" + count + ", results=" + results + "]";
	}

}
