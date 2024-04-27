package br.com.igormartinez.bookservice.services;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.igormartinez.bookservice.dto.cambioservice.CambioResponseDTO;
import br.com.igormartinez.bookservice.dto.response.BookResponseDTO;
import br.com.igormartinez.bookservice.models.Book;
import br.com.igormartinez.bookservice.repositories.BookRepository;

@Service
public class BookService {
    
    private final Environment environment;
    private final BookRepository repository;
    private final CambioService cambioService;

    public BookService(Environment environment, BookRepository repository, CambioService cambioService) {
        this.environment = environment;
        this.repository = repository;
        this.cambioService = cambioService;
    }

    public BookResponseDTO findById(Long id, String currency) {

        Book book = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found"));

        CambioResponseDTO camvioResponse = cambioService.getCambio(
            book.getPrice(), "USD", currency
        );

        return new BookResponseDTO(
            book.getId(), 
            book.getAuthor(), 
            book.getTitle(), 
            book.getLaunchDate(), 
            camvioResponse.convertedValue(), 
            currency, 
            environment.getProperty("local.server.port")
        );
    }
}
