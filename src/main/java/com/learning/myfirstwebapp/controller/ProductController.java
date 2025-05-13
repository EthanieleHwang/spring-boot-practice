package com.learning.myfirstwebapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
public class ProductController {
    @GetMapping("/products")
    public String getAllProducts(){
        return "List of all products";
    }

    @PostMapping("/products")
    public String createProduct() {

        return "Product created successfully";
    }

    @RequestMapping(value = {"/info","/details"},method = RequestMethod.GET)
    public String getAppInfo(){
        return "Application Information";
    }

    @GetMapping("/items/{category}/details/{itemId}")
    public String getItemDetails(@PathVariable String category, @PathVariable String itemId){
        return "Category: "+category+" Item ID: "+itemId;
    }

    @GetMapping("/search")
    public String searchProducts(
            @RequestParam String q,
            @RequestParam(required = false,defaultValue = "relevance") String sort,
            @RequestParam(required = false,defaultValue = "1") int page

    )
    {
        return "Search query: "+q+" Sort by: "+sort+" Page number: "+page;
    }
    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String email){
        return "Subscribed successfully with email: "+email;
    }

}
