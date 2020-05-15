package exarb.fmgamificationlogic.controller;

import exarb.fmgamificationlogic.enums.AchievementType;
import exarb.fmgamificationlogic.model.Achievement;
import exarb.fmgamificationlogic.service.AchievementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/achievements", produces = APPLICATION_JSON_VALUE)
public class AchievementController {

    private final AchievementService achievementService;


    /**
     * To add a new achievement to the map that holds all achievements
     * @param achievement an achievement object
     * @return Map<AchievementType, Achievement>
     */
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<AchievementType, Achievement>> addAchievement(@RequestBody Achievement achievement){
        return ResponseEntity.ok().body(achievementService.addAchievement(achievement));
    }

    /**
     * Gets all achievements
     * @return Map<AchievementType, Achievement>
     */
    @GetMapping(value = "/all")
    public ResponseEntity<Map<AchievementType, Achievement>> getAllAchievements(){
        return ResponseEntity.ok().body(achievementService.getAllAchievements());
    }

}
