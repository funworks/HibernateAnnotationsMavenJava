package com.relationships.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import com.relationships.dto.Address;
import com.relationships.dto.Car;
import com.relationships.dto.Passport;
import com.relationships.dto.Person;
import com.relationships.dto.Skill;
import com.relationships.util.HibernateUtil;

public class App 
{
    public static void main( String[] args ) throws ParseException {
        Session s = HibernateUtil.getSessionfactory().openSession();
        s.beginTransaction();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        //Demonstrate One to One relation with another and self table
        Passport selfPassport = new Passport("G2266012", "New Delhi", sdf.parse("31-08-2009"), sdf.parse("31-08-2019"));
        Passport fatherPassport = new Passport("J2446032", "New Delhi", sdf.parse("15-10-2010"), sdf.parse("15-10-2020"));
        
        Person father = new Person("Amit Garg", fatherPassport);
        Person mother = new Person("Mamta Garg");
        Person person = new Person("Mukesh Garg", selfPassport, father, mother);
        s.save(person);
        
        //Demonstrate One to Many relation
        s.save(new Car("AB-01C-1234", person));
        s.save(new Car("DE-01F-5678", person));
        s.save(new Car("GH-01I-9012", mother));
        
        //Demonstrate Many to One relation
        Address addr1 = new Address("15 Segar Street, Danbury");
        Address addr2 = new Address("24 Kings Street, NYC");
        s.save(addr1);
        s.save(addr2);
        person.getAddresses().add(addr1);
        person.getAddresses().add(addr2);
        father.getAddresses().add(addr1);
        mother.getAddresses().add(addr2);
        
        //Demonstrate Many to Many relation
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Hibernate");
        s.save(skill1);
        s.save(skill2);
        person.addSkill(skill1);
        person.addSkill(skill2);
        father.addSkill(skill1);
        father.addSkill(skill2);
        
        s.getTransaction().commit();
        s.close();
        HibernateUtil.shutdown();
    }
}
