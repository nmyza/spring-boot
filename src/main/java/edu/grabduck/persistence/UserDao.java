package edu.grabduck.persistence;

import edu.grabduck.domain.User;
import edu.grabduck.domain.UserField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class UserDao {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<User> findByUsername(@NotNull String username) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        query(where(UserField.USER_NAME.field()).is(username)),
                        User.class));
    }

    public void save(@NotNull User user) {
        mongoTemplate.save(user);
    }
}
