package com.sogeti.SoSenseiPsyche;

import com.sogeti.SoSenseiPsyche.javafx.GameBoardController;
import com.sogeti.SoSenseiPsyche.model.Game;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class SoSenseiPsycheApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SoSenseiPsycheApplication.class, args);
//
//        Game game = new Game();
//        game.startGame();
//    }
//}

@SpringBootApplication
public class SoSenseiPsycheApplication {

    public static void main(String[] args) {
        Application.launch(GameBoardController.class, args);
    }
}
