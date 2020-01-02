package com.HibernateSpringProto.server.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.HibernateSpringProto.server.model.Items;

@Repository
public interface ItemRepository extends CrudRepository<Items, Long> {
	List<Items> findByid(long id);
}
