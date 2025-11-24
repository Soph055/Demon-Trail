import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
* All scenes for the first section of the game (intro)
*
* @author  Jelena
*/
public class IntroScene extends GameScene {

    GameScene game = new GameScene();
    Timer timer = new Timer();

    public Button restart = new Button(); // buttons to restart after choice
    public Button restart2 = new Button();

    public static TextField t = new TextField(); //text field for input

/**
 * Creates first scene using text and images. Uses methods from GameScene.java.
 * 
 * @return Scene 
 */
    public Scene introOne() {
        StackPane sp1 = new StackPane(); //using stackpane for multiple images

        //creates all text labels needed
        Label inTwo1 = new Label();
        Label inTwo2 = new Label();
        Label inTwo3 = new Label();
        Label inTwo4 = new Label();

        //sets text
        inTwo1.setText("It's November 10th, we've been in the apocalypse for 3 years now.");
        inTwo2.setText("An evil scientists released the zombie plague which infected over half the city.");
        inTwo3.setText("My sister and I barely survived the first year before she started getting rebellious.");
        inTwo4.setText("One day she went out into the city on her own and got bit...");

        //styling using methods from GameScene.java
        basicPane(sp1);
        styleText(inTwo1, 350);
        styleText(inTwo2, 390);
        styleText(inTwo3, 430);
        styleText(inTwo4, 470);
        smallFont(inTwo1);
        smallFont(inTwo2);
        smallFont(inTwo3);
        smallFont(inTwo4);

        //puts everything on the screen
        sp1.getChildren().add(image("/images/city.gif", 1000, 300));
        sp1.getChildren().addAll(spaceText(650), inTwo1, inTwo2, inTwo3, inTwo4);

        Scene scene1 = new Scene(sp1, 1000, 800);

        return scene1;

    }

/**
 * Creates second scene using text and images. Uses methods from GameScene.java.
 * 
 * @return Scene 
 */
    public Scene introTwo() {
        StackPane sp2 = new StackPane();
        Scene scene = new Scene(sp2, 1000, 800);

        basicPane(sp2);
        
        Label inTwo1 = new Label();
        Label inTwo2 = new Label();
        Label inTwo3 = new Label();
        Label inTwo4 = new Label();

        inTwo1.setText("I went out that night and spent the whole day looking for her.");
        inTwo2.setText("When it hit 12 in the morning, I began to make my way back home when suddenly...");
        inTwo3.setText("I found her!");
        //long pause
        inTwo4.setText("and she was a zombie...");

        basicPane(sp2);
        styleText(inTwo1, 350);
        styleText(inTwo2, 390);
        styleText(inTwo3, 430);
        styleText(inTwo4, 470);
        smallFont(inTwo1);
        smallFont(inTwo2);
        smallFont(inTwo3);
        smallFont(inTwo4);

        sp2.getChildren().addAll(inTwo1, inTwo2, inTwo3, inTwo4, spaceText(650), image("/images/zombie sister.png", 400, 300), image("/images/red city.gif", 1000, 300));


        return scene;
    }

/**
 * Creates third scene using text and images. Uses methods from GameScene.java.
 * 
 * @return Scene 
 */
    public Scene introThree() {

        StackPane sp3 = new StackPane(); 
        Scene scene = new Scene(sp3, 1000, 800);

        Label inThree1 = new Label();
        Label inThree2 = new Label();
        Label inThree3 = new Label();
        Label inThree4 = new Label();
        Label inThree5 = new Label(); 

        inThree1.setText("Today, during my daily task of trying to fix the radio,");
        inThree2.setText("I finally managed to get a connection!");
        inThree3.setText("I heard static and then...");
        inThree4.setText("'...come to the safe haven...the stars will lead the way...'");
        inThree5.setText("So we started to pack our bags.");

        basicPane(sp3);
        styleText(inThree1, 350);
        styleText(inThree2, 390);
        styleText(inThree3, 430);
        styleText(inThree4, 470);
        styleText(inThree5, 510);
        smallFont(inThree1);
        smallFont(inThree2);
        smallFont(inThree3);
        smallFont(inThree4);
        smallFont(inThree5); 

        sp3.getChildren().add(image("/images/radio.jpg", 1000, 300));
        sp3.getChildren().addAll(spaceText(650),inThree1, inThree2, inThree3, inThree4, inThree5);

        return scene;
    }

/**
 * Creates a scene using text and images. Uses methods from GameScene.java. Uses text field for input logic.
 * 
 * @return Scene 
 */
    public Scene introFourChoice1() {
        StackPane sp4 = new StackPane(); 
        Scene scene = new Scene(sp4, 1000, 800);


        Label title1 = new Label(); 
        Label title2 = new Label();
        Label c1 = new Label(); 
        Label c2 = new Label();
        Label c3 = new Label(); 

        title1.setText("You can only fit one");
        title2.setText("more item in you inventory:");
        c1.setText("1. Med kit");
        c2.setText("2. Gas");
        c3.setText("3. Extra Water");

        basicPane(sp4);
        styleText(title1, 100);
        styleText(title2, 150);
        styleText(c1, 300);
        styleText(c2, 400);
        styleText(c3, 500);
        bigFont(title1);
        bigFont(title2);
        bigFont(c1);
        bigFont(c2);
        bigFont(c3);

        TextField input = limitText(t);
        input.setTranslateY(600);

        sp4.getChildren().addAll(title1, title2, c1, c2, c3, input);

        return scene;
    }

/**
 * Creates scene for gas choice using text and images. Uses methods from GameScene.java.
 *  Adds restart button that will change scene back to start.
 * 
 * @return Scene 
 */
    public Scene inChoice1Gas() {
        StackPane sp5 = new StackPane();
        Scene scene = new Scene(sp5, 1000, 800);

        basicPane(sp5);

        ImageView border = new ImageView("/images/border.png");
        border.setScaleY(0.5);
        //border.setTranslateY(100);

        Label text1 = new Label(); 
        Label text2 = new Label(); 

        text1.setText("We chose to use the car since we brought gas...");
        text2.setText("The brakes stopped working and we crashed.");
        
        styleText(text1, 70);
        styleText(text2, 110);
        smallFont(text1);
        smallFont(text2);
        text1.setStyle("-fx-text-fill:black;");
        text2.setStyle("-fx-text-fill:black;");

        sp5.getChildren().add(image("/images/crash.gif", 1000, 800));
        sp5.getChildren().add(border);
        sp5.getChildren().addAll(text1, text2, restart(restart));

        

        return scene;
    }

/**
 * Creates scene for medkit or water choice using text and images. Uses methods from GameScene.java.
 * 
 * @return Scene 
 */
    public Scene inChoice1MedWater() {
        StackPane sp6 = new StackPane(); 
        Scene scene = new Scene(sp6, 1000, 800); 

        basicPane(sp6);

        Label text1 = new Label();
        Label text2 = new Label();
        Label text3 = new Label();

        text1.setText("After a few days of walking, we ran into a problem.");
        text2.setText("Some zombies came out of hiding and started attacking us!");
        text3.setText("Two strangers came and helped us fight them off");

        styleText(text1, 400);
        styleText(text2, 500);
        styleText(text3, 600);
        smallFont(text1);
        smallFont(text2);
        smallFont(text3);

        sp6.getChildren().add(image("/images/zombie attack.gif", 1000, 300));
        sp6.getChildren().addAll(spaceText(650),text1, text2, text3);

        return scene;
    }

/**
 * Creates scene for water choice using text and images. Uses methods from GameScene.java.
 *  Adds restart button that will change scene back to start.
 * 
 * @return Scene 
 */
    public Scene inChoice1Death() {
        StackPane sp7 = new StackPane();
        Scene scene = new Scene(sp7, 1000, 800); 

        basicPane(sp7); 

        Label text1 = new Label();
        Label text2 = new Label(); 

        text1.setText("You died.");
        text2.setText("You did not bring any medical materials.");

        styleText(text1, 400);
        styleText(text2, 500);
        smallFont(text1);
        smallFont(text2);

        sp7.getChildren().add(image("/images/graveyard1.png", 1000, 300));
        sp7.getChildren().addAll(text1, text2, restart(restart2));



        return scene;
    }

/**
 * Creates scene for med kit choice using text and images. Uses methods from GameScene.java.
 * After this choice, you move onto route 2.
 *  
 * 
 * @return Scene 
 */
    public Scene inChoice1Pass() {
        StackPane sp8 = new StackPane();
        Scene scene = new Scene(sp8, 1000, 800);

        basicPane(sp8);

        Label text1 = new Label();
        Label text2 = new Label();

        text1.setText("You used your med kit and healed your wounds");
        text2.setText("You found shelter for the night.");

        styleText(text1, 400);
        styleText(text2, 500);
        smallFont(text1);
        smallFont(text2);

        sp8.getChildren().add(image("/images/shelter.png", 1000, 300));
        sp8.getChildren().addAll(spaceText(650),text1,text2); 

        return scene;
    }
    
}
