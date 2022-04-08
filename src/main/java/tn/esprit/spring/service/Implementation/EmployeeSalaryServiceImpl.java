package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entity.EmployeeSalary;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.EmployeeSalaryRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.EmployeeSalaryService;
@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService{
	
	@Autowired
	EmployeeSalaryRepository salaryRepository;
	@Autowired
	UserRepository userRepository;
	private static final Logger l = LogManager.getLogger(EmployeeSalaryServiceImpl.class);

	@Override
	public List<EmployeeSalary> retrieveAllSalaries() {
		List<EmployeeSalary> salaries = (List<EmployeeSalary>) salaryRepository.findAll();
		for(EmployeeSalary salary : salaries)
		{
			l.info("salary ++ :"+salary);
		}
		return salaries;
	}

	@Override
	public EmployeeSalary addSalary(EmployeeSalary s) {
		EmployeeSalary employeeSalarySaved = null;
		employeeSalarySaved=salaryRepository.save(s);
		return employeeSalarySaved;
	}

	@Override
	public void deleteSalary(String id) {
		salaryRepository.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public EmployeeSalary updateSalary(EmployeeSalary s) {
		EmployeeSalary employeeSalaryAdded = salaryRepository.save(s);
		return employeeSalaryAdded;
	}

	@Override
	public EmployeeSalary retrieveSalary(String id) {
		l.info("in retrieveSalary id= "+id);
		EmployeeSalary s = salaryRepository.findById(Integer.parseInt(id)).orElse(null);
		l.info("Salary returned : " +s);
		return s;
	}

	@Override
	public int salary() {
		return salaryRepository.salary();
	}

	@Override
	public List<EmployeeSalary> ficheDePaie(Long idUser) {
		 List<EmployeeSalary> fiches =salaryRepository.ficheDePaie(idUser);
			return fiches;
	}

	@Override
	public void affecterSalaryToUser(int idp, Long id) {
		System.out.println("****************");
		
		EmployeeSalary employeeSalary = salaryRepository.findById(idp).orElse(null);
		System.out.println(employeeSalary);

		User user = userRepository.findById(id).orElse(null);
		System.out.println(user);

		if (!ObjectUtils.isEmpty(employeeSalary) && !ObjectUtils.isEmpty(user))
			employeeSalary.setUser(user);
			userRepository.save(user);
	}

	@Override
	public List<?> BestEmployee() {
		 return salaryRepository.BestEmployee();
	}

}
