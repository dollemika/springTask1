package com.example.springTask1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller1 {
    //метод, который умеет выводить форму с кнопкой
    @GetMapping("/entername")
    public String entername() {
        return "entername";
    }

    //метод, который умеет выводить форму с кнопкой И обрабатывать запрос на этой кнопке
    @GetMapping("/enterandsay")
    public String enterandsay(@RequestParam(name = "name", required = false) String n, Model model) {
        model.addAttribute("name", n);
        return "enter_and_say";
    }

    @GetMapping("/sum")//цепляет функцию к адресу страницы на сайте
    //метод возвращает шаблон и принимает на вход 2 параметра из запроса
    public String sum(@RequestParam(name = "a", defaultValue = "0") String a,
                      @RequestParam(name = "b", defaultValue = "0") String b,
                      Model model/*дополнительный парметр - словарь для испоьзования в шаблоне*/) {
        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            model.addAttribute("result", x + y);
        }
        catch (NumberFormatException e){
            model.addAttribute("errorMsg", "это было не число");
        }
        return "sum";
    }
    @GetMapping("/square")
    public String square(@RequestParam(name = "a", defaultValue = "0") String a,
                      @RequestParam(name = "b", defaultValue = "0") String b,
                      Model model/*дополнительный парметр - словарь для испоьзования в шаблоне*/) {
        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            model.addAttribute("result", x*y);
            model.addAttribute("result2", (x+y)*2);
        }
        catch (NumberFormatException e){
            model.addAttribute("errorMsg", "это было не число");
        }
        return "square";
    }
}