package br.com.igormartinez.bookservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igormartinez.bookservice.dto.response.BookResponseDTO;
import br.com.igormartinez.bookservice.services.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/book-service")
public class BookController {

    private final BookService service;
    
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/{id}/{currency}")
    public BookResponseDTO findById(
        @PathVariable("id") Long id,
        @PathVariable("currency") String currency
    ) {
        return service.findById(id, currency);
    }
    
    
}
