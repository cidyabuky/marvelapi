package br.com.marvelapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "characters")
public class Characters {

	@Id
	private Integer id;

	private String name;

	@Lob
	@Column(length = 10000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

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

	@Override
	public String toString() {
		return "Characters [id=" + id + ", name=" + name + ", description=" + description + ", modified=" + modified + "]";
	}

}
