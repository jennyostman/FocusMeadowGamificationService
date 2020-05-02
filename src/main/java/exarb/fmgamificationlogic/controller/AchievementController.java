package exarb.fmgamificationlogic.controller;

import exarb.fmgamificationlogic.model.Achievement;
import exarb.fmgamificationlogic.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/achievements", produces = APPLICATION_JSON_VALUE)
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    // Använt för att testa db
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity addAchievement(@RequestBody Achievement achievement){
        return ResponseEntity.ok().body(achievementService.addAchievement(achievement));
    }

}
