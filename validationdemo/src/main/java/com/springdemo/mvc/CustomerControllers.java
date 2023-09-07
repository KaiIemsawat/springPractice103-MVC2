package com.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerControllers {

    @GetMapping("/")
    public String showForm(Model theModel) {
        // Model allows us to share information between Controllers and view pages (Thymeleaf)
        theModel.addAttribute("customer", new Customer());
//                                 name -> 'customer', 'new Customer()' <- value
//                                         'customer' <-- need to match what declare in HTML
        return "customer-form"; // <-- logical name of view page, will map to : customer-form.html
    }

    @PostMapping("/processForm") // match with action in <form> tag in HTML
    public String processForm(
//                                 'customer' <-- need to match what declare in HTML and above value
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }
}
