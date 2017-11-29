package com.ericwork.webdemo.bean;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PeopleService implements PeopleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean updatePeople(User people) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(people);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }


}
