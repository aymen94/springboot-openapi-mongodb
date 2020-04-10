package xyz.aymen.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import xyz.aymen.example.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
