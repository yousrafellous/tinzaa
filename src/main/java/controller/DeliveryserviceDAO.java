/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Deliveryservice;
import model.HibernateUtil;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hp
 */
public class DeliveryserviceDAO {
  
 
public DeliveryserviceDAO() {
 
}
public List<Deliveryservice> getDeliveryservices()
 
{
 
Session session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
 
List<Deliveryservice> students= session.createCriteria(Deliveryservice.class).list();
 session.getTransaction().commit();
session.close();
return students;
 
}
 
public Deliveryservice getDeliveryservice(int id)
 
{
 
Session session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
 
Criteria cr=session.createCriteria(Deliveryservice.class);
 
cr.add(Restrictions.eq("id", id));
 
Deliveryservice student=(Deliveryservice) cr.list().get(0);
 
session.close();
return student;
 
}

public Deliveryservice saveDeliveryservice(Deliveryservice student)
 
{
 
Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
return student;
 
}
 
 
}
