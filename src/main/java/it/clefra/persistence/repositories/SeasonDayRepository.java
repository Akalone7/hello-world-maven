package it.clefra.persistence.repositories;

import java.util.List;

import it.clefra.persistence.model.SeasonDayModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SeasonDayRepository extends MongoRepository<SeasonDayModel, ObjectId>, SeasonDayCustomRepository  {
	@Query("{'seasonDay' : ?0}")
	public List<SeasonDayModel> findSeasonDaysByDay(Integer day);
}
