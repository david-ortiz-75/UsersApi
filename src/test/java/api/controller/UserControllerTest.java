package api.controller;

import org.example.api.controller.UserController;
import org.example.api.model.User;
import org.example.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserController controller;

    @Test
    void addUser_shouldCallRepo() {
        User user = new User("David", 35);
        ResponseEntity<Void> response = controller.addUser(user);

        verify(repo).save(user);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void addUser_shouldCallRepo_verifyObjectAndReference() {
        User user = new User("David", 35);
        User userValues = new User(new String(user.getName()), user.getAge());
        List<User> mockUsers = List.of(user);
        when(repo.findAll()).thenReturn(mockUsers);
        ResponseEntity<List<User>> result = controller.getAllUsers();

        User retrievedUser = result.getBody().get(0);
        assertEquals(retrievedUser.getName(), userValues.getName());// expect true because equals compares value not memory reference
        assertFalse(retrievedUser.getName() == userValues.getName());// expect false because == compares memory reference not value equality
        assertFalse(result.getBody().get(0) == userValues); // expect false because == compares memory reference not value equality

    }

    @Test
    void getAllUsers_shouldReturnUsers() {
        List<User> mockUsers = List.of(new User("David", 35));
        when(repo.findAll()).thenReturn(mockUsers);

        ResponseEntity<List<User>> result = controller.getAllUsers();

        assertEquals(1, result.getBody().size());
        assertEquals("David", result.getBody().get(0).getName());
    }


}