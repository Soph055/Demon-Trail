import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
* All scenes for the third section of the game (route 3)
*
* @author  Jelena
*/
public class RouteThree extends GameScene{
    GameScene game = new GameScene();
    Timer timer = new Timer(); 

    public Button restart1 = new Button(); // button for 1 bad ending
    public Button restart2 = new Button(); // button for 2nd bad ending

    public static TextField textField = new TextField(); //input for choice screen

/**
 * Initial route 3 scene. Shows the stats of the player before starting the story. Uses methods from GameScene.java.
 * 
 * @return Scene 
 */
    public Scene r3Stats() {
        StackPane sp = new StackPane();
        Scene scene = new Scene(sp, 1000, 800);

        basicPane(sp);

        Label stats = new Label("Stats");
        Label day = new Label(" Days Survived : 12");
        Label distance = new Label("Kilometers Walked : 127");
        Label date = new Label("Date : November 22nd");

        styleText(stats, 100);
        title(stats);
        styleText(day, 300);
        styleText(distance, 400);
        styleText(date, 500);

        sp.getChildren().addAll(spaceText(650), stats, day, distance, date);

        return scene;
    }

/**
 * Creates first scene using text and images. Uses methods from GameScene.java.
 * 
 * @return Scene 
 */
    public Scene r3One() {
        StackPane sp1 = new StackPane();
        Scene scene = new Scene(sp1, 1000, 800);

        basicPane(sp1);

        Label t1 = new Label();
        Label t2 = new Label();
        Label t3 = new Label();
        Label t4 = new Label();

        t1.setText("After getting over the river and around 12 days of travel,");
        t2.setText("you and your sister have gotten quite tired.");
        t3.setText("Your sister is starting to get restless");
        t4.setText("You need to give her food quickly"); 
        
        styleText(t1, 400);
        styleText(t2, 450);
        styleText(t3, 540);
        styleText(t4, 600);
        smallFont(t1);
        smallFont(t2);
        smallFont(t3);
        smallFont(t4);

        sp1.getChildren().add(image("/images/r31.png", 1000, 300));
        sp1.getChildren().addAll(spaceText(650),t1, t2, t3, t4);
        return scene;
    }

/**
 * Creates the choice scene using text and images. Uses methods from GameScene.java. Uses textfield for input logic
 * 
 * @return Scene 
 */
    public Scene r3Choice() {
        StackPane sp2 = new StackPane();
        Scene scene = new Scene(sp2,1000,800);

        basicPane(sp2);

        Label title = new Label(); 
        Label c1 = new Label(); 
        Label c2 = new Label();
        Label c3 = new Label(); 

        title.setText("How will you feed her?");
        c1.setText("1. Feed sister with our food");
        c2.setText("2. Let her free & find her own food");
        c3. setText("3. Don't feed her");

        styleText(title, 100);
        styleText(c1, 300);
        styleText(c2, 400);
        styleText(c3, 500);
        bigFont(title);

        TextField input = limitText(textField);//uses method in GameScene.java
        input.setTranslateY(600);
        
        sp2.getChildren().addAll(title, c1, c2, c3, input); 

        return scene;
    }

/**
 * Creates scene for the feeding choice using text and images. Uses methods from GameScene.java.
 *  Story continues onto the end route after this scene.
 * 
 * @return Scene 
 */
    public Scene r3Feed() {
        StackPane sp3 = new StackPane();
        Scene scene = new Scene(sp3, 1000, 800);

        basicPane(sp3);

        Label t1 = new Label();
        Label t2 = new Label();
        Label t3 = new Label();

        t1.setText("You choose to feed your sister with food you brought.");
        t2.setText("She eats quickly.");
        t3.setText("She is happy and calm");

        styleText(t1, 400);
        styleText(t2, 490);
        styleText(t3, 580);
        smallFont(t1);
        smallFont(t2);
        smallFont(t3);

        sp3.getChildren().add(image("/images/r31.png", 1000, 300));
        sp3.getChildren().addAll(spaceText(650),t1,t2,t3);
        return scene;
    }

/**
 * Creates scene for freeing choice using text and images. Uses methods from GameScene.java.
 *  Adds restart button that will change scene back to start.
 * 
 * @return Scene 
 */
    public Scene r3Free() {
        StackPane sp4 = new StackPane();
        Scene scene = new Scene(sp4, 1000, 800);

        basicPane(sp4); 

        Label t1 = new Label(); 
        Label t2 = new Label(); 
        Label t3 = new Label(); 

        t1.setText("You let your sister out of her cage slowly.");
        t2.setText("She runs far into the woods");
        t3.setText("After several hours she doesn't come back");

        styleText(t1, 400);
        styleText(t2, 490);
        styleText(t3, 580);
        smallFont(t1); 
        smallFont(t2);
        smallFont(t3);

        Image pic = new Image("/images/cage.png");
        ImageView cage = new ImageView(pic);
        cage.setTranslateX(-90);
        cage.setTranslateY(65);
        cage.setFitWidth(300);
        cage.setFitHeight(255);

        sp4.getChildren().add(image("/images/r31.png", 1000, 300));
        sp4.getChildren().add(cage);
        sp4.getChildren().addAll(t1, t2, t3, restart(restart2));

        return scene;
    }

/**
 * Creates scene for starving choice using text and images. Uses methods from GameScene.java.
 *  Adds restart button that will change scene back to start.
 * 
 * @return Scene 
 */
    public Scene r3Starve() {
        StackPane sp5 = new StackPane();
        Scene scene = new Scene(sp5, 1000, 800); 

        basicPane(sp5); 

        Label t1 = new Label(); 
        Label t2 = new Label(); 
        Label t3 = new Label(); 

        t1.setText("You don't let your sister out.");
        t2.setText("After a few hours resting she gets extremely resteless.");
        t3.setText("She escapes from her cage and eats you!");
        
        styleText(t1, 400);
        styleText(t2, 490);
        styleText(t3, 580);
        smallFont(t1);
        smallFont(t2);
        smallFont(t3);

        Image pic = new Image("/images/cage.png");
        ImageView cage = new ImageView(pic);
        cage.setTranslateX(-90);
        cage.setTranslateY(65);
        cage.setFitWidth(300);
        cage.setFitHeight(255);

        sp5.getChildren().add(image("/images/r31.png", 1000, 300));
        sp5.getChildren().add(cage);

        sp5.getChildren().addAll(t1,t2,t3, restart(restart1));

        return scene;
    }
    
}
