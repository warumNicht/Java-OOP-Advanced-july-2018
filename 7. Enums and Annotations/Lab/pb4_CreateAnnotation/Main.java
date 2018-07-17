package pb4_CreateAnnotation;

import java.lang.annotation.Annotation;

@Subject(categories = {"Test", "Mest"})
public class Main {
    public static void main(String[] args) {

        Class cl= Main.class;

        Subject sub=(Subject) cl.getAnnotation(Subject.class);
        System.out.println(sub.categories()[1]);

        Annotation[] annotations=cl.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
