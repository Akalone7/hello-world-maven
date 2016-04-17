package it.clefra.persistence.repositories;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import it.clefra.persistence.model.MatchModel;
import it.clefra.persistence.model.SeasonDayModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

public class SeasonDayRepositoryBean implements SeasonDayCustomRepository{

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * @return la lista delle ultime n giornate giocate dalla squadra
	 */
	public List<SeasonDayModel> findLastNSeasonDaysByTeam(String team, Integer limit) {
		//pipeline
		Criteria criteria = new Criteria();
		UnwindOperation unwind = unwind("matches");
		
		Criteria orOperations = where("matches.home.name").is(team).orOperator(where("matches.away.name").is(team));
		Criteria exists = where("matches.result").exists(true);
		MatchOperation andOperations = match(criteria.andOperator(exists, orOperations));
		LimitOperation limitOp= limit(limit.longValue());
		//populate pipeline
		Aggregation aggregationOperation = newAggregation(unwind, andOperations, limitOp);
		
		//execute pipeline
		AggregationResults<SeasonDayModel> aggregate = mongoTemplate.aggregate(aggregationOperation, SeasonDayModel.class, SeasonDayModel.class);
		
		return aggregate.getMappedResults();
	}
	
//	@Override
//	public List<SeasonDayModel> getLyTeam(String team, Integer limit) {
//		CriteriaDefinition criteriaDefinition;
//		Query query = query(where("home").is(team).orOperator(where("away").is(team))).limit(limit);
//		return mongoTemplate.find(query, SeasonDayModel.class);
//	}
	
//	@Override
//	public List<SeasonDayModel> getAllMatchByTeam(String team) {
//		CriteriaDefinition criteriaDefinition;
//		Query query = query(where("home").is(team).orOperator(where("away").is(team)));
//		return mongoTemplate.find(query, SeasonDayModel.class);
//	}
//
//	@Override
//	public List<SeasonDayModel> getNMatch(String awa) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
