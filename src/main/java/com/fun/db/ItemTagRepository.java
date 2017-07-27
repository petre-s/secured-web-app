package com.fun.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

/**
 * Created by pstanaringa on 24.07.2017.
 */
@Repository
public interface ItemTagRepository extends CrudRepository<ItemTag, Integer> {

    ItemTag save(ItemTag var1);

    ItemTag findOne(Integer var1);

    boolean exists(Integer var1);

    Iterable<ItemTag> findAll();

    Iterable<ItemTag> findAll(Iterable<Integer> var1);

    long count();

    void delete(Integer var1);

    void delete(ItemTag var1);

    void delete(Iterable<? extends ItemTag> var1);

    void deleteAll();
}
