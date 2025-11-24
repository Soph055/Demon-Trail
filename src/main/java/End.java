import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Class inherits GameScene class and
 * creates all scenes for End(final part of story).
 *
 * @author Sophia Hussain
 */
public class End extends GameScene {

    public TextField finalChoice = new TextField();
    public Button playAgain = new Button();
    public Button playAgainTwo = new Button();

    /**
     * Creates first scene of end using methods from GameScene class along
     * with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene endOne() {

        StackPane box1 = new StackPane();
        basicPane(box1);
        // labels + text
        Label time = new Label("Finally calm and full, you take a second to look at your sister");
        Label skin = new Label("Her skin has turned green and she has lost all her hair");
        Label notice = new Label("You realize shes running out of time and decide to pick up the pace");
        Label reach = new Label("You can see the city lights, but it's still miles away");
        // styles text
        styleText(time, 350);
        styleText(skin, 450);
        styleText(notice, 550);
        styleText(reach, 650);
        smallFont(time);
        smallFont(skin);
        smallFont(notice);
        smallFont(reach);
        // load image
        ImageView girl = image("/images/shootgirl.gif", 100, 150);
        ImageView zomb = image("/images/zombrun.gif", 150, 200);
        // changes image location
        girl.setTranslateY(190);
        zomb.setTranslateY(150);
        zomb.setTranslateX(-200);

        box1.getChildren().addAll(image("/images/citydist.png", 1000, 300), girl, zomb);
        box1.getChildren().addAll(time, skin, notice, reach, spaceText(700));
        Scene sceneOne = new Scene(box1, 1000, 800);
        return sceneOne;
    }

    /**
     * Creates second scene of end using methods from GameScene class along
     * with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene endTwo() {
        StackPane box2 = new StackPane();
        basicPane(box2);
        // labels + text
        Label time = new Label("A few days pass");
        Label arrive = new Label("You arrive at the safe haven");
        Label flyer = new Label("A paper plane flys by you");
        Label notice = new Label("You notice the words CURE written in bold");
        Label follow = new Label("You chase the paper");
        // styles text
        styleText(time, 150);
        styleText(arrive, 225);
        styleText(flyer, 425);
        styleText(notice, 525);
        styleText(follow, 625);
        // load image and move it
        ImageView paper = image("/images/plane.gif", 1000, 200);
        paper.setTranslateY(300);

        box2.getChildren().addAll(image("/images/safehaven.png", 1000, 800), paper);
        box2.getChildren().addAll(time, arrive, flyer, notice, follow, spaceText(700));
        Scene sceneTwo = new Scene(box2, 1000, 800);
        return sceneTwo;
    }

    /**
     * Creates third scene of end using methods from GameScene class along
     * with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene endThree() {

        StackPane box3 = new StackPane();
        basicPane(box3);
        // labels + text
        Label shop = new Label("The paper plane lands inside a coffe shop");
        Label hide = new Label("You tie and hide your sister outside in a nearby allyway to not scare the people");
        Label enter = new Label("You enter the coffe shop, take a seat and begin reading the flyer");
        Label woman = new Label("Soon after a mysterious woman approches you");
        Label offer = new Label("She sees the flyer and offers you the cure if you solve her riddle");
        // styles text
        styleText(shop, 325);
        styleText(hide, 400);
        styleText(enter, 475);
        styleText(woman, 550);
        styleText(offer, 625);
        smallFont(shop);
        smallFont(hide);
        smallFont(enter);
        smallFont(woman);
        smallFont(offer);

        box3.getChildren().add(image("/images/cafe.gif", 1000, 300));
        box3.getChildren().addAll(shop, hide, enter, woman, offer, spaceText(700));
        Scene sceneThree = new Scene(box3, 1000, 800);
        return sceneThree;
    }

    /**
     * Creates option scene of end using methods from GameScene class
     * along with
     * text, images and textfield.
     * 
     * @returns Scene
     */
    public Scene endOption() {

        StackPane box4 = new StackPane();
        basicPane(box4);
        // labels
        Label riddle = new Label("What will you actually find at the end of a rainbow:");
        Label choice = new Label("What is your choice?");
        Label choiceOne = new Label("1 : Pot of gold");
        Label choiceTwo = new Label("2 : Nothing");
        Label choiceThree = new Label("3 : Letter W");
        // styles text
        styleText(riddle, 150);
        styleText(choiceOne, 250);
        choiceOne.setTranslateX(25);
        styleText(choiceTwo, 350);
        styleText(choiceThree, 450);
        styleText(choice, 600);
        // input textfield
        TextField optionOne = limitText(finalChoice);

        box4.getChildren().add(image("/images/border2.png", 800, 100));
        box4.getChildren().addAll(riddle, choice, choiceOne, choiceTwo, choiceThree, optionOne);
        Scene choiceScene = new Scene(box4, 1000, 800);
        return choiceScene;
    }

    /**
     * Creates endBad scene ending for end option using methods from
     * GameScene class
     * along with
     * text, images and restart button.
     * 
     * @returns Scene
     */
    public Scene endBad() {

        StackPane box5 = new StackPane();
        basicPane(box5);
        // labels
        Label wrong = new Label("You were wrong");
        Label zombie = new Label("Unable to find another cure, your sister fully turned");
        Label sad = new Label("The world is dark and dull without her");
        Label why = new Label("You wonder if theres anything left for you in this world");
        // styles text
        styleText(wrong, 350);
        styleText(zombie, 450);
        styleText(sad, 550);
        styleText(why, 650);
        smallFont(wrong);
        smallFont(zombie);
        smallFont(sad);
        smallFont(why);
        // button
        restart(playAgain);
        playAgain.setText("Play Again");

        box5.getChildren().add(image("/images/gameover.gif", 1000, 300));
        box5.getChildren().addAll(wrong, zombie, sad, why, playAgain);
        Scene badEndScene = new Scene(box5, 1000, 800);
        return badEndScene;
    }

    /**
     * Creates endGood scene ending (correct choice) for end option using methods
     * from
     * GameScene class
     * along with
     * text, images and restart button.
     * 
     * @returns Scene
     */
    public Scene endGood() {
        StackPane box7 = new StackPane();
        basicPane(box7);
        // labels
        Label right = new Label("You were right");
        Label cure = new Label("You secured the cure just in time");
        Label happy = new Label("Your sister was treated and made a full recovery ");
        Label peace = new Label("Finally you are at peace");
        // styles text
        styleText(right, 350);
        styleText(cure, 425);
        styleText(happy, 500);
        styleText(peace, 575);
        // button
        restart(playAgainTwo);
        playAgainTwo.setText("Play Again");

        box7.getChildren().add(image("/images/gamefinished.gif", 1000, 300));
        box7.getChildren().addAll(right, cure, happy, peace, playAgainTwo);
        Scene goodEndScene = new Scene(box7, 1000, 800);
        return goodEndScene;
    }

}