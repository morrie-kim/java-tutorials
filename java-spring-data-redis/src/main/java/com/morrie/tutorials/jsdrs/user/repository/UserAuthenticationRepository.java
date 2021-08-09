package com.morrie.tutorials.jsdrs.user.repository;

import com.morrie.tutorials.jsdrs.user.domain.UserAuthentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by morrie kim on 2021/07/26.
 */
@Repository
public interface UserAuthenticationRepository extends CrudRepository<UserAuthentication, String> {

}
