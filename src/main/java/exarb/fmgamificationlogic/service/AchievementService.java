package exarb.fmgamificationlogic.service;

import exarb.fmgamificationlogic.enums.AchievementType;
import exarb.fmgamificationlogic.exceptions.AchievementException;
import exarb.fmgamificationlogic.model.Achievement;
import exarb.fmgamificationlogic.model.AllAvailableAchievements;
import exarb.fmgamificationlogic.repository.AchievementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;

    /**
     * Adds a new achievement to the map that holds all achievements
     * @param achievement an achievement object
     * @return Map<AchievementType, Achievement>
     */
    public Map<AchievementType, Achievement> addAchievement(Achievement achievement) {
        AllAvailableAchievements allAchievements = getFirstAllAvailableAchievements();
        allAchievements.getAchievements().put(achievement.getAchievementType(), achievement);
        return achievementRepository.save(allAchievements).getAchievements();
    }

    /**
     * Gets all achievements
     * @return Map<AchievementType, Achievement>
     */
    public Map<AchievementType, Achievement> getAllAchievements(){
        return getFirstAllAvailableAchievements().getAchievements();
    }

    /**
     * Retrieves the object that holds all achievements
     * @return AllAvailableAchievements
     */
    private AllAvailableAchievements getFirstAllAvailableAchievements(){
        List<AllAvailableAchievements> allAvailableAchievements = achievementRepository.findAll();
        if (allAvailableAchievements.size() > 0){
            return allAvailableAchievements.get(0);
        }
        log.info("Error when getting all the achievements from the database");
        throw new AchievementException("Could not find all achievements");
    }
}
