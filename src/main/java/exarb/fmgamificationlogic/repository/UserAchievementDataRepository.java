package exarb.fmgamificationlogic.repository;

import exarb.fmgamificationlogic.model.UserAchievementData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAchievementDataRepository extends MongoRepository<UserAchievementData, String> {

    Optional<UserAchievementData> findByUserId(String userId);
    boolean existsByUserId(String userId);
}

