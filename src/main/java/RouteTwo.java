import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Class inherits GameScene class and
 * creates all scenes for RouteTwo.
 *
 * @author Sophia Hussain
 */
public class RouteTwo extends GameScene {
    // public textField
    public TextField textFieldOne = new TextField();
    public TextField textFieldTwo = new TextField();

    // public buttons
    public Button restartOne = new Button();
    public Button restartTwo = new Button();
    public Button restartThree = new Button();
    public Button restartFour = new Button();

    /**
     * Creates first scene of route two using methods from GameScene class along
     * with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene storyTwoOne() {

        StackPane box1 = new StackPane();
        basicPane(box1);
        // labels
        Label stats = new Label("Stats");
        Label day = new Label(" days survived : 5");
        Label mile = new Label("kilometers walked : 51");
        Label date = new Label("Date : November 15th");
        // styles text
        styleText(stats, 100);
        title(stats);
        styleText(day, 300);
        styleText(mile, 400);
        styleText(date, 500);

        box1.getChildren().addAll(spaceText(700), stats, day, mile, date);
        Scene sceneOne = new Scene(box1, 1000, 800);
        return sceneOne;
    }

    /**
     * Creates second scene of route two using methods from GameScene class along
     * with
     * text and images.Also creates animation to create many days passing effect by
     * cycling through
     * day and night images.
     * 
     * @returns Scene
     */
    public Scene storyTwoTwo() {

        StackPane box2 = new StackPane();
        basicPane(box2);
        // labels
        Label travel = new Label("Couple of days pass");
        Label food = new Label("70% of rations have been depleted");
        Label gas = new Label("Luckily you see a gas station in the distance");
        // styles text
        styleText(travel, 350);
        styleText(food, 450);
        styleText(gas, 550);
        // load images
        ImageView sun = image("\\images\\day.gif", 1000, 300);
        ImageView moon = image("\\images\\night.gif", 1000, 300);
        // Animating night and day images
        Group daysPass;
        daysPass = new Group(sun);

        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(700),
                (ActionEvent event) -> {
                    daysPass.getChildren().setAll(moon);
                }));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1800),
                (ActionEvent event) -> {
                    daysPass.getChildren().setAll(sun);
                }));

        t.play();

        box2.getChildren().addAll(daysPass, spaceText(700), travel, food, gas);
        Scene sceneTwo = new Scene(box2, 1000, 800);
        return sceneTwo;
    }

    /**
     * Creates third scene of route two using methods from GameScene class along
     * with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene storyTwoThree() {

        StackPane box3 = new StackPane();
        basicPane(box3);
        // label
        Label gasStation = new Label("you arrive at the gas station");
        // styles text
        styleText(gasStation, 390);
        // loading image and moving it
        ImageView border = image("\\images\\border.png", 615, 100);
        border.setTranslateY(370);

        box3.getChildren().add(image("\\images\\station.gif", 1000, 800));
        box3.getChildren().addAll(border, gasStation, spaceText(700));
        Scene sceneThree = new Scene(box3, 1000, 800);
        return sceneThree;
    }

    /**
     * Creates first option scene of route two using methods from GameScene class
     * along with
     * text, images and textfield.
     * 
     * @returns Scene
     */
    public Scene optionTwoOne() {

        StackPane box4 = new StackPane();
        basicPane(box4);
        // labels
        Label bag = new Label("You may carry one item :");
        Label choice = new Label("What is your choice?");
        Label choiceOne = new Label("1 : Gas");
        Label choiceTwo = new Label("2 : Food and Water");
        Label choiceThree = new Label("3 : Medical Supplies");
        // styles text
        styleText(bag, 150);
        styleText(choiceOne, 250);
        choiceOne.setTranslateX(-115);
        styleText(choiceTwo, 350);
        styleText(choiceThree, 450);
        styleText(choice, 600);
        // input textfield
        limitText(textFieldOne);

        box4.getChildren().add(image("\\images\\border2.png", 800, 100));
        box4.getChildren().addAll(bag, choice, choiceOne, choiceTwo, choiceThree, textFieldOne);
        Scene optionOneScene = new Scene(box4, 1000, 800);
        return optionOneScene;
    }

    /**
     * Creates end gas ending scene for option one using methods from GameScene
     * class along
     * with
     * text, images and restart buttons.
     * 
     * @returns Scene
     */
    public Scene endGas() { // gas ending for option 1

        StackPane box5 = new StackPane();
        basicPane(box5);
        // labels
        Label car = new Label("You approach an abandoned car");
        Label gasUse = new Label("You pour gas into the car");
        Label start = new Label("You find the keys and start the car");
        Label explode = new Label("Something went wrong... the car explodes");
        Label death = new Label("you have died");
        // styles text
        styleText(car, 100);
        styleText(gasUse, 200);
        styleText(start, 300);
        styleText(explode, 400);
        styleText(death, 500);

        box5.getChildren().add(image("\\images\\cargas.gif", 1000, 800));
        box5.getChildren().addAll(car, gasUse, start, explode, death, restart(restartOne));

        Scene endGasScene = new Scene(box5, 1000, 800);
        return endGasScene;

    }

    /**
     * Creates endMed scene part one ending for option one using methods from
     * GameScene class
     * along with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene endMedOne() { // medkit part 1 ending for option 1
        StackPane box6 = new StackPane();
        basicPane(box6);
        // labels
        Label travel = new Label("You hike for days... nothing but mountains in sight");
        Label noFood = new Label("You have used up all your food and water");
        // styles text
        styleText(travel, 400);
        styleText(noFood, 500);

        box6.getChildren().add(image("\\images\\mountain.png", 1000, 300));
        box6.getChildren().addAll(travel, noFood, spaceText(700));

        Scene medOneScene = new Scene(box6, 1000, 800);
        return medOneScene;

    }

    /**
     * Creates endMed scene part two ending for option one using methods from
     * GameScene class
     * along with
     * text, images and restart button.
     * 
     * @returns Scene
     */
    public Scene endMedTwo() { // medkit ending part 2 for option 1

        StackPane box7 = new StackPane();
        basicPane(box7);
        // labels
        Label faint = new Label("You pass out due to malnutrition");
        Label eaten = new Label("Suddenly a sharp pain wakes you up");
        Label scream = new Label("Your sister broke free of her ropes ");
        Label hunger = new Label("she is eating you");
        Label consume = new Label("You have been consumed");
        // styles text
        styleText(faint, 325);
        styleText(eaten, 400);
        styleText(scream, 475);
        styleText(hunger, 550);
        styleText(consume, 625);

        box7.getChildren().add(image("\\images\\grave.png", 200, 300));
        box7.getChildren().addAll(faint, eaten, scream, hunger, consume, restart(restartTwo));

        Scene medTwoScene = new Scene(box7, 1000, 800);
        return medTwoScene;

    }

    /**
     * Creates food choice scene(correct choice) for option one using methods from
     * GameScene class along with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene foodChoice() { // correct option to continue game

        StackPane box8 = new StackPane();
        basicPane(box8);
        // labels
        Label traveling = new Label("You continue walking at a grueling pace");
        Label tired = new Label("You are exhausted and stop to rest ");
        Label eat = new Label("You eat your food and begin walking again");
        // styles text
        styleText(traveling, 400);
        styleText(tired, 500);
        styleText(eat, 600);

        box8.getChildren().add(image("\\images\\camp.png", 1000, 300));
        box8.getChildren().addAll(traveling, tired, eat, spaceText(700));

        Scene foodOptionScene = new Scene(box8, 1000, 800);

        return foodOptionScene;
    }

    /**
     * Creates fourth scene of route two using methods from GameScene class along
     * with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene storyTwoFour() {

        StackPane box9 = new StackPane();
        basicPane(box9);
        // labels
        Label daysPass = new Label("Couple of days pass");
        Label arrive = new Label("You arrive at a river");
        Label problem = new Label("The river stretches for miles");
        Label cross = new Label("You must cross the river quickly");
        // styles text
        styleText(daysPass, 350);
        styleText(arrive, 425);
        styleText(problem, 500);
        styleText(cross, 575);

        box9.getChildren().add(image("\\images\\river.jpg", 1000, 300));
        box9.getChildren().addAll(daysPass, arrive, problem, cross, spaceText(700));

        Scene sceneFour = new Scene(box9, 1000, 800);
        return sceneFour;

    }

    /**
     * Creates second option scene of route two using methods from GameScene class
     * along with
     * text, images and textfield.
     * 
     * @returns Scene
     */
    public Scene optionTwoTwo() {

        StackPane box10 = new StackPane();
        basicPane(box10);
        // labels
        Label swim = new Label("How will you cross?");
        Label choice = new Label("What is your choice?");
        Label choiceOne = new Label("1 : Swim across it");
        Label choiceTwo = new Label("2 : Travel around it");
        Label choiceThree = new Label("3 : Tightrope walk across");
        // styles text
        styleText(swim, 150);
        styleText(choiceOne, 250);
        choiceOne.setTranslateX(-70);
        styleText(choiceTwo, 350);
        choiceTwo.setTranslateX(-55);
        styleText(choiceThree, 450);
        styleText(choice, 600);
        choice.setTranslateX(-40);
        // input textfield
        limitText(textFieldTwo);
        textFieldTwo.setMaxSize(100, 10);
        textFieldTwo.setTranslateY(700);

        box10.getChildren().add(image("\\images\\border2.png", 800, 100));
        box10.getChildren().addAll(swim, choice, choiceOne, choiceTwo, choiceThree, textFieldTwo);
        Scene optionTwoScene = new Scene(box10, 1000, 800);
        return optionTwoScene;
    }

    /**
     * Creates end travel ending for option two using methods from GameScene class
     * along with
     * text, images and restart button.
     * 
     * @returns Scene
     */
    public Scene endTravel() {
        StackPane box11 = new StackPane();
        basicPane(box11);
        // labels
        Label traveling = new Label("You take a detour through the mountains");
        Label risky = new Label("The path is dangerous and long");
        Label slip = new Label("You are half way across when you slip on a rock");
        Label head = new Label("you fall from 50 feet and hit your head");
        Label dead = new Label("You have died");
        // styles text
        styleText(traveling, 350);
        styleText(risky, 425);
        styleText(slip, 500);
        styleText(head, 575);
        styleText(dead, 650);

        box11.getChildren().add(image("\\images\\bodyoutline.png", 1000, 300));
        box11.getChildren().addAll(traveling, risky, slip, head, dead, restart(restartThree));

        Scene travelOptionScene = new Scene(box11, 1000, 800);
        return travelOptionScene;
    }

    /**
     * Creates end rope ending for option two using methods from GameScene class
     * along with
     * text, images and restart button.
     * 
     * @returns Scene
     */
    public Scene endRope() {

        StackPane box12 = new StackPane();
        basicPane(box12);
        // labels
        Label toss = new Label("You make a loop with the rope and throw it across on a tree");
        Label tree = new Label("You check if it is secure and tie it to another tree");
        Label walk = new Label("You begin walking the tight rope");
        Label fall = new Label("You lose your balance and fall into the river");
        Label drown = new Label("Your sister distraught from the water, scratches you");
        Label zomb = new Label("You give up and drown as you will turn into a zombie soon");
        // styles text
        styleText(toss, 320);
        styleText(tree, 380);
        styleText(walk, 440);
        styleText(fall, 500);
        styleText(drown, 560);
        styleText(zomb, 620);
        smallFont(toss);
        smallFont(tree);
        smallFont(walk);
        smallFont(fall);
        smallFont(drown);
        smallFont(zomb);

        box12.getChildren().add(image("\\images\\drowning.jpg", 1000, 300));
        box12.getChildren().addAll(toss, tree, walk, fall, drown, zomb, restart(restartFour));

        Scene ropeOptionScene = new Scene(box12, 1000, 800);
        return ropeOptionScene;
    }

    /**
     * Creates swim choice scene (correct choice) for option two using methods from
     * GameScene class
     * along with
     * text and images.
     * 
     * @returns Scene
     */
    public Scene swimChoice() { // correct choice
        StackPane box13 = new StackPane();
        basicPane(box13);
        // labels
        Label safety = new Label("You blindfold and cover your sisters mouth");
        Label tie = new Label("You tie her body with yours and begin swimming");
        Label swim = new Label("Progress is slow but steady");
        Label river = new Label("You make it safely across the river");
        // styles text
        styleText(safety, 350);
        styleText(tie, 425);
        styleText(swim, 500);
        styleText(river, 575);

        box13.getChildren().add(image("\\images\\deepriver.jpg", 1000, 300));
        box13.getChildren().addAll(safety, tie, swim, river, spaceText(700));

        Scene swimOptionScene = new Scene(box13, 1000, 800);
        return swimOptionScene;
    }

}