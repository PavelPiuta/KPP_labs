import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Human nik = new Human();
        Scene scene = new Scene(nik.getPane());
        stage.setScene(scene);
        stage.setTitle("Офис");
        stage.show();
    }
    public static Printer printer;
    public static Xerox xerox;
    public static VBox pane;
    public static Button button1;
    public static Button button2;
    public static Button button3;
    public static Button button4;
    public static Button button5;
    public static Label text1;
    public static Label text2;

    public static void initializate() {
        printer = new Printer();
        xerox = new Xerox();
        pane = new VBox();
        button1 = new Button("Печать");
        button2 = new Button("Добавить лист фотобумаги ");
        button3 = new Button("Добавить лист чертежной бумаги ");
        button4 = new Button("Добавить лист офисной бумаги ");
        button5 = new Button("Создать копию ");
        text1 = new Label("Бумаги в принтере: ");
        text2 = new Label("Бумаги в ксероксе: ");

        button1.setOnAction(e -> {
            try {
                printer.print();
            } catch (Exception ex) {

            }
        });
        button2.setOnAction(e -> {
            try {
                printer.addPaper(new PhotoPaper(30, 45), Human.typeOfPaper.PhotoPaper);
            } catch (Exception ex) {

            }
        });
        button3.setOnAction(e -> {
            try {
                xerox.addPaper(new BluePrintPaper(20, 18), Human.typeOfPaper.BluePrintPaper);
            } catch (Exception ex) {

            }
        });
        button4.setOnAction(e -> {
            try {
                printer.addPaper(new OfficePaper(20, 18), Human.typeOfPaper.OfficePaper);
            } catch (Exception ex) {

            }
        });

        button5.setOnAction(e -> {
            try {
                xerox.print();
            } catch (Exception ex) {

            }
        });
        button1.setPrefWidth(300);
        button2.setPrefWidth(300);
        button3.setPrefWidth(300);
        button4.setPrefWidth(300);
        button5.setPrefWidth(300);


        pane.getChildren().addAll(button2, button4, button1, text1, printer.getLog());
        pane.getChildren().addAll(button3, button5, text2, xerox.getLog());
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
    }
}
