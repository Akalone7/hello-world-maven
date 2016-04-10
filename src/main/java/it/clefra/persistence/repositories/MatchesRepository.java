package it.clefra.persistence.repositories;

import java.util.List;

import it.clefra.persistence.model.MatchModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MatchesRepository extends MongoRepository<MatchModel, ObjectId>, MatchesCustomRepository  {

}
