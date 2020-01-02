package com.HibernateSpringProto.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HibernateSpringProto.server.model.Deactivation;
import com.HibernateSpringProto.server.model.Items;

@Repository
public interface DeactivationRepository extends CrudRepository<Deactivation, Long> {
	List<Items> findByid(long id);
}
