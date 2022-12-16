package br.com.frameworks1.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.frameworks1.students.entity.Students;
import br.com.frameworks1.students.repository.StudentsRepository;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	public Students salvar(Students students) {
		return studentsRepository.save(students);
	}
	
	public List<Students> listaStudents(){
		return studentsRepository.findAll();
	}
	
	public Optional<Students> buscarPorId(Long id){
		return studentsRepository.findById(id);
		
	}
	
	public void removerPorId(Long id) {
		studentsRepository.deleteById(id);;
	}

}
