package tn.esprit.spring.service.Interface;

import java.util.Optional;

import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.TableMortalité;

public interface ITableMortalitéService {
	TableMortalité Addtm(TableMortalité t);
	
	float findBySurvivantsLx(int ageClient);
	
	float findByDecesDx(int deces);
	
	
	 
	 float findProbaByAgeClient(int ageClient);
	 
	 int findAgeMax();

//	 TableMortalité  findByLx (int age);

	

}
