DROP TABLE IF EXISTS employee_project;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee;

BEGIN TRANSACTION;

CREATE TABLE employee
(
        employeeId serial,
        jobTitle varchar(64) not null,
        lastName varchar(64) not null,
        firstName varchar(64),
        dateOfBirth timestamp not null,
        dateOfHire timestamp not null,
        department varchar(64) not null,
        gender char(1) not null,
        
       constraint pk_employee primary key (employeeId)
       );
       
 CREATE TABLE department 
 (
        departmentNumber int not null,
        department varchar(64) not null,
        employeeId int not null,
        
        constraint pk_department primary key (departmentNumber),
        constraint fk_department_employee foreign key (employeeId) references employee(employeeId) 
        );
        
CREATE TABLE project
(
        projectNumber int not null,
        name varchar(64) not null,
        startDate timestamp not null,
        
        constraint pk_project primary key (projectNumber)
        --a project can have multiple departments
        );
        
CREATE TABLE employee_project
(
        employeeId int not null,
        projectNumber int not null,
        
        constraint pk_employeeId primary key (employeeId, projectNumber),
        constraint fk_employee_project_employees foreign key (employeeId) references employee(employeeId),
        constraint fk_employee_project_project foreign key (projectNumber) references project(projectNumber)
        );
        
        COMMIT TRANSACTION;