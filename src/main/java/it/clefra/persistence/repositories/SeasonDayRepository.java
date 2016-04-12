package it.clefra.persistence.repositories;

import it.clefra.persistence.model.SeasonDayModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonDayRepository extends MongoRepository<SeasonDayModel, ObjectId>, SeasonDayCustomRepository  {

}
