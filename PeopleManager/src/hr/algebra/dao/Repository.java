/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dao;

import hr.algebra.model.Person;
import hr.algebra.model.Student;
import hr.algebra.model.Subjectt;
import java.util.List;

/**
 *
 * @author franekrmpotic
 */
public interface Repository {
    
    int addPerson(Person data) throws Exception;
    void updatePerson(Person person) throws Exception;
    void deletePerson(Person person) throws Exception;
    Person getPerson(int idPerson) throws Exception;
    List<Person> getPeople() throws Exception;
    
    default void release() throws Exception{};
    
    int addSubject(Subjectt data) throws Exception;
    void updateSubject(Subjectt subject) throws Exception;
    void deleteSubject(Subjectt subject) throws Exception;
    Subjectt getSubject(int idSubject) throws Exception;
    List<Subjectt> getSubjects() throws Exception;

    int addStudent(Student data) throws Exception;
    void updateStudent(Student student) throws Exception;
    void deleteStudent(Student student) throws Exception;
    Student getStudent(int idStudent) throws Exception;
    List<Student> getStudents() throws Exception;
    
}
