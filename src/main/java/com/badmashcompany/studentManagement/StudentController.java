package com.badmashcompany.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//in this class we will code/make APIs
@RestController         //to tell springboot that this is APIs class
//@RequestMapping("/student")   used when we want to make any endpoint common to all APIs
public class StudentController {
    Map<Integer,Student> db = new HashMap<>();  //acting as database in this programme


    @GetMapping("/get_info")
    Student getStudent(@RequestParam("id") int admnNo){    //in place of id, q is there  in google search
        return db.get(admnNo);
    }
    @PostMapping("/add")
    String addStudent(@RequestBody Student student){
        db.put(student.getAdmnNo(), student);
        return "Student has benn added successfully";
    }
    @DeleteMapping("/delete/{id}")
    String deleteStudent(@PathVariable("id") int admnNo){
        db.remove(admnNo);
        return "Student info deleted";
    }
    @PutMapping("/update")
    String updateStudent(@RequestBody Student student){
        db.put(student.getAdmnNo(),student);
        return "Student info updated";
    }
    @GetMapping("/get_info/{name}")
    Student getStudent(@PathVariable("name") String name){
        for(Student s: db.values()){
            if(s.getName().equals(name)){
                return db.get(s.getAdmnNo());
            }
        }
        Student stu = new Student("none",0,0,"none");
        return stu;
    }

    //@GetMapping("/get_info")
    //Student getStudent(@RequestParam("name") String name){
        //for(Student s: db.values()){
            //if(s.getName().equals(name)){
                //return db.get(s.getAdmnNo());
            //}
        //}
        //return db.get(1);
    //}


}
