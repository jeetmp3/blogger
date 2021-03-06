package com.myblogspro.repositories;

import com.myblogspro.domains.Blog;
import com.myblogspro.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Jitendra Singh.
 */
public interface BlogRepository extends BloggerRepository<Blog> {

	Page<Blog> findAll(Pageable pageable);
	Page<Blog> findAllByAuthor(User user, Pageable pageable);

	Blog findByAuthorAndTitleLinkAndYearAndMonthAndDay(User author, String link, short year, byte month, byte day);
}
