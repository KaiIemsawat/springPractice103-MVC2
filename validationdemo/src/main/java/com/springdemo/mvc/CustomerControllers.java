package com.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerControllers {

//    Trim whitespace if there is any (front and back)
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // true mean to trim down whitespace

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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

        System.out.println("First name : |" + theCustomer.getFirstName() + "|");
        System.out.println("Last name : |" + theCustomer.getLastName() + "|");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }
}
