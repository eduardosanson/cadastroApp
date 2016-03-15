package com.free.commerce.repository;

import com.free.commerce.entity.UserLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by eduardosanson on 05/03/16.
 */
public interface UserRepository extends CrudRepository<UserLogin,Long> {


}
