package exarb.fmgamificationlogic.service;

import exarb.fmgamificationlogic.model.Achievement;
import exarb.fmgamificationlogic.repository.AchievementRepository;
import org.springframework.stereotype.Service;


@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    // Använt för att testa db
    public Achievement addAchievement(Achievement achievement){
        return achievementRepository.save(achievement);
    }

    /**
     * Method that checks if a user will get an achievement.
     * @param userId
     * @param timerCountSessionId
     */
    // TODO: Hur mycket ska stå i javadocs här egentligen?
    public void checkIfAchievement(String userId, String timerCountSessionId){
        // Skriva ut eventet:
        System.out.println("Eventet:\nuserId: " + userId + " timerCountSessionId: " + timerCountSessionId);

        // Här ska gamelogic-servicen anropas


    }


}
