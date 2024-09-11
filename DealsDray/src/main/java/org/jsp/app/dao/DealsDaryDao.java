package org.jsp.app.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.app.daointerface.DealsDaryDaoInterface;
import org.jsp.app.entity.DealsDary;
import org.jsp.app.repository.DealsDaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DealsDaryDao implements DealsDaryDaoInterface{
	@Autowired
	private DealsDaryRepository dealrepo;
	@Override
	public DealsDary saveDao(DealsDary dd) {
		return dealrepo.save(dd);
	}
	@Override
	public Optional<DealsDary> findByPhone(long phn) {
		return dealrepo.findByPhone(phn);
	}
	@Override
	public List<DealsDary> findAllDealsDao() {
		return dealrepo.findAll();
	}
	@Override
	public Optional<DealsDary> findDealByIDDao(int id) {
		return dealrepo.findById(id);
	}
	@Override
	public void deleteDealByIdDao(int id) {
		dealrepo.deleteById(id);
		
	}

}
