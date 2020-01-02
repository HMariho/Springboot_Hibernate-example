package com.HibernateSpringProto.server.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.HibernateSpringProto.server.model.PriceReduction;

import java.util.List;

@Repository
public interface PriceReductionRepository extends CrudRepository<PriceReduction, Long> {
	List<PriceReduction> findByid(long id);
}
