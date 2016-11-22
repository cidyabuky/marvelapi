package br.com.marvelapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "characters")
public class Characters implements Serializable {

	private static final long serialVersionUID = -935365239295832718L;

	@Id
	private Integer id;

	private String name;

	@Lob
	@Column(length = 10000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "idThumbnail")
	private Thumbnail thumbnail;

	public Characters() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Characters [id=" + id + ", name=" + name + ", description=" + description + ", modified=" + modified + ", thumbnail=" + thumbnail + "]";
	}

}
