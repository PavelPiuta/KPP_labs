import java.util.concurrent.ExecutionException;

public class Xerox extends Printer {

    public String scanBuffer;

    @Override
    public void print() throws Exception {
        if(type!= Human.typeOfPaper.BluePrintPaper){
            log.setText("ошибка");
            throw new Exception();
        }
        if(paper.isEmpty()){
            log.setText("ошибка");
            throw new Exception();
        }

        creatCopy();
    }

    @Override
    public void addPaper(Paper value, Human.typeOfPaper type1) throws Exception {
        if(type1 != Human.typeOfPaper.BluePrintPaper){
            log.setText("ошибка");
            throw new Exception();
        }
        paper.add(value);
        log.setText("добавлена чертежная бумага");
    }



    private void creatCopy(){
        log.setText("вы ксерокопировали текст");
        paper.get(0).writeContent( " содержимое: копия ");
        paper.remove(paper.get(0));
    }

    public  Xerox(){
        super();
        log.setText("Пустой");
        type = Human.typeOfPaper.BluePrintPaper;
    }
}
