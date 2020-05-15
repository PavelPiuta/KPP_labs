public class BluePrintPaper extends Paper {

    BluePrintPaper(int w, int h){

    }
    @Override
    public void writeContent(String newContent) {
        content = "Чертёжная: " + newContent;
    }
}
