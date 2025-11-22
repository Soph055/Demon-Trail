import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
* Abstract class that all routes inherit. Contains style methods and input methods that are created for non-repetitive code.
*
* @author  Sophia & Jelena
*/
public class GameScene { // class worked on together - Sophia & Jelena
/**
 * Creates basic style of all the scenes, makes the background black, aligns everything to the center.
 * 
 * @return StackPane
 * @param StackPane being used in the scene
 */
    public StackPane basicPane(StackPane box) {
        box.setStyle("-fx-background: black;");
        box.setAlignment(Pos.TOP_CENTER);
        return box;
    }

/**
 * Adds font and white colour to text. Uses font from external file.
 * 
 * @return Label
 * @param int y position of the text
 */
    public Label styleText(Label text, int y) { // styles text and places pos
        text.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
        text.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        text.setTranslateY(y);

        return text;
    }

/**
 * Changes added text to a large font made for titles. Uses font from external file.
 * 
 * @return Label 
 * @param StackPane being used in the scene
 */
    public Label title(Label label) { // changes text to title sized font
        label.getStyleClass().add("label-title");
        return label;
    }

/**
 * Changes added text to a big font. Uses font from external file.
 * 
 * @return Label 
 * @param Label
 */
    public Label bigFont(Label label) { // changes text to bigger font
        label.getStyleClass().add("label-big");
        return label;

    }

/**
 * Changes added text to a small font. Uses font from external file.
 * 
 * @return Label 
 * @param Label
 */
    public Label smallFont(Label label) { // changes text to smaller font
        label.getStyleClass().add("label-small");
        return label;

    }

/**
 * Adds a text that says "Press Space Bar To Continue" to help users. Adds white colour. Uses font from external file.
 * 
 * @return Label
 * @param int y, where the text should be located on the screen
 */
    public Label spaceText(int y) { // creates click space text for all scenes
        Label space = new Label();
        space.setText("Press Space Bar To Continue");//adds text
        space.setTranslateX(0); 
        space.setTranslateY(y);// where you want the text to be
        space.setTextFill(javafx.scene.paint.Color.WHITESMOKE); //white colour
        space.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        bigFont(space); //makes the font big
        return space;
    }

/**
 * Makes the desired image dsiplayable by using ImageView. Sets desired height and width. 
 * 
 * @return ImageView
 * @param String file location of picture that is being used in the scene
 * @param int desired width of the picture
 * @param int desired height of the picture
 */
    public ImageView image(String picture, int width, int height) { // image
        Image graphics = new Image(picture);
        ImageView imageArea = new ImageView();

        imageArea.setImage(graphics); //sets ImageView to be the image

        imageArea.setSmooth(true);
        imageArea.setCache(true);
        imageArea.setFitWidth(width); //adjusting to height and width
        imageArea.setFitHeight(height);

        return imageArea;
    }

/**
 * Limits the text of the input textfield. You can only input a single number. The font of the text and background of the textfield is set.
 * 
 * @return Textfield used for input
 * @param TextField 
 */
    public TextField limitText(TextField field) {

        field.setAlignment(Pos.CENTER);
        field.setFont((Font.font("Helvetica", FontWeight.BOLD, 36)));
        field.setEditable(true);
        field.setStyle("-fx-background-color: black;");
        field.setMaxSize(100,10);
        field.setTranslateY(700);

        field.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                int max = 1;//only a single digit can be typed
                if (field.getText().length() > max) {// if the length is greater than one, removes the text
                    field.setText("");
                }

            }
        });

        field.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) { //takes out non numeric characters
                field.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        return field;
    }

/**
 * Creates the style of the restart button used at the game over scenes. Uses external font file, sets the text on it and translates it to y = 700.
 * 
 * @return restart button 
 * @param Button
 */
    public Button restart(Button button) { // Restart Button
        button.setTranslateY(700);
        button.setMaxSize(300, 75);
        button.setAlignment(Pos.CENTER);
        button.setText("Restart");
        button.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
      
        return button;
    }

 
}
