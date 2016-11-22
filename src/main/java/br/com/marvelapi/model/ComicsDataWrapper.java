package br.com.marvelapi.model;

public class ComicsDataWrapper extends DefaultDataWrapper {
	private static final long serialVersionUID = 5609127031153009150L;

	private Integer code;
	private String status;
	private ComicsDataContainer data;
	private String etag;
	private String copyright;
	private String attributionText;
	private String attributionHTML;

	public ComicsDataWrapper() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ComicsDataContainer getData() {
		return data;
	}

	public void setData(ComicsDataContainer data) {
		this.data = data;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	@Override
	public String toString() {
		return "Header [code=" + code + ", status=" + status + ", data=" + data + ", etag=" + etag + ", copyright=" + copyright + ", attributionText=" + attributionText + ", attributionHTML="
				+ attributionHTML + "]";
	}

}
