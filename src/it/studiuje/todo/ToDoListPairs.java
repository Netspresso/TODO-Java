package it.studiuje.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListPairs {

    public static void main(String[] args) {
        // add task PENDING
        // remove task by list index
        // complete task by list index -> COMPLETED
        // incomplete task by list index -> PENDING

        List<Task> tasks = new ArrayList<>();
        printTasks(tasks);

        Scanner console = new Scanner(System.in);

        while (console.hasNext()) {
            String read = console.nextLine();
            System.out.println("command is: " + read);

            if (read.startsWith("add")) {
                String content = read.replace("add", "").trim();
                tasks.add(new Task(content, false));
            }

            if (read.startsWith("remove")) {
                int index = Integer.parseInt(read.replace("remove", "").trim());
                tasks.remove(index);
            }

            if (read.startsWith("complete")) {
                int index = Integer.parseInt(read.replace("complete", "").trim());
                Task task = tasks.get(index);
                task.setCompleted();
                tasks.set(index, task);
            }

            if (read.startsWith("incomplete")) {
                int index = Integer.parseInt(read.replace("incomplete", "").trim());
                Task task = tasks.get(index);
                task.setUncompleted();
                tasks.set(index, task);
            }

            if (read.startsWith("edit")) {
                int index = Integer.parseInt(read.replace("edit", "").trim());

                String content = console.next();
                Task task = tasks.get(index);
                task.setContent(content);
                tasks.set(index, task);
            }

            printTasks(tasks);

        }
    }

    public static void printTasks(List<Task> tasks) {

        if (tasks.isEmpty()) {
            System.out.println("TODO empty. Add elements");
        }

        for (int counter = 0; counter < tasks.size(); counter++) {
            System.out.println(counter + ", content: " + tasks.get(counter).getContent() + ", completed: " + tasks.get(counter).isCompleted());
        }
    }

}
