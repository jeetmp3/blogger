package me.blogger.repositories;

import me.blogger.domains.User;

/**
 * @author Jitendra Singh.
 */
public interface UserRepository extends BloggerRepository<User> {

	User findByEmailAndActive(String email, Boolean active);
}
