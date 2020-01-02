package com.HibernateSpringProto.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.HibernateSpringProto.server.model.Supplier;


@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
	List<Supplier> findByid(long id);
}
