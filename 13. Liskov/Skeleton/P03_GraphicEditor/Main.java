package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        GraphicEditor editor=new GraphicEditor();
        Shape sh1=new Rectangle();
        Shape sh2=new Circle();

        editor.drawShape(sh1);
        editor.drawShape(sh2);
    }
}
