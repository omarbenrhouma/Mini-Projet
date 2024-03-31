import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageSender {

    private final ManagedChannel channel;
    private final MessagingServiceGrpc.MessagingServiceBlockingStub blockingStub;

    public MessageSender(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = MessagingServiceGrpc.newBlockingStub(channel);
    }

    public Service.SendMessageResponse sendMessage(String senderId, String recipientId, String messageText) {
        Service.TextMessage request = Service.TextMessage.newBuilder()
                .setSenderId(senderId)
                .setRecipientId(recipientId)
                .setText(messageText)
                .build();
        return blockingStub.sendMessage(request);
    }public List<Service.TextMessage> getReceivedMessages(String userId) {
        Service.GetReceivedMessagesRequest request = Service.GetReceivedMessagesRequest.newBuilder()
                .setUserId(userId)
                .build();
        List<Service.TextMessage> messages = new ArrayList<>();
        blockingStub.getReceivedMessages(request)
                .forEachRemaining(message -> {
                    // Affichage du message reçu pour le débogage
                    System.out.println("Received message: ID - " + message.getId() + ", Text - " + message.getText());
                    messages.add(message);
                });
        return messages;
    }


    public void shutdown() {
        channel.shutdown();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sender ID: ");
        String senderId = scanner.nextLine();
        System.out.print("Enter recipient ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter message text: ");
        String messageText = scanner.nextLine();

        MessageSender client = new MessageSender("localhost", 1234);
        try {
            Service.SendMessageResponse response = client.sendMessage(senderId, recipientId, messageText);
            System.out.println("Message sent successfully. Message: " + response.getMessageText());

            // Récupération des messages reçus pour l'utilisateur donné
            System.out.print("Enter user ID to fetch received messages: ");
            String userId = scanner.nextLine();
            List<Service.TextMessage> receivedMessages = client.getReceivedMessages(userId);
            System.out.println("Received messages for user " + userId + ":");
            for (Service.TextMessage message : receivedMessages) {
                System.out.println("Message ID: " + message.getId() + ", Text: " + message.getText());
            }
        } finally {
            client.shutdown();
            scanner.close();
        }
    }
}
