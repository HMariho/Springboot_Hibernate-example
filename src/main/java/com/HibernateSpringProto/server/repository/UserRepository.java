package com.HibernateSpringProto.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HibernateSpringProto.server.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByid(long id);
}
