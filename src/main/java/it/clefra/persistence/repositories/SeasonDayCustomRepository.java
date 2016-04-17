package it.clefra.persistence.repositories;

import it.clefra.persistence.model.SeasonDayModel;

import java.util.List;

public interface SeasonDayCustomRepository {
   
    public List<SeasonDayModel> findLastNSeasonDaysByTeam(String team, Integer limit);
    
}
