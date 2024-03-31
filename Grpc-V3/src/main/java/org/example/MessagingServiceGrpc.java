package org.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Définition du service de messagerie
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service.proto")
public final class MessagingServiceGrpc {

  private MessagingServiceGrpc() {}

  public static final String SERVICE_NAME = "MessagingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.Service.TextMessage,
      org.example.Service.SendMessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = org.example.Service.TextMessage.class,
      responseType = org.example.Service.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.Service.TextMessage,
      org.example.Service.SendMessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<org.example.Service.TextMessage, org.example.Service.SendMessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = MessagingServiceGrpc.getSendMessageMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getSendMessageMethod = MessagingServiceGrpc.getSendMessageMethod) == null) {
          MessagingServiceGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<org.example.Service.TextMessage, org.example.Service.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MessagingService", "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.Service.TextMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.Service.SendMessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("SendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.Service.GetReceivedMessagesRequest,
      org.example.Service.TextMessage> getGetReceivedMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReceivedMessages",
      requestType = org.example.Service.GetReceivedMessagesRequest.class,
      responseType = org.example.Service.TextMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.example.Service.GetReceivedMessagesRequest,
      org.example.Service.TextMessage> getGetReceivedMessagesMethod() {
    io.grpc.MethodDescriptor<org.example.Service.GetReceivedMessagesRequest, org.example.Service.TextMessage> getGetReceivedMessagesMethod;
    if ((getGetReceivedMessagesMethod = MessagingServiceGrpc.getGetReceivedMessagesMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getGetReceivedMessagesMethod = MessagingServiceGrpc.getGetReceivedMessagesMethod) == null) {
          MessagingServiceGrpc.getGetReceivedMessagesMethod = getGetReceivedMessagesMethod = 
              io.grpc.MethodDescriptor.<org.example.Service.GetReceivedMessagesRequest, org.example.Service.TextMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "MessagingService", "GetReceivedMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.Service.GetReceivedMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.Service.TextMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("GetReceivedMessages"))
                  .build();
          }
        }
     }
     return getGetReceivedMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessagingServiceStub newStub(io.grpc.Channel channel) {
    return new MessagingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessagingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessagingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessagingServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Définition du service de messagerie
   * </pre>
   */
  public static abstract class MessagingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC pour envoyer un message texte à un destinataire spécifié
     * </pre>
     */
    public void sendMessage(org.example.Service.TextMessage request,
        io.grpc.stub.StreamObserver<org.example.Service.SendMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC pour récupérer les messages reçus pour un utilisateur donné
     * </pre>
     */
    public void getReceivedMessages(org.example.Service.GetReceivedMessagesRequest request,
        io.grpc.stub.StreamObserver<org.example.Service.TextMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReceivedMessagesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.Service.TextMessage,
                org.example.Service.SendMessageResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getGetReceivedMessagesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.example.Service.GetReceivedMessagesRequest,
                org.example.Service.TextMessage>(
                  this, METHODID_GET_RECEIVED_MESSAGES)))
          .build();
    }
  }

  /**
   * <pre>
   * Définition du service de messagerie
   * </pre>
   */
  public static final class MessagingServiceStub extends io.grpc.stub.AbstractStub<MessagingServiceStub> {
    private MessagingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessagingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessagingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC pour envoyer un message texte à un destinataire spécifié
     * </pre>
     */
    public void sendMessage(org.example.Service.TextMessage request,
        io.grpc.stub.StreamObserver<org.example.Service.SendMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC pour récupérer les messages reçus pour un utilisateur donné
     * </pre>
     */
    public void getReceivedMessages(org.example.Service.GetReceivedMessagesRequest request,
        io.grpc.stub.StreamObserver<org.example.Service.TextMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetReceivedMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Définition du service de messagerie
   * </pre>
   */
  public static final class MessagingServiceBlockingStub extends io.grpc.stub.AbstractStub<MessagingServiceBlockingStub> {
    private MessagingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessagingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessagingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC pour envoyer un message texte à un destinataire spécifié
     * </pre>
     */
    public org.example.Service.SendMessageResponse sendMessage(org.example.Service.TextMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC pour récupérer les messages reçus pour un utilisateur donné
     * </pre>
     */
    public java.util.Iterator<org.example.Service.TextMessage> getReceivedMessages(
        org.example.Service.GetReceivedMessagesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetReceivedMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Définition du service de messagerie
   * </pre>
   */
  public static final class MessagingServiceFutureStub extends io.grpc.stub.AbstractStub<MessagingServiceFutureStub> {
    private MessagingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessagingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessagingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC pour envoyer un message texte à un destinataire spécifié
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.Service.SendMessageResponse> sendMessage(
        org.example.Service.TextMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_GET_RECEIVED_MESSAGES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessagingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessagingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((org.example.Service.TextMessage) request,
              (io.grpc.stub.StreamObserver<org.example.Service.SendMessageResponse>) responseObserver);
          break;
        case METHODID_GET_RECEIVED_MESSAGES:
          serviceImpl.getReceivedMessages((org.example.Service.GetReceivedMessagesRequest) request,
              (io.grpc.stub.StreamObserver<org.example.Service.TextMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessagingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessagingService");
    }
  }

  private static final class MessagingServiceFileDescriptorSupplier
      extends MessagingServiceBaseDescriptorSupplier {
    MessagingServiceFileDescriptorSupplier() {}
  }

  private static final class MessagingServiceMethodDescriptorSupplier
      extends MessagingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessagingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessagingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessagingServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getGetReceivedMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
