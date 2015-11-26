/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Deliveryservice;
import model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author hp
 */
@RestController

public class RestServiceController {
 
    private DeliveryserviceDAO studentdao=new DeliveryserviceDAO(); 
    @RequestMapping(value="/student", method=RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Deliveryservice student,    UriComponentsBuilder ucBuilder) {
        userFunction uf=new userFunction();
        User user=uf.getUser(119);
        student.setUser(user);
        System.out.println("Creating User" + student.getCity());
 
       
 
        studentdao.saveDeliveryservice(student);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    
    
    
    
    public List<Deliveryservice> students() {
        return studentdao.getDeliveryservices();
    }
     
     
    @RequestMapping(value="/student", method=RequestMethod.GET)
    public Deliveryservice student(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return studentdao.getDeliveryservice(Integer.parseInt(request.getParameter("id")));
        }
        return null;
    }
}
