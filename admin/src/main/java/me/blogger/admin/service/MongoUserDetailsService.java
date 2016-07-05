package me.blogger.admin.service;

import me.blogger.admin.security.BloggerUserDetails;
import me.blogger.domains.User;
import me.blogger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.logging.Logger;

/**
 * @author Jitendra Singh.
 */
@Service
public class MongoUserDetailsService implements UserDetailsService {

	private static Logger logger = Logger.getLogger(MongoUserDetailsService.class.getName());
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Checking user with name " + username);
		User user = userRepository.findByUsernameOrEmailAndActive(username, username, true);
		if (ObjectUtils.isEmpty(user)) {
			logger.info("User with name " + username + " not found.");
			throw new UsernameNotFoundException("User with this name doesn't exists.");
		}
		return new BloggerUserDetails(user);
	}
}
