package it.studiuje.todo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        System.out.println("Enter the sentence: ");

        Scanner console = new Scanner(System.in);
        List<String> elements = new ArrayList<>();

        while (console.hasNext()) {
            String read = console.nextLine();
            System.out.println("Next line is: " + read);

            if (read.startsWith("add")) {
                elements.add(read.replace("add", "").trim());
            }
            if (read.startsWith("remove")) {
                elements.remove(read.replace("remove", "").trim());
            }
            System.out.println(elements);


        }
    }
}
