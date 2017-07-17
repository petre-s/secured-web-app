package com.fun.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pstanaringa on 13.07.2017.
 */

public interface TagRepository extends CrudRepository<Tag, Integer> {
}
