package com.fun.db;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pstanaringa on 19.07.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
