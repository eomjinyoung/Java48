package sems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sems.dao.StudentDao;
import sems.dao.UserDao;
import sems.vo.StudentVo;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	PlatformTransactionManager txManager;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Override
	public void add(StudentVo student) {
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setName("tx1");
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			
			TransactionStatus status = txManager.getTransaction(def);
			try {
				userDao.insert(student);
				studentDao.insert(student);
				txManager.commit(status);
			} catch (Throwable ex) {
				txManager.rollback(status);
				throw new RuntimeException("학생 정보 입력 오류!", ex);
			}
	}

}








