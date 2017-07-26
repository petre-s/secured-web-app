package com.fun.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by petre on 26.07.2017.
 */
@Repository
@RepositoryRestResource( )
public interface ItemTagRepository extends CrudRepository<ItemTag, Integer>{

}
