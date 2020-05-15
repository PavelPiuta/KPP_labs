public class PhotoPaper extends Paper {
   public PhotoPaper(int h, int w){
        height = h;
        width = w;
        content = "";
    }
    @Override
    public void writeContent(String newContent) {
        System.out.println("Печать: Фото");
        content = "Фото: " + newContent;

    }

}
