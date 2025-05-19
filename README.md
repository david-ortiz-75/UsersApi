# UsersApi

Rest API with two endpoints:

POST /api/users : Add users
GET /api/users : Get all users

## Running application

The API uses gradle, to run the application use 

```bash
./gradlew bootRun
```

## Using the API

The API has openapi, and we can see the api documentation

and run the two endpoints by navigating to the following url

```
http://localhost:8080/swagger-ui/index.html
```

# Questions

## 1. Generics:
You can find an example of this in the repository implementation

```Java
interface Repository<T> {
    List<T> findAll();
    void save(T entity);
}
```

This interface is used on and abstract class

```Java
public abstract class AbstractRepository <T> implements Repository<T>
```
The use of the Generic interface to create entity specific Repositories
Demonstrates strong type checking and code reuse

## 2. Object Comparison:

In the following test there are examples of reference vs value comparison

```
...     
        User retrievedUser = result.getBody().get(0);
        assertEquals(retrievedUser.getName(), userValues.getName());// expect true because equals compares value not memory reference
        assertFalse(retrievedUser.getName() == userValues.getName());// expect false because == compares memory reference not value equality
        assertFalse(result.getBody().get(0) == userValues); // expect false because == compares memory reference not value equality
        ...
```
## 3. Unit Test and Mocking:
In the UserControllerTest class there are examples of tests using Junit and mockito
