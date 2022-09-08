/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao.sql;

import hr.algebra.dao.Repository;
import hr.algebra.model.Person;
import hr.algebra.model.Student;
import hr.algebra.model.Subjectt;
import java.util.List;
import javax.persistence.EntityManager;


public class HibernateRepository implements Repository {

    @Override
    public int addPerson(Person data) throws Exception {
        try(EntityManagerWrapper  wrapper = HibernateFactory.getEntityManager()) {
            EntityManager em = wrapper.get();
            em.getTransaction().begin();            
            Person person = new Person(data);
            em.persist(person);
            em.getTransaction().commit();
            return person.getIDPerson();
            
        }
    }

    @Override
    public void updatePerson(Person person) throws Exception {
        try(EntityManagerWrapper  wrapper = HibernateFactory.getEntityManager()) {
            EntityManager em = wrapper.get();
            em.getTransaction().begin();            

            em.find(Person.class, person.getIDPerson()).updateDetails(person);
            
            em.getTransaction().commit();
            
        }
    }

    @Override
    public void deletePerson(Person person) throws Exception {
        try(EntityManagerWrapper  wrapper = HibernateFactory.getEntityManager()) {
            EntityManager em = wrapper.get();
            em.getTransaction().begin();            

            em.remove(em.contains(person) ? person : em.merge(person));
            
            em.getTransaction().commit();
            
        }
    }

    @Override
    public Person getPerson(int idPerson) throws Exception {
        try(EntityManagerWrapper  wrapper = HibernateFactory.getEntityManager()) {
            EntityManager em = wrapper.get();          

            return em.find(Person.class, idPerson);
            
        }
    }

    @Override
    public List<Person> getPeople() throws Exception {
          try(EntityManagerWrapper  wrapper = HibernateFactory.getEntityManager()) {
            EntityManager em = wrapper.get();          

            return em.createNamedQuery(HibernateFactory.SELECT_ALL).getResultList();
            
        }
    }

    @Override
    public void release() {
        HibernateFactory.release();
    }
    
    
    //SUBJECT

    @Override
    public int addSubject(Subjectt data) throws Exception {
 try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();
            em.getTransaction().begin();            
            Subjectt subject = new Subjectt(data);            
            em.persist(subject);            
            em.getTransaction().commit();
            return subject.getIDSubject();
        }
    }

    @Override
    public void updateSubject(Subjectt subject) throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();
            em.getTransaction().begin();     
            
            em.find(Subjectt.class, subject.getIDSubject()).updateDetails(subject);
            
            em.getTransaction().commit();
        }   
    }

    @Override
    public void deleteSubject(Subjectt subject) throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();
            em.getTransaction().begin();     
            
            em.remove(em.contains(subject) ? subject : em.merge(subject));
            
            em.getTransaction().commit();
        }
    }

    @Override
    public Subjectt getSubject(int idSubjectt) throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();  
            return em.find(Subjectt.class, idSubjectt);
            
        }
    }

    @Override
    public List<Subjectt> getSubjects() throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();  
            return em.createNamedQuery(HibernateFactory.SELECT_ALLSUBJECTS).getResultList();
            
        }
    }
    
    //STUDENTS

    @Override
    public int addStudent(Student data) throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();
            em.getTransaction().begin();            
            Student student = new Student(data);            
            em.persist(student);            
            em.getTransaction().commit();
            return student.getIDStudent();
        }
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();
            em.getTransaction().begin();     
            
            em.find(Student.class, student.getIDStudent()).updateDetails(student);
            
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteStudent(Student student) throws Exception {
         try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();
            em.getTransaction().begin();     
            
            em.remove(em.contains(student) ? student : em.merge(student));
            
            em.getTransaction().commit();
        }
    }

    @Override
    public Student getStudent(int idStudent) throws Exception {
        try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();  
            return em.find(Student.class, idStudent);
            
        }
    }

    @Override
    public List<Student> getStudents() throws Exception {
         try(EntityManagerWrapper wrapper = HibernateFactory.getEntityManager()){
            EntityManager em = wrapper.get();  
            return em.createNamedQuery(HibernateFactory.SELECT_ALLSTUDENTS).getResultList();
            
        }
    }
    
      
}
