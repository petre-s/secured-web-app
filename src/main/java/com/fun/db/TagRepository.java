package com.fun.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

/**
 * Created by pstanaringa on 13.07.2017.
 */
@RepositoryRestResource(
        collectionResourceDescription = @Description("The list of all tags"),
        itemResourceDescription = @Description("just a tag"))
@Repository
@PreAuthorize("hasRole('ROLE_GOD')")
public interface TagRepository extends CrudRepository<Tag, Integer> {

}
