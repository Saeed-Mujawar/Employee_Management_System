
<h1 align = "center"> Employee Management System </h1>






>### Data flow

  
The Employee Management System is a web-based application designed to streamline the management of employee data for an organization. It provides an easy-to-use interface for HR personnel to manage employee information and allows employees to view and update their own details.

### Technologies Used
* Java
* Spring Boot
* Spring MVC
* Hibernate/JPA
* MySQL

### Features
* Employee Record Management: HR personnel can manage employee records such as personal information, job roles, and salary details.
* Employee Self-Service: Employees can view and update their own personal information.
* Reporting: Various reports are available, including employee attendance and performance.

### Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```

>## Data flow
In this project, we have four layers-
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and  the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.

>## API Endpoints
 EmployeeController
* GET /employee/getAll: Retrieve all employees.
* PUT /employee/updateEmployee/{id}: Update an employee's information.

HRController
* POST /hr/addEmployee: Add a new employee.
* GET /hr/getAll: Retrieve all employees.
* PUT /hr/updateEmployee/{id}: Update an employee's information.
* DELETE /hr/{id}: Delete an employee.

>## Usage
* Use the provided API endpoints to perform CRUD operations on employee data.
* Access the application through a web browser or API testing tool (e.g., Postman) to interact with the system.
* Use the HRController endpoints for HR personnel to manage employee records.
* Use the EmployeeController endpoints for employees to view and update their own information except of their salary.
