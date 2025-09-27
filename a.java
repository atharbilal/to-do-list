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

	public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                ArrayList<Task> tasks = new ArrayList<>();
                String[] recommended = {
                    "Drink water",
                    "Take a walk",
                    "Read a book",
                    "Call a friend",
                    "Organize your desk"
                };
                String[] quotes = {
                    "Believe you can and you're halfway there.",
                    "The secret of getting ahead is getting started.",
                    "Don't watch the clock; do what it does. Keep going.",
                    "Success is the sum of small efforts, repeated day in and day out.",
                    "You are capable of amazing things."
                };
                Random rand = new Random();
                // User info
                System.out.print("Hey there! What's your name? ");
                String userName = sc.nextLine().trim();
                System.out.print("How old are you, " + userName + "? ");
                String age = sc.nextLine().trim();
                System.out.print("What's one of your main goals right now? ");
                String goal = sc.nextLine().trim();
                System.out.println("\nWelcome back, " + userName + "! It's always great to see you. At " + age + ", working towards '" + goal + "' is awesome. Let's get things done together!\n");
                int step = 0;
                OUTER:
                while (true) {
                    step++;
                    if (step % 2 == 0) {
                        String quote = quotes[rand.nextInt(quotes.length)];
                        System.out.println("\nQuote: " + quote + "\n");
                    }
                    System.out.println("\nTo-Do List Tracker for " + userName);
                    System.out.println("1. Add Task");
                    System.out.println("2. List Tasks");
                    System.out.println("3. Mark Task as Done");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = sc.hasNextInt() ? sc.nextInt() : 0;
                    sc.nextLine();
                    switch (choice) {
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
