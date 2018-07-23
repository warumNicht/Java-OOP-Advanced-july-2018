package pb5_IntegrationTests;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<User> users=new HashSet<>();

        User user1=new User("IvAn");
        User user2=new User("Ivan");

        users.add(user1);
        users.add(user2);

        System.out.println("user1 hashcode = " + user1.hashCode());
        System.out.println("user2 hashcode = " + user2.hashCode());

        System.out.println("Checking equality between alex1 and alex2 = " + user1.equals(user2));

        System.out.println("HashSet contains user1 = " + users.contains(new User("Ivan")));
        System.out.println(users.size());
        users.remove(user2);
        users.remove(user2);
        users.remove(user2);
        System.out.println(users.size());

        CategoryManager manager=new CategoryManager();

        String input=scanner.nextLine();

        while ("END".equals(input)==false){
            String[] tokens=input.split("\\s+");

            switch (tokens[0]){
                case "AddUser":{
                    manager.addUserToTable(new User(tokens[1]));
                }break;
                case "AddCategory":{
                    manager.addCategoryToTable(new Category(tokens[1]));
                }break;
                case "Remove":{
                    manager.removeCategoryFromTable(tokens[1]);
                }break;
                case "MoveCategory":{
                    manager.moveSubcategory(tokens[1],tokens[2]);
                }break;
                case "AssignUserToCategory":{
                    manager.addUserToCategory(tokens[1],tokens[2]);
                }break;
                case "AssignSubcategory":{
                    manager.addSubcategory(tokens[1],tokens[2]);
                }break;
            }


            input=scanner.nextLine();
        }

        String end=scanner.nextLine();

    }
}
