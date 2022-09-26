# Josh Reginaldo - ITMD 415

# Table of Contents:
- [Technology Used](#technology-used)
- [Documentation](#documentation)
  - [Lab 3](#lab-3)
  - [Lab 4](#lab-4)
    - [Domain](#domain)
    - [Test Cases](#test-cases)

# Final Project Repo
This repo will be used for the current "Lab 3" assignment until the end of the semester.  
Commits will be prefixed with the appropriate title (e.g. [Lab 3]) to help distinguish between assignments.

# Technology Used:
- OpenJDK 11 ([Temurin 11.0.16.1+1](https://adoptium.net/temurin/releases/?version=11))
- Payara Server Community ([Payara Server 5.2022.3](https://www.payara.fish/downloads/payara-platform-community-edition/))
- MySQL Community Server ([MySQL 8.0.30](https://dev.mysql.com/downloads/mysql/))

# Documentation:
## Lab 3:
This lab helps us learn the basics of an MVC style approach using
JSP/Servlet, and to become familiar with these technologies in order to compare their use to later
frameworks.

### Questions:
__Difference between the forward and redirect operations:__
A "forward" is when a servlet requests for another resource, usually another jsp or html page, and transfers control over
to the new resource.

A "redirect" is when the client directs the user to a whole new URL or application all together.

__How would you be validating user submissions without the Bean Validation API
standard:__
Without the Bean Validation API, we might have to end up using an incredible amount of try/catch blocks and if/else blocks
to try to check if the input is correct.

__How do you think this approach would scale to a real application with 100's of
entities?__
This approach probably won't scale well because then each entity would require another set of error checking blocks which
might end up slowing it down. Especially if hundreds of users are trying to send their information all at once.

__Why didn't we need to include any additional dependencies (i.e. Bean Validation,
JDBC) in this project?__
Since database connectivity wasn't necessarily required for [Lab 3], there was no need for the JDBC dependency to be added.

## Screenshot Validation:
### User passing input validation
![img.png](assets/images/img.png)
![img_1.png](assets/images/img_1.png)
### User failing input validation
![img_2.png](assets/images/img_2.png)
![img_3.png](assets/images/img_3.png)
[Jump to top](#table-of-contents)

## Lab 4:  
The purpose of this assignment is to learn the basics of ORM and EntityManager operations,
demonstrate through JUnit test cases, and to begin the design process for our final project.  

### Domain:  
__Business Domain__: Library 

__Reason__: I have chosen a library domain because I am currently working in one at the moment. Although I am working
in the computer lab, I do sometimes help customers find books by using the library's database.  

__Possible Entities__:
- Non-Library Cardholder
- Library Cardholder
- Resident Cardholder (User who lives within library city bounds)
    - Full access to library functions
- Staff Cardholder
    - Full access to library functions regardless of home city
- Reciprocal Cardholder (User who has a valid library card from another city)
    - Limited access to library functions
- Library Partners (Organizations, businesses, individuals)
- Library Board
- Library Manager
- Department Manager
- Department Supervisor
- Employee

[Jump to top](#table-of-contents)

### Test Cases:  
__Create__:  
```java
@Test
public void createTest() {
    Library createTest = new Library("createTest", "TestAddress", "123-123-1234", LocalDate.now());

    // Begin insertion sequence
    tx.begin();
    em.persist(createTest);
    tx.commit();

    // Make sure row was successfully inserted
    assertNotNull(createTest.getId());

    // Find newly updated row
    Library compareTest = em.find(Library.class, createTest.getId());
    assertEquals(compareTest.getPhoneNum(), createTest.getPhoneNum());

    // Begin cleanup sequence
    tx.begin();
    em.remove(createTest);
    tx.commit();
}
```  
Testing to see if a test object is being successfully created and inserted as a new row into the database. If successful,
cleanup the test data afterwards.

__Read__:  
```java
@Test
public void readTest() {
    Library readTest = em.createQuery(
    "SELECT l FROM Library l WHERE l.name = 'libraryTest'", Library.class).getSingleResult();
    
    assertEquals("libraryTest", readTest.getName());
}
```
Read from database to see if the newly created library object (initialized in @BeforeEach) was successfully inserted.  

__Update__:  
```java
@Test
public void updateTest() {
    Library updateTest = em.createQuery(
            "SELECT l FROM Library l WHERE l.name = 'libraryTest'", Library.class).getSingleResult();

    // Begin update sequence
    tx.begin();
    updateTest.setStreetAdd("libraryUpdate");
    updateTest.setPhoneNum("321-321-4321");
    updateTest.setEstablished(LocalDate.of(2022, Month.SEPTEMBER, 1));
    tx.commit();

    // Find newly updated row
    Library compareTest = em.find(Library.class, updateTest.getId());

    // Check if updated successfully
    assertEquals("libraryUpdate", compareTest.getStreetAdd());
    assertEquals("321-321-4321", compareTest.getPhoneNum());
    assertEquals(LocalDate.of(2022, Month.SEPTEMBER, 1), compareTest.getEstablished());
}
```
From initialized library object, attempt to update fields and check if it successfully went through

__Delete__:  
```java
@Test
public void deleteTest() {
    Library deleteTest = new Library("deleteTest", "TestAddress", "123-123-1234", LocalDate.now());

    // Begin insertion sequence
    tx.begin();
    em.persist(deleteTest);
    tx.commit();

    // Make sure row was successfully inserted
    assertNotNull(deleteTest.getId());

    // Begin deletion sequence
    tx.begin();
    em.remove(deleteTest);
    tx.commit();

    // Attempt to read deleted object
    Library deleteCheck = em.find(Library.class, deleteTest.getId());

    assertNull(deleteCheck);
}
```  
Create a new library object and go through the steps of inserting into the database. Once inserted, delete the new row
and attempt to read the data into another library object. Check if the new object successfully returns a "Null" value.

