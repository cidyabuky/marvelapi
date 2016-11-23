package br.com.marvelapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "thumbnail")
public class Thumbnail {

	private static final String PORTRAIT_XLARGE = "/portrait_xlarge.";
	private static final String PORTRAIT_MEDIUM = "/portrait_medium.";
	private static final String PORTRAIT_SMALL = "/portrait_small.";

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idThumbnail;

	@Column(length = 255)
	private String path;

	@Column(length = 10)
	private String extension;

	@OneToOne(mappedBy = "thumbnail")
	private Characters characters;

	public Integer getIdThumbnail() {
		return idThumbnail;
	}

	public void setIdThumbnail(Integer idThumbnail) {
		this.idThumbnail = idThumbnail;
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

	/**
	 * @return Retorna characters
	 */
	public Characters getCharacters() {
		return characters;
	}

	/**
	 * @param characters
	 *            Define characters
	 */
	public void setCharacters(Characters characters) {
		this.characters = characters;
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

	public String getUrlImageSmall() {
		return getUrlImage(PORTRAIT_SMALL);
	}

	@Override
	public String toString() {
		return "Thumbnail [idThumbnail=" + idThumbnail + ", path=" + path + ", extension=" + extension + ", characters=" + characters + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((idThumbnail == null) ? 0 : idThumbnail.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thumbnail other = (Thumbnail) obj;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (idThumbnail == null) {
			if (other.idThumbnail != null)
				return false;
		} else if (!idThumbnail.equals(other.idThumbnail))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

}
