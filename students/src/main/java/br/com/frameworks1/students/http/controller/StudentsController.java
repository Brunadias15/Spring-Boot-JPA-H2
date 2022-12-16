package br.com.frameworks1.students.http.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.frameworks1.students.entity.Students;
import br.com.frameworks1.students.service.StudentsService;


@RestController
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	private StudentsService studentsService; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Students salvar(@RequestBody Students students) {
		return studentsService.salvar(students);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Students> listarStudents(){
		return studentsService.listaStudents();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Students buscarStudentsPorId(@PathVariable("id") Long id) {
		return studentsService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudante nao encontrado"));
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerStudents(@PathVariable("id") Long id) {
		studentsService.buscarPorId(id)
		.map(students -> {
			studentsService.removerPorId(students.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudante nao encontrado"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarStudents(@PathVariable("id") Long id, @RequestBody Students students) {
		studentsService.buscarPorId(id)
		.map(studentsBase -> {
			modelMapper.map(students, studentsBase);
			studentsService.salvar(studentsBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudante nao encontrado"));
	}
	
	

}
