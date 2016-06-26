package me.blogger.admin.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.logging.Logger;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/**
 * @author Jitendra Singh.
 */
@Service
public class SpringSecurityService {

	private static Logger logger = Logger.getLogger(SpringSecurityService.class.getName());

	public boolean isLoggedIn() {
		return (
				!ObjectUtils.isEmpty(getContext().getAuthentication())
						&& getContext().getAuthentication().isAuthenticated()
						&& !(getContext().getAuthentication() instanceof AnonymousAuthenticationToken)
		);
	}

	public UserDetails getUserDetails() {
		if (isLoggedIn()) {
			Object principal = getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails)
				return (UserDetails) principal;
		}
		return null;
	}

	public String currentUserRole() {
		if (isLoggedIn()) {
			UserDetails details = getUserDetails();
			if (!ObjectUtils.isEmpty(details))
				return details.getAuthorities().stream().findFirst().get().getAuthority();
		}
		return null;
	}

}
