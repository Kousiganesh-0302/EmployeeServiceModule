# EmployeeServiceModule
Rest Api - Session Id, Jpa, Dao, Filter, Pagination, Curd, Errror Exception Handler, Validation Handler


Table:

CREATE TABLE empformservlet (
  emp_id    VARCHAR(20)   PRIMARY KEY,
  emp_name  VARCHAR(100)  NOT NULL,
  position  VARCHAR(50)   NOT NULL,
  phone     VARCHAR(15)   NOT NULL
);


1) POST http://localhost:2105/api/employees
Ex Input:
{
  "empId": "102",
  "empName": "Jane Smith",
  "position": "Analyst",
  "phone": "9876543210"
}

2) GET /api/employees/{empId}
   
3) PUT /api/employees/{empId}
Ex Input:
{
  "empName": "Jane A. Smith",
  "position": "Senior Analyst",
  "phone": "9876543210"
}

4) DELETE /api/employees/{empId}
5) GET /api/employees/page?page={page}&size={size}&sortBy={field}&dir={ASC|DESC}
6) GET /api/employees/filter?position={pos}&page={page}&size={size}&sortBy={field}&dir={ASC|DESC}












