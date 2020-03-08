package com.morrie.tutorials.jsds.user.repository;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by morrie kim on 2020/03/09.
 */
public interface UserPointRedisRepository extends CrudRepository<UserPoint, String> {
}
