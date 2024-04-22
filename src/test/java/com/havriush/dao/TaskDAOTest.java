package com.havriush.dao;

import com.havriush.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TaskDAOTest {

    @Mock
    SessionFactory sessionFactory;

    @Mock
    Session session;

    @InjectMocks
    TaskDAO taskDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

        Query<Task> query = mock(Query.class);
        when(session.createQuery(anyString(), eq(Task.class))).thenReturn(query);
        when(query.setParameter(anyString(), anyInt())).thenReturn(query);
        when(query.uniqueResult()).thenReturn(new Task());

    }

    @Test
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    void getAllTasks_ReturnsListOfTasks() {
        // Arrange
        List<Task> tasks = new ArrayList<>();
        Query<Task> query = mock(Query.class);
        when(session.createQuery(anyString(), eq(Task.class))).thenReturn(query);
        when(query.setFirstResult(anyInt())).thenReturn(query);
        when(query.setMaxResults(anyInt())).thenReturn(query);
        when(query.getResultList()).thenReturn(tasks);

        // Act
        List<Task> result = taskDAO.getAllTasks(0, 10);

        // Assert
        assertEquals(tasks, result);
    }

    @Test
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    void getAllTasksCount_ReturnsTaskCount() {
        // Arrange
        Long count = 10L;
        Query<Long> query = mock(Query.class);
        when(session.createQuery(anyString(), eq(Long.class))).thenReturn(query);
        when(query.uniqueResult()).thenReturn(count);

        // Act
        int result = taskDAO.getAllTasksCount();

        // Assert
        assertEquals(count.intValue(), result);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    void getTaskById_ReturnsTaskById() {
        // Arrange
        int id = 1;
        Task task = new Task();
        Query<Task> query = mock(Query.class);
        when(session.createQuery(anyString(), eq(Task.class))).thenReturn(query);
        when(query.setParameter(anyString(), anyInt())).thenReturn(query);
        when(query.uniqueResult()).thenReturn(task);

        // Act
        Task result = taskDAO.getTaskById(id);

        // Assert
        assertEquals(task, result);
    }


    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    void saveOrUpdateTask_SavesOrUpdateTask() {
        // Arrange
        Task task = new Task();

        // Act
        taskDAO.saveOrUpdateTask(task);

        // Assert
        verify(session).save(task);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    void deleteTask_DeletesTask() {
        // Arrange
        int id = 1;
        Task task = new Task();
        when(taskDAO.getTaskById(id)).thenReturn(task);

        // Act
        taskDAO.deleteTask(id);

        // Assert
        verify(session).delete(task);
    }
}
