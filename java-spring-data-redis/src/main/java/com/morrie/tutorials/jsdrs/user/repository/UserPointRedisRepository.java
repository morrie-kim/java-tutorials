package com.morrie.tutorials.jsdrs.user.repository;

import com.morrie.tutorials.jsdrs.user.domain.UserPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Repository
public interface UserPointRedisRepository extends CrudRepository<UserPoint, String> {
}
