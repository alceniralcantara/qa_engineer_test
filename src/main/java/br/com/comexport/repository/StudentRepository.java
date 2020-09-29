package br.com.comexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comexport.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByCpf(String cpf);
}
