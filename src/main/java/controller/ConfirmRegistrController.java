/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.Calendar;
import java.util.Date;
import javax.validation.Valid;
import model.HibernateUtil;
import model.User;
import org.hibernate.Session;
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
public class ConfirmRegistrController {
    Calendar cal=Calendar.getInstance();
    long diff;
    User user;
   String message;
   String ReIns=null;
   String lien=null;
   
   
   
  //Display login page
    @RequestMapping(value="/ConfirmRegistr",method=RequestMethod.GET)
    public String ConfirmRegister(ModelMap modelMap,@RequestParam("id") int id)
    {
        userFunction uf=new userFunction();
        user =uf.getUser(id);
        if(user!=null)
        {
        modelMap.put("us",user);
        Date d=cal.getTime();
         diff=(d.getTime() - user.getCreated().getTime())/(1000*60*60*24);
        
        if(diff<=3)
        {
         if (user.getStatut()==0) {
             
        // has not been confirmed yet:
        user.setStatut(1);
        message="Your confirmation is done";
      ReIns=null;
        
       uf.update(user);
         }}
        else
        {
        message="The link is expired";
        lien="Reinscription.htm?id="+user.getId();
        ReIns="<a href="+lien+" target=popup onClick=\"window.open(lien,'popup','width=700,height=400,left=200,top=200,scrollbars=1')\">Réinscrire</a>";
       
        }
        }
        modelMap.put("ReIns", ReIns);
        modelMap.put("message", message);
        return "successInscConfirmation";
    }
    
    //Traitmenent of the login page 
    @RequestMapping(value="/ConfirmRegistr",method=RequestMethod.POST)
    public String ConfirmRegister(@ModelAttribute(value="use") @Valid User us,BindingResult bindingResult, ModelMap modelMap)
    {
       
   
        //user = us.getUserFromSignupToken(us.getConfirmpwd());
    if (us.getStatut()==0) {
        // has not been confirmed yet:
        us.setStatut(1);
        
       Session session = HibernateUtil.getSessionFactory().openSession();
                 session.beginTransaction();
                 session.update(us);
                 session.getTransaction().commit();
       return "ConfirmRegistr"; 
    } 
   
    
 return "ConfirmRegistr";   
}
}

