## Event Tracker Project
### Jared Groves

### Overview
- The application contains a single table MySQL table
- The data is accessed using Java entities created/annotated with JPA and Spring Boot. Users can create, update, and delete records through REST operations.
- Allows tracking of of gas fill-ups, where and with comments IOT to track precise MPG.
- Allows on-the-fly conversion of imperial units to metric and vice-versa.

### Technologies/Tools Used
* Java
* Gradle
* Spring Tool Suite
* Hibernate
* HTML
* CSS (Bootstrap)
* JavaScript and jQuery
* MySQL
* GitHub
* Amazon Web Services
* Spring Boot

### How to Run
#Deployed to AWS: http://52.14.143.133:8080/RESTEventTracker/


In Postman:

GET http://52.14.143.133:8080/EventTracker/api/mileages

Provides list of all mileage reports

GET http://52.14.143.133:8080/EventTracker/api/mileages/id

Replace id with a number to receive the individual JSON for the mileage report with that
id

POST http://52.14.143.133:8080/EventTracker/api/mileages

Allows user to create a new mileage report

PATCH http://52.14.143.133:8080/EventTracker/api/mileages/id

Replace id with a number to update the mileage report with that id

PUT http://52.14.143.133:8080/EventTracker/api/mileages/id

Replace id with a number to replace the mileage report with that id

DELETE http://52.14.143.133:8080/EventTracker/api/mileages/id

Replace id with a number to delete the mileage report with that id

GET http://52.14.143.133:8080/EventTracker/api/mileages/avg

Provides the overall average MPG based on current mileage reports


### Challenges and Lessons Learned
* Gained familiarity with Spring Bootstrap
* Improved knowledge of the layout of build.Gradle
* Gained knowledge of Angular to create the front-end
* Practiced with AWS deployment
