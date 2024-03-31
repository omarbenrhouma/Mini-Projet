import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ListClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 12345);
            ListInterface listService = (ListInterface) registry.lookup("ListServer");

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("1. Ajouter une tâche");
                System.out.println("2. Supprimer une tâche");
                System.out.println("3. Récupérer la liste des tâches");
                System.out.println("4. Quitter");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // pour consommer la nouvelle ligne

                switch (choice) {
                    case 1:
                        System.out.print("Entrez la nouvelle tâche à ajouter : ");
                        String newTask = scanner.nextLine();
                        listService.addTask(newTask);
                        break;
                    case 2:
                        System.out.print("Entrez la tâche à supprimer : ");
                        String taskToRemove = scanner.nextLine();
                        listService.removeTask(taskToRemove);
                        break;
                    case 3:
                        List<String> allTasks = listService.getAllTasks();
                        System.out.println("Liste des tâches : ");
                        for (String task : allTasks) {
                            System.out.println(task);
                        }
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }
            System.out.println("Déconnexion...");
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
