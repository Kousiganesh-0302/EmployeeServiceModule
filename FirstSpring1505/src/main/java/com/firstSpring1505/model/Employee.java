package com.firstSpring1505.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

//import lombok.*;

@Data
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor

  
//    //right click> source > getters and setters > select all ok



public class Employee {
    private String empId;
    private String empName;
    private String position;
    private String phone;
    
//	public String getEmpId() { return empId; }
//    public void setEmpId(String empId) { this.empId = empId; }
//
//    public String getEmpName() { return empName; }
//    public void setEmpName(String empName) { this.empName = empName; }
//
//    public String getPosition() { return position; }
//    public void setPosition(String position) { this.position = position; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
}

