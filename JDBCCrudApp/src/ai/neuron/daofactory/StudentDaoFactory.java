package ai.neuron.daofactory;

import ai.neuron.dao.IStudentDao;
import ai.neuron.dao.StudentDaoImpl;

//Abstraction logic of implementation
public class StudentDaoFactory {
	
	//make constuctor private to avoid object creation
	private StudentDaoFactory() {
	}
	
	private static IStudentDao studentDao = null;
	// creating StudentDao object
	public static IStudentDao getStudentDaoObj() {

		//singlton pattern code
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}

		return studentDao;

	}
}
