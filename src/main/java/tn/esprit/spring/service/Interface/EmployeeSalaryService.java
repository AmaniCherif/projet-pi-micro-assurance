package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.EmployeeSalary;

public interface EmployeeSalaryService {
	List<EmployeeSalary> retrieveAllSalaries();
	EmployeeSalary addSalary(EmployeeSalary s) ;
	void deleteSalary(String id);
	EmployeeSalary updateSalary(EmployeeSalary s);
	EmployeeSalary retrieveSalary(String id) ;
	public int salary();
	//List<EmployeeSalary> ficheDePaie(int id_user);
	void affecterSalaryToUser(int idp, Long id);
	List<?> BestEmployee();
	List<EmployeeSalary> ficheDePaie(Long idUser);

}
