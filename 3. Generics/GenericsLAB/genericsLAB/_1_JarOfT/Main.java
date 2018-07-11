package genericsLAB._1_JarOfT;

public class Main {
    public static void main(String[] args)  {


        Jar<Pickle> intJar = new Jar<>();

        intJar.add(new Pickle());

        intJar.add(new Pickle());

        System.out.println(intJar.remove());


    }
}
