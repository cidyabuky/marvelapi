package br.com.marvelapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Comics implements Serializable {

	private static final long serialVersionUID = -6019807383757168951L;

	@Id
	private Integer id;

	private Integer digitalId;

	private String title;

	@Lob
	@Column(length = 10000)
	private String description;

	private Integer pageCount;

	private Thumbnail thumbnail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comics [id=" + id + ", title=" + title + ", description=" + description + ", pageCount=" + pageCount + ", thumbnail=" + thumbnail + "]";
	}

}
