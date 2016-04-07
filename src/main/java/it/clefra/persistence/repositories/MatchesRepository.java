package it.clefra.persistence.repositories;

import it.clefra.persistence.model.MatchModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchesRepository extends MongoRepository<MatchModel, ObjectId>, MatchesCustomRepository  {
}
