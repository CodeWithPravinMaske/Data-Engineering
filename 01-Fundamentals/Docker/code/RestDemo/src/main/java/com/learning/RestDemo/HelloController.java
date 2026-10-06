package com.learning.RestDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pravin Maske
 * @created 05/08/25
 *
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String great(){
        return "Hello World";
    }
}
