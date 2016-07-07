package com.myblogspro.domains;

import java.time.LocalDateTime;

/**
 * @author Jitendra Singh.
 */
public abstract class AbstractDomain<T> {

	private String id;
	private LocalDateTime dateCreated;
	private LocalDateTime lastUpdated;
	private boolean active;

	public String getId() {
		return id;
	}

	public T setId(String id) {
		this.id = id;
		return (T) this;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public T setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
		return (T)this;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public T setLastUpdated(LocalDateTime lastUpdated) {
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
