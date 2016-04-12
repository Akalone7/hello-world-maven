package it.clefra.persistence.repositories;

import it.clefra.persistence.model.SeasonDayModel;

import java.util.List;

public interface SeasonDayCustomRepository {
   
    public List<SeasonDayModel> getLastNSeasonDaysByTeam(String team, Integer limit);
    
    //public List<SeasonDayModel> getAllMatchByTeam(String team);
    
   // public List<SeasonDayModel> getNMatch(String awa);
    
}
