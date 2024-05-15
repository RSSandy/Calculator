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
        numberField.setEditable(false);
        numberField.setLayoutX(330);
        numberField.setLayoutY(100);
        numberField.setMinHeight(60);
        numberField.setMinWidth(80);
       
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
        gridPane.setLayoutY(200);

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
                gridPane.add(button, col, row + 1);
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
        gridPane.add(button0, 1, 4);

        //create period
        Button period = new Button(".");
        period.setMinWidth(50);
        period.setMinHeight(50);
        period.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e){
                        numberField.setText(numberField.getText() + ".");
                    }
        });  
        gridPane.add(period, 0, 4);
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
                numberField.setText(backend.compute(numberField.getText()));
            }
        });
        gridPane.add(enter, 2, 4);

        //create AC (all clear) button
        Button ac = new Button("AC");
        ac.setMinWidth(50);
        ac.setMinHeight(50);
        ac.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText("");
            }
        });
        gridPane.add(ac, 4, 0);
    }

    public void createKeypadFunctions(GridPane gridPane){
        //create multiplication button
        Button mult = new Button("X");
        mult.setMinWidth(50);
        mult.setMinHeight(50);
        mult.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText(numberField.getText() + " X ");
            }
        });
        gridPane.add(mult, 4, 1);

        //crete division button
        Button div = new Button("/");
        div.setMinWidth(50);
        div.setMinHeight(50);
        div.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText(numberField.getText() + " / ");
            }
        });
        gridPane.add(div, 4, 2);

        //create addition button
        Button addition = new Button("+");
        addition.setMinWidth(50);
        addition.setMinHeight(50);
        addition.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText(numberField.getText() + " + ");
            }
        });
        gridPane.add(addition, 4, 3);

        //create subtraction button
        Button sub = new Button("-");
        sub.setMinWidth(50);
        sub.setMinHeight(50);
        sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
                numberField.setText(numberField.getText() + " - ");
            }
        });
        gridPane.add(sub, 4, 4);
    }
}
