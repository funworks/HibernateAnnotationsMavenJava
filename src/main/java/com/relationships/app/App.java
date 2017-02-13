package com.relationships.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import com.relationships.dto.Address;
import com.relationships.dto.Car;
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
        
        Passport fatherPassport = new Passport("J2446032", "New Delhi", sdf.parse("15-10-2010"), sdf.parse("15-10-2020"));
        
        Person father = new Person("Amit Garg", fatherPassport);
        Person mother = new Person("Mamta Garg");
        Person person = new Person("Mukesh Garg", selfPassport, father, mother);
        
        s.save(person);
        
        s.save(new Car("AB-01C-1234", person));
        s.save(new Car("DE-01F-5678", person));
        s.save(new Car("GH-01I-9012", mother));
        
        Address addr1 = new Address("15 Segar Street, Danbury");
        Address addr2 = new Address("24 Kings Street, NYC");
        s.save(addr1);
        s.save(addr2);
        person.getAddresses().add(addr1);
        person.getAddresses().add(addr2);
        father.getAddresses().add(addr1);
        mother.getAddresses().add(addr2);
        
        s.getTransaction().commit();
        s.close();
        HibernateUtil.shutdown();
    }
}
