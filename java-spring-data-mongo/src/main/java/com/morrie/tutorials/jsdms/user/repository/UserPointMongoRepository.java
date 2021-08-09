package com.morrie.tutorials.jsdms.user.repository;

import com.morrie.tutorials.jsdms.user.domain.UserPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Repository
public interface UserPointMongoRepository extends MongoRepository<UserPoint, String> {
}
