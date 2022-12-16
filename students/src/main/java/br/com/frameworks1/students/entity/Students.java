package br.com.frameworks1.students.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "students")
public class Students implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name ="cpf")
	private Long cpf;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="course")
	private String course;

	public Students() {

	}

	public Students( Long cpf, String name, String course) {
		this.cpf = cpf;
		this.name = name;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", cpf=" + cpf + ", name=" + name + ", course=" + course + "]";
	}
	
	
	
	
}
