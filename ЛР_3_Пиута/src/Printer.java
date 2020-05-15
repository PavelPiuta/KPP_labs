import javafx.scene.control.Label;
import java.util.LinkedList;
import java.util.List;

public class Printer {
    protected Human.typeOfPaper type;
    protected List<Paper> paper;
    protected Label log;

    public Label getLog() {
        return log;
    }

    private void printText(){
        log.setText("у вас есть напечатанный текст");
        paper.get(0).writeContent( " содержит: текст ");
        paper.remove(paper.get(0));
    }

    private void printImage(){
        log.setText("у вас есть напечатанное фото");
        paper.get(0).writeContent( " содержит: фото ");
        paper.remove(paper.get(0));

    }

    public void print() throws Exception {
        if(paper.isEmpty()){
            log.setText("ошибка");
            throw new Exception();
        }

        switch (type){
            case PhotoPaper:
                printImage();
                break;
            case OfficePaper:
                printText();
                break;
            default:
                log.setText("ошибка");
                throw new Exception();
        }
    }

    public void addPaper(Paper value, Human.typeOfPaper type1) throws Exception {
        if(type1 == Human.typeOfPaper.BluePrintPaper){
            log.setText("ошибка");
            throw new Exception();
        }
        if(paper.isEmpty()){
            type = type1;
        }
        else if(type != type1){
            log.setText("ошибка");
            throw new Exception();

        }
        paper.add(value);
        switch (type){
            case OfficePaper:
                log.setText("добавлен лист офисной бумаги");
                break;
            case PhotoPaper:
                log.setText("добавлен лист фотобумаги");
                break;

        }

    }

    public Printer(){
        paper = new LinkedList<Paper>();
        log = new Label("Пустой ");

    }
}
