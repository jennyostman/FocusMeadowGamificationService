package exarb.fmgamificationlogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import exarb.fmgamificationlogic.model.Achievement;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends MongoRepository<Achievement, String> {
    
}

