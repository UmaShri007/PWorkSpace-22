package ai.neuron.service;

import ai.neuron.dto.Student;

public interface IStudentService {

		public String addStudServ(String sname,Integer sage,String saddress);
		
		public Student searchStudServ(Integer sid);
		
		public String updateStudServ(Student student);
		
		public String deleteStudServ(Integer sid);
	
}
