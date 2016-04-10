package it.clefra.persistence.repositories;

import it.clefra.persistence.model.MatchModel;

import java.util.List;

public interface MatchesCustomRepository {
   
    public List<MatchModel> getNMatchByTeam(String team, Integer limit);
    
    public List<MatchModel> getAllMatchByTeam(String team);
    
    public List<MatchModel> getNMatch(String awa);
    
}
