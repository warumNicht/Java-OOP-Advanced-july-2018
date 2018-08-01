package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        Streamable file=new File("Stoqn", 23,21);
        Streamable mus=new Music("Celine Dion","Paris",234,23); //moje i Music vmesto interfejsa

        StreamProgressInfo spi1=new StreamProgressInfo(file);
        StreamProgressInfo spi2=new StreamProgressInfo(mus);

        System.out.println(spi1.calculateCurrentPercent());
        System.out.println(spi2.calculateCurrentPercent());
    }
}
