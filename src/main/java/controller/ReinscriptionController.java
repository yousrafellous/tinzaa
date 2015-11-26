/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validator.UserValidator;
import java.util.Calendar;
import javax.validation.Valid;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping(value="user")
public class ReinscriptionController {
    User user;
    userFunction uf=new userFunction();
    Calendar cal=Calendar.getInstance();
    //Display réinscription page
    @RequestMapping(value="/Reinscription",method=RequestMethod.GET)
    public String Reinscription(ModelMap modelMap,@RequestParam("id") int id)
    {
        
        user =uf.getUser(id);
        if(user!=null)
        {
        modelMap.put("us", user);
        }
        return "Reinscription";
    }
    
    
    //Traitmenent of the Reinscription page 
    @RequestMapping(value="/Reinscription",method=RequestMethod.POST)
    public String Reinscription(@ModelAttribute(value="us") @Valid User usee,BindingResult bindingResult, ModelMap modelMap)
    {
       modelMap.put("usee",user);
       
       //Validation of the user        
        UserValidator usv= new UserValidator();
        usv.validate(usee, bindingResult);
        
    if(bindingResult.hasErrors())
        {return "Reinscription";}
    else{
        //if the user is deleted
    if (usee.getStatut()==3) {
        // the user is in the database for an other time but he is not confirmed:
        usee.setStatut(0);
        usee.setCreated(cal.getTime());
        
      uf.update(usee);
      
      //Send confirmation mail
            uf.sendmail(usee);
       return "successInscription"; 
    } }
   
    
 return "successInscription";   
}
}

