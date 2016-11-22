package br.com.marvelapi.model;

public class CharacterDataWrapper extends DefaultDataWrapper {
	private static final long serialVersionUID = 5609127031153009150L;

	private Integer code;
	private String status;
	private CharacterDataContainer data;
	private String etag;
	private String copyright;
	private String attributionText;
	private String attributionHTML;

	public CharacterDataWrapper() {
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

	public CharacterDataContainer getData() {
		return data;
	}

	public void setData(CharacterDataContainer data) {
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
