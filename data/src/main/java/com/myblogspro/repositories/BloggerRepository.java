package com.myblogspro.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Jitendra Singh.
 */
@NoRepositoryBean
public interface BloggerRepository<T> extends MongoRepository<T, String> {
}
