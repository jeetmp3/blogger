package com.myblogspro.repositories;

import com.myblogspro.domains.User;

/**
 * @author Jitendra Singh.
 */
public interface UserRepository extends BloggerRepository<User> {

	User findByEmailAndActive(String email, Boolean active);

	User findByUsernameAndActive(String username, Boolean active);

	User findByUsernameOrEmailAndActive(String username, String email, Boolean active);
}
