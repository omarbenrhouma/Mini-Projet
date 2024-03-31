import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.example.*;

import java.util.*;

import java.io.IOException;

// Implémentation du service de messagerie
public class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {

    private Map<String, String> messagesDatabase = new HashMap<>();

    @Override
    public void sendMessage(Service.TextMessage request, StreamObserver<Service.SendMessageResponse> responseObserver) {
        // Générer un ID unique pour le message
        String messageId = UUID.randomUUID().toString();

        // Construire le message avec l'ID attribué
        Service.TextMessage messageWithId = Service.TextMessage.newBuilder()
                .setId(messageId)
                .setSenderId(request.getSenderId())
                .setRecipientId(request.getRecipientId())
                .setText(request.getText())
                .build();

        // Ajouter le message à la messagesDatabase
        messagesDatabase.put(messageId, messageWithId.getText());

        // Afficher les informations sur le message ajouté pour débogage
        System.out.println("Message added to messagesDatabase: ID - " + messageId + ", Text - " + messageWithId.getText());

        // Construire la réponse et l'envoyer au client
        Service.SendMessageResponse response = Service.SendMessageResponse.newBuilder()
                .setMessageId(messageId)
                .setSuccess(true)
                .setMessageText(request.getText())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }@Override
    public void getReceivedMessages(Service.GetReceivedMessagesRequest request,
                                    StreamObserver<Service.TextMessage> responseObserver) {
        String userId = request.getUserId(); // ID de l'utilisateur spécifié dans la requête

        List<Service.TextMessage> receivedMessages = new ArrayList<>();

        // Instructions de débogage pour afficher les messages de la messagesDatabase
        System.out.println("Messages in messagesDatabase for user " + userId + ":");
        for (Map.Entry<String, String> entry : messagesDatabase.entrySet()) {
            String messageId = entry.getKey();
            String messageText = entry.getValue();

            // Instructions de débogage pour afficher les messages dans la console
            System.out.println("Message ID: " + messageId + ", Text: " + messageText);

            // Vérifier si l'ID de l'utilisateur correspond soit au senderId soit au recipientId du message
            Service.TextMessage message = Service.TextMessage.newBuilder()
                    .setId(messageId)
                    .setText(messageText)
                    .build();

            if (message.getRecipientId().equals(userId)) {
                receivedMessages.add(message);
            }
        }


        // Instructions de débogage pour afficher les messages récupérés avant de les envoyer au client
        System.out.println("Messages to be sent to client:");
        for (Service.TextMessage message : receivedMessages) {
            System.out.println("Message ID: " + message.getId() + ", Text: " + message.getText());
        }

        // Envoyer les messages récupérés au client
        for (Service.TextMessage message : receivedMessages) {
            responseObserver.onNext(message);
        }
        responseObserver.onCompleted();
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        final Server server = ServerBuilder.forPort(1234)
                .addService(new MessagingServiceImpl())
                .build();

        server.start();
        System.out.println("Server started, listening on " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** Shutting down gRPC server since JVM is shutting down");
                server.shutdown();
                System.err.println("*** Server shut down");
            }
        });

        server.awaitTermination();
    }
}
