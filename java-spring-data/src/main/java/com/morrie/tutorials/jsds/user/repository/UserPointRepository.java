package com.morrie.tutorials.jsds.user.repository;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Repository
public interface UserPointRepository extends JpaRepository<UserPoint, String> {
}
