package org.jsp.app.repository;

import java.util.Optional;

import org.jsp.app.entity.DealsDary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealsDaryRepository extends JpaRepository<DealsDary, Integer>  {

	Optional<DealsDary> findByPhone(long phn);

}
