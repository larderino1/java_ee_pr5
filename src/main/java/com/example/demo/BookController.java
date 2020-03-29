package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    List<Book> books = new ArrayList<>();

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBookGet() {
        return "form";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        books.add(book);
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/booksList", method = RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", books);
        return "index";
    }





}
