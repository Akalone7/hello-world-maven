package it.clefra.persistence.repositories;

import it.clefra.persistence.model.MatchModel;

import java.util.List;

public interface MatchesCustomRepository {
   
    public List<MatchModel> getNMatch(Integer limit, String team);
}
