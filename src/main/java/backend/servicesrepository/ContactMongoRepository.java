package backend.servicesrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.entity.Contact;

public interface ContactMongoRepository extends MongoRepository<Contact, String> {
	


}
