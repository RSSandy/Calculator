import javafx.application.Application;
import javafx.stage.Window;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.NumberStringConverter;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.text.ParsePosition;
import java.util.function.UnaryOperator;

public class Frontend extends Application{

    private static Backend backend;
    private static TextField numberField;
    
    //set backend
    public static void setBackend(Backend backend){
        Frontend.backend = backend;
    }

    @Override
    public void start(final Stage stage){
        Pane root = new Pane();
        root.setId("root");
        createAllControls(root);
        Scene scene =  new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Sandy's Calculator");
        stage.show();
    }

    //creates all the controls, calls all other functions
    public void createAllControls(Pane parent){
        createNumField(parent);
        createKeypad(parent);
    }

    //create numfield
    public void createNumField(Pane parent){
        numberField = new TextField();
        numberField.setLayoutX(330);
        numberField.setLayoutY(200);
        numberField.setMinHeight(60);
        numberField.setMinWidth(80);
        // NumberStringFilteredConverter converter = new NumberStringFilteredConverter();
        // final TextFormatter<Number> formatter = new TextFormatter<>(
        //         converter,
        //         0,
        //         converter.getFilter()
        // );

        // numberField.setTextFormatter(formatter);

        // formatter.valueProperty().addListener((observable, oldValue, newValue) ->
        //         System.out.println(newValue)
        // );
       
        parent.getChildren().add(numberField);    
    }

    //creates keypad with numbers, enter, AC
    public void createKeypad(Pane parent){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        createKeypadNumbers(gridPane);
        createKeypadControls(gridPane);
        createKeypadFunctions(gridPane);

        //setup gridPane
        gridPane.setLayoutX(330);
        gridPane.setLayoutY(300);

        parent.getChildren().add(gridPane);
    }

    //creates numbers 0-9 and . on keypad
    public void createKeypadNumbers(GridPane gridPane){

        //create 0-9
        int num = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(Integer.toString(num));
                button.setMinWidth(50);
                button.setMinHeight(50);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e){
                        numberField.setText(numberField.getText() + button.getText());
                    }
                });
                gridPane.add(button, col, row);
                num++;
            }
        }
        
        // create button 0
        Button button0 = new Button("0");
        button0.setMinWidth(50);
        button0.setMinHeight(50);
        button0.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e){
                        numberField.setText(numberField.getText() + "0");
                    }
        });  
        gridPane.add(button0, 1, 3);

        //create period
        Button period = new Button(".");
        period.setMinWidth(50);
        period.setMinHeight(50);
        period.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e){
                        numberField.setText(numberField.getText() + ".");
                    }
        });  
        gridPane.add(period, 0, 3);
    }

    //creates enter and AC on keypad
    public void createKeypadControls(GridPane gridPane){
        //create enter button
        Button enter = new Button();
        ImageView enterImg = new ImageView(new Image("media/equal_symbol.png"));
        enterImg.setFitWidth(30);
        enterImg.setPreserveRatio(true);
        enterImg.setSmooth(true);
        enterImg.setCache(true);
        enter.setGraphic(enterImg);
        enter.setMaxWidth(50);
        enter.setMaxHeight(50);
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText(backend.addToArray(numberField.getText()));
            }
        });
        gridPane.add(enter, 2, 3);

        //create AC (all clear) button
        Button ac = new Button("AC");
        ac.setMinWidth(50);
        ac.setMinHeight(50);
        ac.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText("");
                backend.clear();
            }
        });
        gridPane.add(ac, 4, 0);
    }

    public void createKeypadFunctions(GridPane gridPane){
        //create multiplication button
        //crete division button
        //create addition button
        //create subtraction button
    }

    class NumberStringFilteredConverter extends NumberStringConverter {
        public UnaryOperator<TextFormatter.Change> getFilter() {
            return change -> {
                String newText = change.getControlNewText();
                if (newText.isEmpty()) {
                    return change;
                }

                ParsePosition parsePosition = new ParsePosition( 0 );
                Object object = getNumberFormat().parse( newText, parsePosition );
                if ( object == null || parsePosition.getIndex() < newText.length()) {
                    return null;
                } else {
                    return change;
                }
            };
        }
    }

}
