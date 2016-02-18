package it.clefra.persistence.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import it.clefra.persistence.model.DummyModel;

/**
 * @author <a href="mailto:francesco.mirenda@finconsgroup.com">Francesco L Mirenda</a>
 *
 */
public interface DummyRepository extends MongoRepository<DummyModel, ObjectId> {
}	
