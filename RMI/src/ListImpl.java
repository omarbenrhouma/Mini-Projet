import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ListImpl extends UnicastRemoteObject implements ListInterface {


    private List<String> Lists;
    // Constructor to initialize the task list
    public ListImpl() throws RemoteException {
        Lists = new ArrayList<>();
    }

    @Override
    // Method to add a task to the list
    public void addTask(String task) throws RemoteException {
        Lists.add(task);
    }

    @Override
    // Method to remove a task from the list
    public void removeTask(String task) throws RemoteException {
        Lists.remove(task);
    }

    @Override
    // Method to retrieve the complete list of tasks
    public List<String> getAllTasks() throws RemoteException {
        return new ArrayList<>(Lists);
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the server
            ListImpl ListServer = new ListImpl();
            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(12345);
            // Bind the server to the RMI registry with name "ListServer" (enregistrement)
            System.out.println("List Server ready.");
            registry.rebind("ListServer", ListServer);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}