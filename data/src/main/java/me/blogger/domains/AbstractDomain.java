package me.blogger.domains;

import java.util.Date;

/**
 * @author Jitendra Singh.
 */
public abstract class AbstractDomain<T> {

	private String id;
	private Date dateCreated;
	private Date lastUpdated;
	private boolean active;

	public String getId() {
		return id;
	}

	public T setId(String id) {
		this.id = id;
		return (T) this;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public T setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		return (T)this;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public T setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
		return (T)this;
	}

	public boolean isActive() {
		return active;
	}

	public T setActive(boolean active) {
		this.active = active;
		return (T)this;
	}
}
