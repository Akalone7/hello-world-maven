package it.clefra.persistence.repositories;

import it.clefra.persistence.model.UserModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository<UserModel, ObjectId> {
	
	@Query("{username : ?0}")
	public UserModel findByUsername(String username);
}
