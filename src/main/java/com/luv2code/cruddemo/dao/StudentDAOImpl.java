package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("From Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findBylastName(String lastName) {
        TypedQuery<Student> theQuery
                = entityManager.createQuery("From Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);

    }
    @Override
    @Transactional
    public int deleteAll() {
        int numberOfRows = entityManager.createQuery("delete from Student").executeUpdate();
        return numberOfRows;
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> Name = entityManager.createQuery("From Student where firstName=:theData", Student.class);
        Name.setParameter("theData", firstName);
        return Name.getResultList();
    }
}
