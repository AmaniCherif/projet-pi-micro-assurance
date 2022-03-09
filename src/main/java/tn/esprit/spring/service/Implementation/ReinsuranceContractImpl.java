package tn.esprit.spring.service.Implementation;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.ReinsuranceContract;



public class ReinsuranceContractImpl implements CrudRepository<ReinsuranceContract, String> {

	@Override
	public <S extends ReinsuranceContract> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ReinsuranceContract> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ReinsuranceContract> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ReinsuranceContract> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ReinsuranceContract> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReinsuranceContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ReinsuranceContract> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}
