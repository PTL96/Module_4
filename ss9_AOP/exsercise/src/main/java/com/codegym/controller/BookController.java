package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.OderBook;
import com.codegym.service.IBookService;
import com.codegym.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class BookController {
    @Controller
    @RequestMapping
    public class OderBookController {
        @Autowired
        IBookService iBookService;
        @Autowired
        IOderBookService iOderBookService;
        @GetMapping("")
        public String home(){
            return "home";
        }

        @GetMapping("/list")
        public String showListBook(Model model) {
            model.addAttribute("bookList", iBookService.findAll());
            return "/list";
        }

        @GetMapping("/{id}/detail")
        public String showFormOder(@PathVariable(value = "id") int id, Model model) {
            model.addAttribute("book", iBookService.findById(id));
            return "/detail";
        }

        @PostMapping("/saveOder")
        public String saveOder(@ModelAttribute(value = "book") Book book, RedirectAttributes redirectAttributes) {
            if (book.getQuantity() > 0) {
                OderBook oderBook = new OderBook();
                Long bookRentalCode = (long) (Math.random() * (99999 - 10000) + 10000);
                oderBook.setBookRentalCode(bookRentalCode);
                oderBook.setBook(book);
                iOderBookService.saveOder(oderBook);
                int quantity = book.getQuantity() - 1;
                book.setQuantity(quantity);
                iBookService.saveBook(book);
                redirectAttributes.addFlashAttribute("mess", "Oder Success!!! Mã Thuê Sách là: " + bookRentalCode);
                return "redirect:/list";
            }
            return "/errorPage";
        }


        @PostMapping("/saveReturn")
        public String saveReturn(@ModelAttribute(value = "oderBook") OderBook oderBook, RedirectAttributes redirectAttributes) {
            OderBook oderBookReturn = iOderBookService.findByBookRentalCode(oderBook.getBookRentalCode());
            if (oderBookReturn != null) {
                Book book = (Book) iBookService.findById(oderBookReturn.getBook().getId());
                book.setQuantity(book.getQuantity() + 1);
                iBookService.saveBook(book);
                oderBookReturn.setBookRentalCode((long) 0);
                iOderBookService.saveOder(oderBookReturn);
                redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
                return "redirect:/list";
            }
            return "/errorPage";
        }
    }
}
