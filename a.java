import java.util.*;

public class a {
	static class Task {
		String description;
		boolean done;
		Task(String description) {
			this.description = description;
			this.done = false;
		}
	}
// using try to ensure the scanner is closed properly after use. try with resourses block
	public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                ArrayList<Task> tasks = new ArrayList<>();//list tasks, storing all to do items.
                String[] recommended = { //few taskes that are stored by default.
                    "Drink water",
                    "Take a walk",
                    "Read a book",
                    "Call a friend",
                    "Organize your desk"
                };
                String[] quotes = {  //motivational quotes to keepo the program user friendly.
                    "Believe you can and you're halfway there.",
                    "The secret of getting ahead is getting started.",
                    "Don't watch the clock; do what it does. Keep going.",
                    "Success is the sum of small efforts, repeated day in and day out.",
                    "You are capable of amazing things."
                };
                Random rand = new Random();// random number generator for QUOTES above.
                // user info.
                System.out.print("Hey there, what's your name?");
                String userName = sc.nextLine().trim(); // trim reduces extra spaces from end and front.
                System.out.print("How old are you," + userName + "?");
                String age = sc.nextLine().trim(); // stores as string in all cases.
                System.out.print("What's one of your main goals right now?");
                String goal = sc.nextLine().trim();
				// printingb a user friendlt message.
                System.out.println("\nWelcome back," + userName + "! It's always great to see you. At " + age + ", working towards '" + goal + "' is awesome. Let's get things done together\n");
                int step = 0; // counts how many times u have looped.
                OUTER: // can be BREAKED with bBREAk key word.
                while (true) {
                    step++;        // increases step by 1, and prints a random quote whenever the step is even like 2,4,6...
                    if (step % 2 == 0) {
                        String quote = quotes[rand.nextInt(quotes.length)];
                        System.out.println("\nQuote: " + quote + "\n");
                    } // now comes the main menu...
                    System.out.println("\nTo-Do List Tracker for " + userName);
                    System.out.println("1. Add Task");
                    System.out.println("2. List Tasks");
                    System.out.println("3. Mark Task as Done");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = sc.hasNextInt() ? sc.nextInt() : 0; //read an integer for your menu choice default=0.
                    sc.nextLine(); // clears the pervious input line to avoid confusion
                    switch (choice) { // for different vcasese.
                        case 1 -> {
                            System.out.println("Recommended tasks:");
                            for (int i = 0; i < recommended.length; i++) {
                                System.out.printf("%d. %s\n", i+1, recommended[i]);
                            }
                            System.out.println("0. Enter your own task");
                            System.out.print("Choose a recommended task or 0 to type your own: ");
                            int rec = sc.hasNextInt() ? sc.nextInt() : -1;
                            sc.nextLine();
                            String desc = null;
                            if (rec >= 1 && rec <= recommended.length) {
                                desc = recommended[rec-1];
                            } else if (rec == 0) {
                                System.out.print("Enter task description: ");
                                desc = sc.nextLine();
                            } else {
                                System.out.println("Invalid choice. Task not added.");
                            }
                            if (desc != null && !desc.isEmpty()) {
                                tasks.add(new Task(desc));
                                System.out.println("Task added!");
                            }
                        }
                        case 2 -> {
                            if (tasks.isEmpty()) {
                                System.out.println("No tasks yet.");
                            } else {
                                for (int i = 0; i < tasks.size(); i++) {
                                    Task t = tasks.get(i);
                                    System.out.printf("%d. [%s] %s\n", i+1, t.done ? "X" : " ", t.description);
                                }
                            }
                        }
                        case 3 -> {
                            System.out.print("Enter task number to mark as done: ");
                            int num = sc.hasNextInt() ? sc.nextInt() : -1;
                            sc.nextLine();
                            if (num >= 1 && num <= tasks.size()) {
                                tasks.get(num-1).done = true;
                                System.out.println("Task marked as done!");
                            } else {
                                System.out.println("Invalid task number.");
                            }
                        }
                        case 4 -> {
                            System.out.println("Goodbye!");
                            break OUTER;
                        }
                        default -> System.out.println("Invalid option. Try again.");
                    }
                }
            }
	}
}
