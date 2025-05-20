package com.firstSpring1505.controller;

import com.firstSpring1505.model.Employee;
import com.firstSpring1505.service.EmployeeService;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeRestControllerTest {
    @Mock private EmployeeService service;
    @InjectMocks private EmployeeRestController controller;
    private MockMvc mvc;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void createEmployee_WhenExists_ReturnsConflictMessage() throws Exception {
        String json = "{\"empId\":\"E1\",\"empName\":\"Bob\",\"position\":\"QA\",\"phone\":\"456\"}";
        when(service.existsById("E1")).thenReturn(true);

        mvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
           .andExpect(status().isOk())
           .andExpect(content().string("Employee ID already exists"));
    }

    @Test
    public void getEmployeeById_NotFound_ReturnsNotFoundText() throws Exception {
        when(service.getById("E2")).thenReturn(null);
        mvc.perform(get("/api/employees/E2"))
           .andExpect(status().isOk())
           .andExpect(content().string("Employee not found"));
    }

    @Test
    public void checkExists_ReturnsBoolean() throws Exception {
        when(service.existsById("E3")).thenReturn(true);
        mvc.perform(get("/api/employees/exists/E3"))
           .andExpect(status().isOk())
           .andExpect(content().string("true"));
    }
}
