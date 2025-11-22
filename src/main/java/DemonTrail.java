import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main class. Controls input and scene changes. Uses methods from IntroScene,
 * RouteTwo, RouteThree, End, and GameScene.
 *
 * @author Sophia & Jelena
 */
public class DemonTrail extends Application {
    Stage window;
    GameScene game = new GameScene();

    // Intro scenes
    IntroScene intro = new IntroScene();
    Scene introOne = intro.introOne();
    Scene introTwo = intro.introTwo();
    Scene introThree = intro.introThree();
    Scene introFourChoice1 = intro.introFourChoice1();
    Scene inChoice1Gas = intro.inChoice1Gas();
    Scene inChoice1MedWater = intro.inChoice1MedWater();
    Scene inChoice1Death = intro.inChoice1Death();
    Scene inChoice1Pass = intro.inChoice1Pass();
    // textfield for input
    TextField introInput = IntroScene.t;
    Boolean choiceMedWaterEnd = false;

    // Route 2 scenes
    RouteTwo rTwo = new RouteTwo();
    Scene rTwoOne = rTwo.storyTwoOne();
    Scene rTwoTwo = rTwo.storyTwoTwo();
    Scene rTwoThree = rTwo.storyTwoThree();
    // choice 1 scene + endings
    Scene rTwoChoiceOne = rTwo.optionTwoOne();
    Scene rTwoEndGas = rTwo.endGas();
    Scene rTwoEndMed = rTwo.endMedOne();
    Scene rTwoEndMedTwo = rTwo.endMedTwo();
    Scene rTwoFoodOption = rTwo.foodChoice();
    // Route 2 scenes continued from food option to ending
    Scene rTwoFour = rTwo.storyTwoFour();
    Scene rTwoChoiceTwo = rTwo.optionTwoTwo();
    Scene rTwoEndTravel = rTwo.endTravel();
    Scene rTwoEndRope = rTwo.endRope();
    Scene rTwoFinal = rTwo.swimChoice();
    // Route 2 textfields
    TextField rTwoInputOne = rTwo.textFieldOne;
    TextField rTwoInputTwo = rTwo.textFieldTwo;

    // Route 3 Scenes
    RouteThree r3 = new RouteThree();
    Scene r3Stats = r3.r3Stats();
    Scene r3One = r3.r3One();
    Scene r3Choice = r3.r3Choice();
    Scene r3Feed = r3.r3Feed();
    Scene r3Free = r3.r3Free();
    Scene r3Starve = r3.r3Starve();
    // route 3 text fields
    TextField r3Input = RouteThree.textField;

    // ending scenes
    End end = new End();
    Scene endOne = end.endOne();
    Scene endTwo = end.endTwo();
    Scene endThree = end.endThree();
    Scene endChoice = end.endOption();
    Scene endBad = end.endBad();
    Scene endGood = end.endGood();
    // end textfield
    TextField endInput = end.finalChoice;

    // intro scenes array
    Scene[] introScenes = { introOne, introTwo, introThree, introFourChoice1, inChoice1MedWater, inChoice1Pass };
    Scene[] waterEnd = { inChoice1MedWater, inChoice1Death };

    // rTwo Scenes array
    Scene[] rTwoScenes = { rTwoOne, rTwoTwo, rTwoThree, rTwoChoiceOne, rTwoFoodOption, rTwoFour, rTwoChoiceTwo,
            rTwoFinal };
    Scene[] rTwoMedScenes = { rTwoEndMed, rTwoEndMedTwo };

    // rThree scenes array
    Scene[] rThreeScenes = { r3Stats, r3One, r3Choice, r3Feed };

    // end scenes array
    Scene[] endScenes = { endOne, endTwo, endThree, endChoice, endGood };

    // restart button array (for death before final ending, plays again from intro
    // one scene)
    Button[] restartButtons = { intro.restart, intro.restart2, rTwo.restartOne, rTwo.restartTwo,
            rTwo.restartThree, rTwo.restartFour, r3.restart1, r3.restart2 };

    // play again button array (for when reached one of the final endings, plays
    // again from
    // start screen)
    Button[] playAgain = { end.playAgain, end.playAgainTwo };

    // input text field array
    TextField[] inputFields = { introInput, rTwoInputOne, rTwoInputTwo, r3Input, endInput, };

    private int n = 0; // intro scene # var
    private int m = 0; // route 2 scene # var
    private int c = 0; // route 2 medscene #var
    private int k = 0; // route 3 scene # var
    private int d = 0; // end scene # var

    private int score = 1000; // initial score starts off at 1000
    private int deaths = 0; // initial deaths

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        // calls route methods which go through each scene in respective route and then
        // switches to next route.
        introNextScene();
        routeTwoNextScene();
        routeThreeNextScene();
        endNextScene();

        // button event, if restart button clicked
        for (int j = 0; j < restartButtons.length; j++) {
            restartButtons[j].setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    deaths++; // increases deaths by 1
                    // resets scene counter to 0
                    n = 0;
                    m = 0;
                    c = 0;
                    k = 0;
                    d = 0;
                    introInput.setText(""); // clears all inputs
                    rTwoInputOne.setText("");
                    rTwoInputTwo.setText("");
                    r3Input.setText("");
                    endInput.setText("");
                    window.setScene(introOne);

                }

            });
        }
        // button event if play again button clicked
        for (int i = 0; i < playAgain.length; i++) {
            playAgain[i].setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    window.setScene(startScreen()); // sets screen to start screen

                }

            });
        }

        // inputFields array event
        for (int j = 0; j < inputFields.length; j++) {
            inputFields[j].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(javafx.scene.input.KeyEvent key) {
                    if (key.getCode().equals(KeyCode.ENTER)) { // if enter pressed

                        if (key.getSource() == introInput) { // if on intro screen choice
                            if (introInput.getText().equals("1")) { // if option 1 selected(medkit, correct option)
                                n++;// increases scene counter
                                window.setScene(inChoice1MedWater);
                                choiceMedWaterEnd = false; // med kit end
                            } else if (introInput.getText().equals("2")) {// if option 2 selected
                                window.setScene(inChoice1Gas); // gas ending
                            } else if (introInput.getText().equals("3")) {// if option 3 selected (water)
                                window.setScene(inChoice1MedWater);
                                choiceMedWaterEnd = true; // water ending
                            }
                        }

                        else if (key.getSource() == rTwoInputOne) { // Route 2 choice 1
                            if (rTwoInputOne.getText().equals("1")) { // if option 1 selected
                                window.setScene(rTwoEndGas); // gas ending
                            } else if (rTwoInputOne.getText().equals("2")) {// if option 2 selected(correct option)
                                m++; // increases scene counter
                                window.setScene(rTwoScenes[m]);
                            } else if (rTwoInputOne.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwoEndMed); // med ending
                            }
                        }

                        else if (key.getSource() == rTwoInputTwo) { // Route 2 choice 2
                            if (rTwoInputTwo.getText().equals("1")) {// if option 1 selected(correct choice)
                                m++; // increases scene counter
                                window.setScene(rTwoScenes[m]);
                            } else if (rTwoInputTwo.getText().equals("2")) { // if option 2 selected
                                window.setScene(rTwoEndTravel); // travel ending
                            } else if (rTwoInputTwo.getText().equals("3")) {// if option 3 selected
                                window.setScene(rTwoEndRope); // rope ending
                            }
                        }

                        else if (key.getSource() == r3Input) { // Route 3 choice
                            if (r3Input.getText().equals("1")) {// CORRECT OPTION
                                k++; // increases scene counter
                                window.setScene(rThreeScenes[k]);
                            } else if (r3Input.getText().equals("2")) {// if option 2 selected
                                window.setScene(r3Free); // free ending
                            } else if (r3Input.getText().equals("3")) {// if option 3 selected
                                window.setScene(r3Starve); // starve ending

                            }
                        } else if (key.getSource() == endInput) { // end choice
                            if (endInput.getText().equals("1") || endInput.getText().equals("2")) {// if option 1 or 2
                                                                                                   // selected
                                window.setScene(endBad);// bad final ending
                            } else if (endInput.getText().equals("3")) {// if option 3 selected(correct choice)
                                d++; // increases scene counter
                                window.setScene(endScenes[d]); // good ending
                            }
                            writeFile();// writes score

                        }
                    }

                }
            });
        }

        window.setScene(startScreen()); // displays start screen
        window.setResizable(false);
        window.show();
    }

    /**
     * Controls input for the intro scenes. Input from space bar to switch from
     * scene to scene.
     */
    private void introNextScene() {
        for (int i = 0; i < introScenes.length; i++) {

            introScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) { // if space is pressed, move to the next scene in the
                                                               // array
                        if (n < introScenes.length - 1) { // if the array item we are on isn't the last scene,
                            n++; // move to the next array item
                            window.setScene(introScenes[n]);// sets the scene to that array item
                        } else {
                            window.setScene(rTwoScenes[m]); // if the array item is the last scene, then move to route
                                                            // two scenes.

                        }
                    }

                }
            });
        }

        // water ending has multiple scenes
        for (int i = 0; i < waterEnd.length - 1; i++) {
            waterEnd[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        if (choiceMedWaterEnd) {// if the user chose water out of water and medkit
                            window.setScene(waterEnd[1]); // the water end will play
                        } else {
                            n++;
                            window.setScene(introScenes[n]); // or it will keep going through the introscene array to
                                                             // reach the medkit ending (pass ending)
                        }
                    }

                }

            });
        }
    }

    /**
     * Controls input for route two scenes and displays special two scene med
     * ending if option 3 selected. When space bar is pressed,
     * moves to next scene in route two array. If on
     * last scene and space bar clicked, story continues from scene 1 of
     * route three.
     */
    private void routeTwoNextScene() {
        for (int i = 0; i < rTwoScenes.length; i++) {
            rTwoScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) { // space spressed
                        if (m < rTwoScenes.length - 1) {
                            m++; // increases scene counter
                            window.setScene(rTwoScenes[m]);
                        } else {
                            window.setScene(rThreeScenes[k]); // sets screen to route three

                        }
                    }

                }
            });
        }

        // med ending scenes space bar pressed event (if option 3 selected)
        for (int i = 0; i < rTwoMedScenes.length - 1; i++) {
            rTwoMedScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        c++;// increases scene counter
                        window.setScene(rTwoMedScenes[c]);
                    }

                }

            });
        }
    }

    /**
     * Controls input for route three scenes. When space bar is pressed,
     * moves to next scene in route three array. If on
     * last scene and space bar clicked, story continues from scene 1 of
     * end route.
     */
    private void routeThreeNextScene() {
        for (int i = 0; i < rThreeScenes.length; i++) {
            rThreeScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) { // space pressed
                        if (k < rThreeScenes.length - 1) {
                            k++;// increases scene counter
                            window.setScene(rThreeScenes[k]);
                        } else {
                            window.setScene(endScenes[d]);// sets screen to end (final story part)

                        }
                    }

                }
            });
        }
    }

    /**
     * Controls input for end scenes. When space bar is pressed,
     * moves to next scene in end route. Depending on input, displays
     * bad ending or good ending.
     */
    private void endNextScene() {
        for (int i = 0; i < endScenes.length - 1; i++) {
            endScenes[i].setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent key) {
                    if (key.getCode().equals(KeyCode.SPACE)) {
                        d++;
                        window.setScene(endScenes[d]);
                    }
                }

            });
        }
    }

    /**
     * Loads music file and creates new media player to stop/start and change volume
     * of audio. When window is closed, it closes music and exits out of game system
     * and platform to make sure
     * no files/code are still running.
     * 
     */
    private void playMusic() {
        Media music = new Media(getClass().getResource("/music.mp3").toExternalForm()); // loads music
        MediaPlayer mediaPlayer = new MediaPlayer(music);

        mediaPlayer.setVolume(0.10); // sets volume
        mediaPlayer.play(); // plays music

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                mediaPlayer.stop(); // stops music
                Platform.exit(); // exits platform
                System.exit(0); // exits system
            }
        });

    }

    /**
     * Reads score file lines individually using scanner and adds score to (numList)
     * arrayList. Sorts numList from highest to lowest integer
     * and returns (first element in arraylist) highest value integer in string
     * form. If no score available to be read then value returned is "0";
     * 
     * @returns String (first element of numList array to display on highscore
     *          board)
     */
    private String readFile() {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        try {
            Scanner scoreFile = new Scanner(new File("Score.txt"));

            while (scoreFile.hasNext()) {
                if (scoreFile.hasNextInt())
                    numList.add(scoreFile.nextInt()); // adds score to numList
                else
                    scoreFile.next();
            }
            Collections.sort(numList); // sorts lowest to highest
            Collections.reverse(numList); // reverses order to make it highest to lowest

        } catch (Exception e) {
            e.printStackTrace();

        }

        if (numList.isEmpty()) { // if no score on file
            return "0";
        } else {
            return numList.get(0).toString();
        }
    }

    /**
     * Writes on Score file using bufferedWriter. Writes score in string form. Score
     * is
     * calculated based on # of deaths it took to reach one of the final endings.
     * 
     */
    private void writeFile() {
        try {
            FileWriter fw = new FileWriter("Score.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            score = 1000 - (deaths * 75);
            if (score > 0) {
                writer.write(Integer.toString(score));
            } else {
                writer.write("0");
            }

            writer.newLine();
            writer.close();
            fw.close();

        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }

    }

    /**
     * Resets score file by overwriting file with an empty string.
     * 
     */
    private void resetFile() {
        try {
            PrintWriter writer = new PrintWriter("Score.txt");
            writer.print("");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates start screen using GameScene methods along with text and adds buttons
     * to
     * navigate between instruction screen, reset score screen and intro scene 1.
     * Also starts music and resets all input and scene number counters.
     * 
     * @return Scene
     */
    private Scene startScreen() {
        playMusic(); // starts music
        c = 0; // resets scene counter to 0
        m = 0;
        n = 0;
        d = 0;
        k = 0;
        deaths = 0; // resets deaths

        introInput.setText(""); // clears all inputs
        rTwoInputOne.setText("");
        rTwoInputTwo.setText("");
        r3Input.setText("");
        endInput.setText("");

        StackPane box = new StackPane();
        game.basicPane(box);
        // labels
        Label title = new Label("Demon Trail");
        Label highScore = new Label("HighScore :" + readFile());
        // text
        game.styleText(highScore, 250);
        game.styleText(title, 75);
        game.title(title);

        // Start screen buttons
        Button begin = new Button();
        game.restart(begin);
        begin.setText("Start");
        begin.setTranslateY(350);

        Button howToPlay = new Button();
        game.restart(howToPlay);
        howToPlay.setText("How To Play");
        howToPlay.setTranslateY(500);

        Button resetScore = new Button();
        game.restart(resetScore);
        resetScore.setText("Reset Score");
        resetScore.setTranslateY(650);

        box.getChildren().addAll(begin, howToPlay, title, highScore, resetScore);
        Scene sceneOne = new Scene(box, 1000, 800);

        // if start button pressed...
        begin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(introOne); // sets screen to first scene of story
            }

        });
        // if how to play button pressed...
        howToPlay.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(instructionsScene()); // sets screen to instruction scene
            }
        });

        // if resetScore button pressed...
        resetScore.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resetFile(); // resets score
                window.setScene(scoreReset()); // sets screen to score reset scene
            }
        });
        return sceneOne;

    }

    /**
     * Creates scene for the instructions menu using text and images. Uses methods
     * from GameScene.java.
     * Adds return button that will change scene back to start.
     * 
     * @return Scene
     */
    private Scene instructionsScene() {

        StackPane sp = new StackPane();
        Scene sceneInstructions = new Scene(sp, 1000, 800);
        game.basicPane(sp);

        Button start = new Button();
        game.restart(start);
        start.setText("Return");

        Label title = new Label();
        Label t1 = new Label();
        Label t2 = new Label();
        Label t3 = new Label();
        Label t4 = new Label();
        Label t5 = new Label();

        title.setText("How to Play");
        t1.setText("Press space to move from scene to scene.");
        t2.setText("When you come across a choice,");
        t3.setText("type in a single number and press enter.");
        t4.setText("And remember,");
        t5.setText("your choices matter...");

        game.title(title);
        game.styleText(title, 80);
        game.styleText(t1, 300);
        game.styleText(t2, 350);
        game.styleText(t3, 400);
        game.styleText(t4, 480);
        game.styleText(t5, 530);
        game.smallFont(t1);
        game.smallFont(t2);
        game.smallFont(t3);
        game.bigFont(t4);
        game.bigFont(t5);

        sp.getChildren().addAll(title, t1, t2, t3, t4, t5, start);

        // go back button pressed
        start.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(startScreen()); // sets screen to start screen
            }

        });

        return sceneInstructions;
    }

    /**
     * Creates score reset screen using GameScene methods along with text and a
     * button to return back to start screen.
     * 
     * @return Scene
     */
    private Scene scoreReset() {
        StackPane box = new StackPane();
        game.basicPane(box);
        // label + styles text
        Label reset = new Label("Score Has Been");
        Label resetTwo = new Label("Reset!");
        game.styleText(reset, 200);
        game.title(reset);
        game.styleText(resetTwo, 400);
        game.title(resetTwo);
        // button
        Button back = new Button();
        game.restart(back);

        box.getChildren().addAll(back, reset, resetTwo);
        Scene scoreResetScene = new Scene(box, 1000, 800);

        back.setOnMousePressed(new EventHandler<MouseEvent>() {// if back button pressed
            @Override
            public void handle(MouseEvent event) {
                window.setScene(startScreen()); // sets screen to start screen
            }

        });
        return scoreResetScene;
    }

}