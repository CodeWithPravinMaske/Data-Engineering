package com.learning.student_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Pravin Maske
 * @created 06/08/25
 *
 */

@RestController
public class StudentController {

    @RequestMapping("/getStudents")
    public List<Student> getStudents() {
        return List.of(new Student(1, "Rudra", 19),
                new Student(2, "Varad", 15),
                new Student(3, "Anvi", 10));
    }
}
