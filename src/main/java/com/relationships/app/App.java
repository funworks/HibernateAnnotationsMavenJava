package com.relationships.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import com.relationships.dto.Passport;
import com.relationships.dto.Person;
import com.relationships.util.HibernateUtil;

public class App 
{
    public static void main( String[] args ) throws ParseException {
        Session s = HibernateUtil.getSessionfactory().openSession();
        s.beginTransaction();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        Passport selfPassport = new Passport("G2266012", "New Delhi", sdf.parse("31-08-2009"), sdf.parse("31-08-2019"));
        
        Passport fatherPassport = new Passport("J2446032", "Ambala", sdf.parse("15-10-2010"), sdf.parse("15-10-2020"));
        
        Person father = new Person("Amit Garg", fatherPassport);
        Person mother = new Person("Mamta Garg");
        Person person = new Person("Mukesh Garg", selfPassport, father, mother);
        
        s.save(person);
        s.getTransaction().commit();
        s.close();
        HibernateUtil.shutdown();
    }
}
