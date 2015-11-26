/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author hp
 */
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return User.class.equals(type);    }

    @Override
    public void validate(Object o, Errors errors) {
        	User usr = (User)o;
		
		if(!(usr.getPwd().equals(usr.getConfirmpwd()))){
			errors.rejectValue("pwd", "notmatch.pwd");
		}
                
               //  List users = HibernateUtil.getSessionFactory().openSession().createCriteria(User.class).add(Restrictions.eq("email", usr.getEmail())).list();
          // if(!(users.isEmpty()))
             //   errors.rejectValue("email", "exist.email");
           
                
    }
    
}
