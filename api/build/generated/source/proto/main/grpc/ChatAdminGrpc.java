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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: chat.proto")
public final class ChatAdminGrpc {

  private ChatAdminGrpc() {}

  public static final String SERVICE_NAME = "ChatAdmin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest,
      ChatOuterClass.SendMesageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = ChatOuterClass.MessageRequest.class,
      responseType = ChatOuterClass.SendMesageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest,
      ChatOuterClass.SendMesageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest, ChatOuterClass.SendMesageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = ChatAdminGrpc.getSendMessageMethod) == null) {
      synchronized (ChatAdminGrpc.class) {
        if ((getSendMessageMethod = ChatAdminGrpc.getSendMessageMethod) == null) {
          ChatAdminGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.MessageRequest, ChatOuterClass.SendMesageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChatAdmin", "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.SendMesageResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.GetMessagesRequest,
      ChatOuterClass.MessagesResponse> getGetMessegesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMesseges",
      requestType = ChatOuterClass.GetMessagesRequest.class,
      responseType = ChatOuterClass.MessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ChatOuterClass.GetMessagesRequest,
      ChatOuterClass.MessagesResponse> getGetMessegesMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.GetMessagesRequest, ChatOuterClass.MessagesResponse> getGetMessegesMethod;
    if ((getGetMessegesMethod = ChatAdminGrpc.getGetMessegesMethod) == null) {
      synchronized (ChatAdminGrpc.class) {
        if ((getGetMessegesMethod = ChatAdminGrpc.getGetMessegesMethod) == null) {
          ChatAdminGrpc.getGetMessegesMethod = getGetMessegesMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.GetMessagesRequest, ChatOuterClass.MessagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChatAdmin", "GetMesseges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.GetMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.MessagesResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getGetMessegesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.CreateChatRequest,
      ChatOuterClass.CreateChatResponse> getCreateChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChat",
      requestType = ChatOuterClass.CreateChatRequest.class,
      responseType = ChatOuterClass.CreateChatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatOuterClass.CreateChatRequest,
      ChatOuterClass.CreateChatResponse> getCreateChatMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.CreateChatRequest, ChatOuterClass.CreateChatResponse> getCreateChatMethod;
    if ((getCreateChatMethod = ChatAdminGrpc.getCreateChatMethod) == null) {
      synchronized (ChatAdminGrpc.class) {
        if ((getCreateChatMethod = ChatAdminGrpc.getCreateChatMethod) == null) {
          ChatAdminGrpc.getCreateChatMethod = getCreateChatMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.CreateChatRequest, ChatOuterClass.CreateChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChatAdmin", "CreateChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.CreateChatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.CreateChatResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getCreateChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.GetChatsRequest,
      ChatOuterClass.GetChatsResponse> getGetChatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChats",
      requestType = ChatOuterClass.GetChatsRequest.class,
      responseType = ChatOuterClass.GetChatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ChatOuterClass.GetChatsRequest,
      ChatOuterClass.GetChatsResponse> getGetChatsMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.GetChatsRequest, ChatOuterClass.GetChatsResponse> getGetChatsMethod;
    if ((getGetChatsMethod = ChatAdminGrpc.getGetChatsMethod) == null) {
      synchronized (ChatAdminGrpc.class) {
        if ((getGetChatsMethod = ChatAdminGrpc.getGetChatsMethod) == null) {
          ChatAdminGrpc.getGetChatsMethod = getGetChatsMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.GetChatsRequest, ChatOuterClass.GetChatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChatAdmin", "GetChats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.GetChatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.GetChatsResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getGetChatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest,
      ChatOuterClass.MessagesResponse> getUpdateMensageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMensage",
      requestType = ChatOuterClass.MessageRequest.class,
      responseType = ChatOuterClass.MessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest,
      ChatOuterClass.MessagesResponse> getUpdateMensageMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest, ChatOuterClass.MessagesResponse> getUpdateMensageMethod;
    if ((getUpdateMensageMethod = ChatAdminGrpc.getUpdateMensageMethod) == null) {
      synchronized (ChatAdminGrpc.class) {
        if ((getUpdateMensageMethod = ChatAdminGrpc.getUpdateMensageMethod) == null) {
          ChatAdminGrpc.getUpdateMensageMethod = getUpdateMensageMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.MessageRequest, ChatOuterClass.MessagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChatAdmin", "UpdateMensage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.MessagesResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getUpdateMensageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest,
      ChatOuterClass.MessagesResponse> getDeleteMesageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMesage",
      requestType = ChatOuterClass.MessageRequest.class,
      responseType = ChatOuterClass.MessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest,
      ChatOuterClass.MessagesResponse> getDeleteMesageMethod() {
    io.grpc.MethodDescriptor<ChatOuterClass.MessageRequest, ChatOuterClass.MessagesResponse> getDeleteMesageMethod;
    if ((getDeleteMesageMethod = ChatAdminGrpc.getDeleteMesageMethod) == null) {
      synchronized (ChatAdminGrpc.class) {
        if ((getDeleteMesageMethod = ChatAdminGrpc.getDeleteMesageMethod) == null) {
          ChatAdminGrpc.getDeleteMesageMethod = getDeleteMesageMethod = 
              io.grpc.MethodDescriptor.<ChatOuterClass.MessageRequest, ChatOuterClass.MessagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChatAdmin", "DeleteMesage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ChatOuterClass.MessagesResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getDeleteMesageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatAdminStub newStub(io.grpc.Channel channel) {
    return new ChatAdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatAdminBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatAdminBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatAdminFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatAdminFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatAdminImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * ENvia multiples mensjes al servidor
     * </pre>
     */
    public void sendMessage(ChatOuterClass.MessageRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.SendMesageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * Recupera múltipes mensajes del servidor _a partir de una fecha_
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ChatOuterClass.GetMessagesRequest> getMesseges(
        io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetMessegesMethod(), responseObserver);
    }

    /**
     * <pre>
     *crea un chat
     * </pre>
     */
    public void createChat(ChatOuterClass.CreateChatRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.CreateChatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateChatMethod(), responseObserver);
    }

    /**
     * <pre>
     *recupera los chats en los que está incluido un usuairo
     * </pre>
     */
    public void getChats(ChatOuterClass.GetChatsRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.GetChatsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChatsMethod(), responseObserver);
    }

    /**
     */
    public void updateMensage(ChatOuterClass.MessageRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMensageMethod(), responseObserver);
    }

    /**
     */
    public void deleteMesage(ChatOuterClass.MessageRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMesageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ChatOuterClass.MessageRequest,
                ChatOuterClass.SendMesageResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getGetMessegesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ChatOuterClass.GetMessagesRequest,
                ChatOuterClass.MessagesResponse>(
                  this, METHODID_GET_MESSEGES)))
          .addMethod(
            getCreateChatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChatOuterClass.CreateChatRequest,
                ChatOuterClass.CreateChatResponse>(
                  this, METHODID_CREATE_CHAT)))
          .addMethod(
            getGetChatsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ChatOuterClass.GetChatsRequest,
                ChatOuterClass.GetChatsResponse>(
                  this, METHODID_GET_CHATS)))
          .addMethod(
            getUpdateMensageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChatOuterClass.MessageRequest,
                ChatOuterClass.MessagesResponse>(
                  this, METHODID_UPDATE_MENSAGE)))
          .addMethod(
            getDeleteMesageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ChatOuterClass.MessageRequest,
                ChatOuterClass.MessagesResponse>(
                  this, METHODID_DELETE_MESAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatAdminStub extends io.grpc.stub.AbstractStub<ChatAdminStub> {
    private ChatAdminStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatAdminStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatAdminStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatAdminStub(channel, callOptions);
    }

    /**
     * <pre>
     * ENvia multiples mensjes al servidor
     * </pre>
     */
    public void sendMessage(ChatOuterClass.MessageRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.SendMesageResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Recupera múltipes mensajes del servidor _a partir de una fecha_
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ChatOuterClass.GetMessagesRequest> getMesseges(
        io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetMessegesMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *crea un chat
     * </pre>
     */
    public void createChat(ChatOuterClass.CreateChatRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.CreateChatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateChatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *recupera los chats en los que está incluido un usuairo
     * </pre>
     */
    public void getChats(ChatOuterClass.GetChatsRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.GetChatsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetChatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMensage(ChatOuterClass.MessageRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMensageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMesage(ChatOuterClass.MessageRequest request,
        io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMesageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatAdminBlockingStub extends io.grpc.stub.AbstractStub<ChatAdminBlockingStub> {
    private ChatAdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatAdminBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatAdminBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatAdminBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * ENvia multiples mensjes al servidor
     * </pre>
     */
    public java.util.Iterator<ChatOuterClass.SendMesageResponse> sendMessage(
        ChatOuterClass.MessageRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *crea un chat
     * </pre>
     */
    public ChatOuterClass.CreateChatResponse createChat(ChatOuterClass.CreateChatRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateChatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *recupera los chats en los que está incluido un usuairo
     * </pre>
     */
    public java.util.Iterator<ChatOuterClass.GetChatsResponse> getChats(
        ChatOuterClass.GetChatsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetChatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public ChatOuterClass.MessagesResponse updateMensage(ChatOuterClass.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMensageMethod(), getCallOptions(), request);
    }

    /**
     */
    public ChatOuterClass.MessagesResponse deleteMesage(ChatOuterClass.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMesageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatAdminFutureStub extends io.grpc.stub.AbstractStub<ChatAdminFutureStub> {
    private ChatAdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatAdminFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatAdminFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatAdminFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *crea un chat
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatOuterClass.CreateChatResponse> createChat(
        ChatOuterClass.CreateChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateChatMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatOuterClass.MessagesResponse> updateMensage(
        ChatOuterClass.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMensageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatOuterClass.MessagesResponse> deleteMesage(
        ChatOuterClass.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMesageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_CREATE_CHAT = 1;
  private static final int METHODID_GET_CHATS = 2;
  private static final int METHODID_UPDATE_MENSAGE = 3;
  private static final int METHODID_DELETE_MESAGE = 4;
  private static final int METHODID_GET_MESSEGES = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatAdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((ChatOuterClass.MessageRequest) request,
              (io.grpc.stub.StreamObserver<ChatOuterClass.SendMesageResponse>) responseObserver);
          break;
        case METHODID_CREATE_CHAT:
          serviceImpl.createChat((ChatOuterClass.CreateChatRequest) request,
              (io.grpc.stub.StreamObserver<ChatOuterClass.CreateChatResponse>) responseObserver);
          break;
        case METHODID_GET_CHATS:
          serviceImpl.getChats((ChatOuterClass.GetChatsRequest) request,
              (io.grpc.stub.StreamObserver<ChatOuterClass.GetChatsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MENSAGE:
          serviceImpl.updateMensage((ChatOuterClass.MessageRequest) request,
              (io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse>) responseObserver);
          break;
        case METHODID_DELETE_MESAGE:
          serviceImpl.deleteMesage((ChatOuterClass.MessageRequest) request,
              (io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse>) responseObserver);
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
        case METHODID_GET_MESSEGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getMesseges(
              (io.grpc.stub.StreamObserver<ChatOuterClass.MessagesResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getSendMessageMethod())
              .addMethod(getGetMessegesMethod())
              .addMethod(getCreateChatMethod())
              .addMethod(getGetChatsMethod())
              .addMethod(getUpdateMensageMethod())
              .addMethod(getDeleteMesageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
