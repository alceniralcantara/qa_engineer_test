package br.com.comexport.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.comexport.domain.Student;
import org.springframework.stereotype.Component;

import br.com.comexport.domain.BookDTO;
import br.com.comexport.domain.Book;

@Component
public class BookAdapter {

    public static List<BookDTO> bookEntityToDto( List<Book> books ) {

        List<BookDTO> listBooksDto = new ArrayList<>();

        if (books == null) {
            return listBooksDto;
        }

        books.forEach( book -> {
            BookDTO bookDto = BookDTO.builder()
                    .name( book.getName() )
                    .author( book.getAuthor() )
                    .title( book.getTitle() )
                    .build();

            listBooksDto.add( bookDto );
        } );

        return listBooksDto;
    }
    
    public static List<Book> bookDtoToEntity(List<BookDTO> booksDTO, Student student ) {
        
        List<Book> listBooksEntity = new ArrayList<>();
        
        if (booksDTO == null) {
            return listBooksEntity;
        }
        
        booksDTO.forEach( book -> {
            Book bookDto = Book.builder()
                    .name( book.getName() )
                    .author( book.getAuthor() )
                    .title( book.getTitle() )
                    .student(student)
                    .build();
            
            listBooksEntity.add( bookDto );
        } );
        
        return listBooksEntity;
    }
}
