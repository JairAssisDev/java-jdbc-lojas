package com.example.cardapio.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food")
public class FoodControler {

    @GetMapping
    public void getAll(){

    }
}
