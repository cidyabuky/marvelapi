package br.com.marvelapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "thumbnail")
public class Thumbnail {

	private static final String PORTRAIT_XLARGE = "/portrait_xlarge.";
	private static final String PORTRAIT_MEDIUM = "/portrait_medium.";

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idThumbnail;

	private String path;

	private String extension;

	public Integer getIdThumbnail() {
		return idThumbnail;
	}

	public void setIdThumbnail(Integer idThumbnail) {
		this.id = idThumbnail;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	private String getUrlImage(String size) {
		return getPath() + size + getExtension();
	}

	public String getUrlImageLarge() {
		return getUrlImage(PORTRAIT_XLARGE);
	}

	public String getUrlImageMedium() {
		return getUrlImage(PORTRAIT_MEDIUM);
	}

	@Override
	public String toString() {
		return "Thumbnail [path=" + path + ", extension=" + extension + "]";
	}

}
