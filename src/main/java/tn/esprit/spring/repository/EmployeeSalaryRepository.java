package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.EmployeeSalary;

@Repository
public interface EmployeeSalaryRepository extends CrudRepository<EmployeeSalary,Integer>{
	
	//calcul salaire 
	@Transactional
	@Modifying
	@Query(value="UPDATE employee_salary set salary=(work_hours*15)+(extra_hours*20)",nativeQuery=true) //sql
	public int salary();
	
	//fiche de paie
		@Query(value="SELECT * FROM employee_salary where user_id_user=:User_ID ",nativeQuery=true )
		public List<EmployeeSalary>ficheDePaie(@Param ("User_ID")Long idUser);
		
	//meilleur employee
		@Query("select Max(u.workHours+u.extraHours), u.salaryId from EmployeeSalary u")  
		public List<?> BestEmployee();

}
