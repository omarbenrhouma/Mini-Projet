import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ListInterface extends Remote {

    // Method to add a task to the list
    void addTask(String task) throws RemoteException;
    // Method to remove a task from the list
    void removeTask(String task) throws RemoteException;
    // Method to retrieve the complete list of tasks
    List<String> getAllTasks() throws RemoteException;
}