package br.com.igormartinez.bookservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igormartinez.bookservice.dto.response.BookResponseDTO;
import br.com.igormartinez.bookservice.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("/book-service")
public class BookController {

    private final BookService service;
    
    public BookController(BookService service) {
        this.service = service;
    }

    @Operation(summary = "Find a specific book by id")
    @GetMapping("/{id}/{currency}")
    public BookResponseDTO findById(
        @PathVariable("id") Long id,
        @PathVariable("currency") String currency
    ) {
        return service.findById(id, currency);
    }
    
    
}
