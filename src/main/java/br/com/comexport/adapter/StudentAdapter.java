package br.com.comexport.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.comexport.domain.StudentDTO;
import br.com.comexport.domain.Student;

@Component
public class StudentAdapter {

    @Autowired
    private BookAdapter bookAdapter;
    
    public Student studentDtoToEntity(StudentDTO studentDTO) {
        Student student =  Student.builder()
                .name( studentDTO.getName() )
                .email( studentDTO.getEmail() )
                .years( studentDTO.getYears() )
                .cpf( studentDTO.getCpf())
                .build();
        student.setBooks(bookAdapter.
                bookDtoToEntity(studentDTO.getBooks(), student));
        return student;
    }
    
    public StudentDTO studentEntityToDto(Student student) {
        
        return StudentDTO.builder()
                .name( student.getName() )
                .email( student.getEmail() )
                .years( student.getYears() )
                .cpf( student.getCpf() )
                .books( bookAdapter.bookEntityToDto( student.getBooks() ) )
                .build();
    }

    public List<StudentDTO> studentEntityToDtoForList( List<Student> students ) {

        List<StudentDTO> listStudentsDto = new ArrayList<>();

        if (students == null) {
            return listStudentsDto;
        }
        students.forEach( student -> {

            StudentDTO studentDTO = StudentDTO.builder()
                    .name( student.getName() )
                    .email( student.getEmail() )
                    .years( student.getYears() )
                    .cpf( student.getCpf() )
                    .books( bookAdapter.bookEntityToDto( student.getBooks() ) )
                    .build();

            listStudentsDto.add( studentDTO );
        } );
        return listStudentsDto;
    }
}
