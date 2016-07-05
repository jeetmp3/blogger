package me.blogger.repositories;

import me.blogger.domains.User;

/**
 * @author Jitendra Singh.
 */
public interface UserRepository extends BloggerRepository<User> {

	User findByEmailAndActive(String email, Boolean active);

	User findByUsernameAndActive(String email, Boolean active);

	User findByUsernameOrEmailAndActive(String username, String email, Boolean active);
}
