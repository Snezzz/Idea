package com.sweater;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/hello-world")
    //name - название параметра (для обращения из шаблона)
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
                                   String name, Map<String,Object> model) {
        model.put("name", name);
        return "hello"; //имя файла для спрингового контейнера, который мы хотим отобразить
    }

}