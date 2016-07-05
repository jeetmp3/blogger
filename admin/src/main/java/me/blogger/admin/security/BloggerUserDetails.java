package me.blogger.admin.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Jitendra Singh.
 */
public class BloggerUserDetails extends User {

	private String id;
	private String name;
	private String email;
	private String profilePicture;
	private String about;

	public BloggerUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public BloggerUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public BloggerUserDetails(me.blogger.domains.User user) {
		this(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.profilePicture = user.getProfilePicture();
		this.about = user.getAbout();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public String getAbout() {
		return about;
	}

	public String getEmail() {
		return email;
	}
}
