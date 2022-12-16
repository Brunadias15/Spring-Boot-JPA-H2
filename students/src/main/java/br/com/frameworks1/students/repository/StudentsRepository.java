package br.com.frameworks1.students.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.frameworks1.students.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {
	List<Students> findByCourse(String course);
	List<Students> findByCpf(Long cpf);
	List<Students> findByName(String name);
	Optional<Students> findById(Long id);

}
