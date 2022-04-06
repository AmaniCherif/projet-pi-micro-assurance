package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.LeaveTest;
import tn.esprit.spring.entity.Leave_reason;
import tn.esprit.spring.entity.Type_Leave;



@Repository

public interface LeaveTestRepository extends CrudRepository<LeaveTest,Integer>{
	@Query("SELECT l FROM LeaveTest l WHERE l.type_leave= ?1")
	List<LeaveTest> retrieveLeaveByType(Type_Leave type);
	
	@Query("SELECT l FROM LeaveTest l WHERE l.leave_reason= ?1")
	List<LeaveTest> retrieveLeaveByReason(Leave_reason reason);
	@Transactional
	@Modifying
	@Query(value="UPDATE leave_test set leave_duration=datediff(end_date,start_date)",nativeQuery=true)
    public int duration();

	@Query("select count (u) from LeaveTest u group by MONTH(u.Start_date) ")
	public List<Long> statmonthh();
	@Query("select MONTH(u.Start_date) from LeaveTest u group by MONTH(u.Start_date) ")
	public List<String> statmonthhc();
}
