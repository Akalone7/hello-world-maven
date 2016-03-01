package it.clefra.persistence.repositories;

import it.clefra.persistence.model.CredentialsModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CredentialsRepository extends MongoRepository<CredentialsModel, ObjectId> {
 
	@Query("{username : ?0, password : ?1}")
	public CredentialsModel findByUsernameAndPassword(String username, String password);
}
