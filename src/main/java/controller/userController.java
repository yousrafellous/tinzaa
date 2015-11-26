/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validator.UserValidator;
import javax.validation.Valid;
import model.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author hp
 */
@Controller
@RequestMapping(value="user")
public class userController {
    
    
//Display login page
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(ModelMap modelMap)
    {
        modelMap.put("us", new User());
        return "register";}
    
//Traitmenent of the registration page 
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(@ModelAttribute(value="us") @Valid User us,BindingResult bindingResult, ModelMap modelMap)
    {
//Validation of the user        
        UserValidator usv= new UserValidator();
        usv.validate(us, bindingResult);
        
//error in the validation
        if(bindingResult.hasErrors())
        {return "register";}
        
//No error
        else{  
            userFunction uf=new userFunction();            
            
        //Create account
            uf.create(us);
            
        //Send confirmation mail
            uf.sendmail(us);
       
    return "successInscription";
            
            
            
            
            
    }

    }
    
}
