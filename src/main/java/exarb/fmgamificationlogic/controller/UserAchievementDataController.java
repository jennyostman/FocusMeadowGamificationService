package exarb.fmgamificationlogic.controller;

import exarb.fmgamificationlogic.model.UserAchievementData;
import exarb.fmgamificationlogic.service.UserAchievementDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/userachievements", produces = APPLICATION_JSON_VALUE)

public class UserAchievementDataController {

    private final UserAchievementDataService userAchievementDataService;

    /**
     * Gets a users achievements
     * @param userId a users id
     * @return ResponseEntity<UserAchievementData>
     */
    @GetMapping(value = ("/user/{userId}"))
    public ResponseEntity<UserAchievementData> getAchievementsForUser(@PathVariable String userId){
        return ResponseEntity.ok().body(userAchievementDataService.getAchievementsForUser(userId));
    }

}
