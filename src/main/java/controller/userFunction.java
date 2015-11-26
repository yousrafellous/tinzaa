/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import model.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hp
 */
public class userFunction {
    
//Create user
    public void create (User user)
    {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
           }
        catch(Exception e)
            {e.printStackTrace();}
    }
    
//Update user
    public void update (User user)
    {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
           }
        catch(Exception e)
            {e.printStackTrace();}
    }
    
//get User
    public User getUser(int id)
    {
     
     List users= HibernateUtil.getSessionFactory().openSession().createCriteria(User.class).add(Restrictions.eq("id", id)).list();
     if(!(users.isEmpty()))
           {
          return (User) users.get(0);
           }
     else
     return null;
    
    }
   

//Send confirmation mail
    public void sendmail(User user)
    {
        try
        {ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml"); 
    	HTMLMail mm = (HTMLMail) context.getBean("htmlMail");
        String URL= "http://localhost:8080/Tinza/user/ConfirmRegistr.htm?id="+user.getId();
        String html="<p>Hi "+user.getNom()+" "+user.getPrenom()+" "+"!</p><a href="+URL+">Link text</a>";
	mm.sendMail("tinzaa100@gmail.com",user.getEmail(),"Registration Tinza",html);
        }
        catch(Exception e)
        {e.printStackTrace();}
    }

}
