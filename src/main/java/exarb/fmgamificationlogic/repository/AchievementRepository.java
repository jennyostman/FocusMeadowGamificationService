package exarb.fmgamificationlogic.repository;

import exarb.fmgamificationlogic.model.AllAvailableAchievements;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends MongoRepository<AllAvailableAchievements, String> {
    
}

