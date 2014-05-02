package sems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sems.dao.StudentDao;
import sems.dao.UserDao;
import sems.vo.StudentVo;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	StudentDao studentDao;
	
	/* @Transactional 애노테이션을 처리하려면, 
	 * 스프링에 트랜잭션 처리자를 등록해야 한다.
	 * <tx:annotation-driven/>
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	@Override
	public void add(StudentVo student) {
			userDao.insert(student);
			studentDao.insert(student);
	}
}























