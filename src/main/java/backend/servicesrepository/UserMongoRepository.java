package backend.servicesrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.entity.User;

public interface UserMongoRepository extends MongoRepository<User, String> {

}
