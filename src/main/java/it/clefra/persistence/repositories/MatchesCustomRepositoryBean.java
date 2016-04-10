package it.clefra.persistence.repositories;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import it.clefra.persistence.model.MatchModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

public class MatchesCustomRepositoryBean implements MatchesCustomRepository{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<MatchModel> getNMatchByTeam(String team, Integer limit) {
		CriteriaDefinition criteriaDefinition;
		Query query = query(where("home").is(team).orOperator(where("away").is(team))).limit(limit);
		return mongoTemplate.find(query, MatchModel.class);
	}
	
	@Override
	public List<MatchModel> getAllMatchByTeam(String team) {
		CriteriaDefinition criteriaDefinition;
		Query query = query(where("home").is(team).orOperator(where("away").is(team)));
		return mongoTemplate.find(query, MatchModel.class);
	}

}
