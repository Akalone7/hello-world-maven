package it.clefra.persistence.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import it.clefra.persistence.model.SeasonDayModel;

public interface SeasonDayRepository extends MongoRepository<SeasonDayModel, ObjectId>, SeasonDayCustomRepository  {
	@Query("{'seasonDay' : ?0}")
	public SeasonDayModel findSeasonDaysByDay(Integer day);
}
