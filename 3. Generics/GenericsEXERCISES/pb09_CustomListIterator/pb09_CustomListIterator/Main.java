package pb09_CustomListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        CustomList<String> list=new CustomList<>();

        String com=reader.readLine();
        while ("END".equals(com)==false){

            if(com.equals("Max")){
                System.out.println(list.getMax());
            }else if(com.equals("Min")){
                System.out.println(list.getMin());
            }else {
                String[] tokens=com.split("\\s+");

                switch (tokens[0]){
                    case "Add":{
                        list.add(tokens[1]);
                    }break;
                    case "Greater":{
                        System.out.println(list.countGreaterThan(tokens[1]));
                    }break;
                    case "Swap":{
                        list.swap(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                    }break;
                    case "Contains":{
                        System.out.println(list.contains(tokens[1]));
                    }break;
                    case "Print":{
                        for (String s : list) {
                            System.out.println(s);
                        }
                    }break;
                    case "Remove":{
                        list.remove(Integer.parseInt(tokens[1]));
                    }break;
                    case "Sort":{
                        Sorter.sort(list);
                    }break;
                }

            }

            com=reader.readLine();
        }

    }
}
