package com.firstSpring1505.service;

import com.firstSpring1505.dao.EmployeeDAO;
import com.firstSpring1505.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {
    @Mock private EmployeeDAO dao;
    @InjectMocks private EmployeeServiceImpl service;

    private Employee sample;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sample = new Employee();
        sample.setEmpId("E1");
        sample.setEmpName("Alice");
        sample.setPosition("Dev");
        sample.setPhone("123");
    }

    @Test
    public void createDelegatesToDao() throws Exception {
        service.create(sample);
        verify(dao).insertEmployee(sample);
    }

    @Test
    public void updateReturnsTrueWhenDaoSucceeds() throws Exception {
        when(dao.updateEmployee(sample)).thenReturn(true);
        assertTrue(service.update(sample));
    }

    @Test
    public void deleteReturnsFalseWhenDaoFails() throws Exception {
        when(dao.deleteEmployeeById("E1")).thenReturn(false);
        assertFalse(service.delete("E1"));
    }
}
