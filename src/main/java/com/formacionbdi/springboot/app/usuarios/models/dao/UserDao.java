package com.formacionbdi.springboot.app.usuarios.models.dao;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "users")
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    @RestResource(path = "find-by-username")
    User findByUsername(@Param("username") String userName);

    @Query("select u from User u where u.username = ?1")
    User getByUsername(String username);
}
