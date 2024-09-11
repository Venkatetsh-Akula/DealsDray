package org.jsp.app.daointerface;

import java.util.List;
import java.util.Optional;

import org.jsp.app.entity.DealsDary;
import org.springframework.stereotype.Repository;

public interface DealsDaryDaoInterface {

	DealsDary saveDao(DealsDary dd);

	Optional<DealsDary> findByPhone(long phn);

	List<DealsDary> findAllDealsDao();

	Optional<DealsDary> findDealByIDDao(int id);

	void deleteDealByIdDao(int id);

}
