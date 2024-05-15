import javafx.application.Application;

public class App
 {
    public static void main(String[] args) {
        Backend back = new Backend();
        Frontend.setBackend(back);
        Application.launch(Frontend.class, args);
    }
}
