package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.LeaveTest;
import tn.esprit.spring.entity.Leave_reason;
import tn.esprit.spring.entity.Type_Leave;

public interface LeaveTestService {
	List<LeaveTest> retrieveAllLeaves();
	LeaveTest addLeave(LeaveTest l) ;
	void deleteLeave(String id) ;
	LeaveTest updateLeave(LeaveTest l) ;
	LeaveTest retrieveLeave(String id);
	List<LeaveTest> retrieveLeaveByType(Type_Leave type);
	List<LeaveTest> retrieveLeaveByReason(Leave_reason reason);
	void affecterUserALeave(int idu, Long id);
	public int duration();
	List<Long> statmonthh();
	List<String> statmonthhc();
	
}
