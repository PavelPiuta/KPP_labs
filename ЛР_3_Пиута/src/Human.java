import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Human{

    public enum typeOfPaper {
        PhotoPaper,
        OfficePaper,
        BluePrintPaper;
    }

    public void print() {
        try {
            Main.printer.print();
        } catch (Exception e) {
            System.out.println("нет бумаги");
        }

    }

    public void fillUpWithPaper(int count, typeOfPaper paper) {         //наполняем бумагой
        try {

            for (int i = 0; i < count; i++) {
                switch (paper) {
                    case PhotoPaper:
                        Main.printer.addPaper(new PhotoPaper(10, 15), typeOfPaper.PhotoPaper);
                        break;
                    case OfficePaper:
                        Main.printer.addPaper(new OfficePaper(15, 30), typeOfPaper.OfficePaper);
                        break;
                    case BluePrintPaper:
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("вы не можете смешать бумагу");
        }
    }

    public VBox getPane() {
        return Main.pane;
    }

    public Human() {
        Main.initializate();
    }
}
