package ai.neuron.service;

import ai.neuron.dao.IStudentDao;
import ai.neuron.daofactory.StudentDaoFactory;
import ai.neuron.dto.Student;
import ai.neuron.servicefactory.StudentServiceFactory;

//Service layer logic
public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao;

	@Override
	public String addStudServ(String sname, Integer sage, String saddress) {
		studentDao = StudentDaoFactory.getStudentDaoObj();
		return studentDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudServ(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDaoObj();
		return studentDao.searchStudent(sid);
	}

	@Override
	public String deleteStudServ(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDaoObj();
		return studentDao.deleteStudent(sid);
	}

	@Override
	public String updateStudServ(Student student) {
		studentDao = StudentDaoFactory.getStudentDaoObj();
		return studentDao.updateStudent(student);
		
	}

}
