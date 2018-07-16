package IteratorsAndComparatorsLAB.pb2_Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Book bookOne=new Book("Animal",2003,"Orwell");
        Book sec=new Book("AutoCad", 2018,"Ivan","Kadov");
        List<Book> books=new ArrayList<>();
        books.add(bookOne);
        books.add(sec);

        Library library=new Library(bookOne,sec);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }

    }
}
