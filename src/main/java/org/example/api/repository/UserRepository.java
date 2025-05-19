package org.example.api.repository;
import org.springframework.stereotype.Repository;
import org.example.api.model.User;

@Repository
public class UserRepository extends AbstractRepository<User>{

    @Override
    protected boolean isValid(User user) {
        return user != null && user.getName() != null && !user.getName().isEmpty();
    }
}
