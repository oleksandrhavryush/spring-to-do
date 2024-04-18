package com.havriush.dao;

import com.havriush.domain.Task;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskDAO {

    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Task> getAllTasks(int offset, int limit) {
        Query<Task> query = getSession().createQuery("select t from Task t", Task.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public int getAllTasksCount() {
        Query<Long> query = getSession().createQuery("select count(*) from Task", Long.class);
        return query.uniqueResult().intValue();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Task getTaskById(int id) {
        Query<Task> query = getSession().createQuery("select t from Task t where t.id = :ID", Task.class);
        query.setParameter("ID", id);
        return query.uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdateTask(Task task) {
        getSession().save(task);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTask(int id) {
        getSession().delete(getTaskById(id));
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
