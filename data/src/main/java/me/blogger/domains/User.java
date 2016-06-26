package me.blogger.domains;

import me.blogger.utils.ApplicationContextHolder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

/**
 * @author Jitendra Singh.
 */
public class User extends AbstractDomain<User> {

	private String name;
	@Indexed(unique = true)
	private String email;
	private String password;
	private Date dateOfBirth;
	private String profilePicture;
	private String about;
	private String role;

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		BCryptPasswordEncoder encoder = ApplicationContextHolder.getBean(BCryptPasswordEncoder.class);
		this.password = encoder.encode(password);
		return this;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public User setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public User setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
		return this;
	}

	public String getAbout() {
		return about;
	}

	public User setAbout(String about) {
		this.about = about;
		return this;
	}

	public String getRole() {
		return role;
	}

	public User setRole(String role) {
		this.role = role;
		return this;
	}
}
