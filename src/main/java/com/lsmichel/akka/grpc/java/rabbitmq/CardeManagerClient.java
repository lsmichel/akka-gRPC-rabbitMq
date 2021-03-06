

// Generated by Akka gRPC. DO NOT EDIT.
package com.lsmichel.akka.grpc.java.rabbitmq;

import akka.NotUsed;
import akka.Done;
import akka.annotation.*;
import akka.grpc.internal.*;
import akka.grpc.GrpcClientSettings;
import akka.grpc.javadsl.AkkaGrpcClient;
import akka.grpc.javadsl.SingleResponseRequestBuilder;
import akka.grpc.javadsl.StreamResponseRequestBuilder;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.OverflowStrategy;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.Materializer;

import io.grpc.*;

import static com.lsmichel.akka.grpc.java.rabbitmq.CardeManager.Serializers.*;


import java.util.concurrent.CompletionStage;
import scala.concurrent.ExecutionContext;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Future;
import scala.concurrent.Promise;


public abstract class CardeManagerClient extends CardeManagerClientPowerApi implements CardeManager, AkkaGrpcClient {
  public static final CardeManagerClient create(GrpcClientSettings settings, Materializer mat, ExecutionContext ec) {
    return new DefaultCardeManagerClient(settings, mat, ec);
  }

  protected final static class DefaultCardeManagerClient extends CardeManagerClient {

      private final ClientState clientState;
      private final GrpcClientSettings settings;
      private final CallOptions options;
      private final Materializer mat;
      private final ExecutionContext ec;

      private DefaultCardeManagerClient(GrpcClientSettings settings, Materializer mat, ExecutionContext ec) {
        this.settings = settings;
        this.mat = mat;
        this.ec = ec;
        this.clientState = new ClientState(settings, mat, ec);
        this.options = NettyClientUtils.callOptions(settings);

        if (mat instanceof ActorMaterializer) {
          ((ActorMaterializer) mat).system().getWhenTerminated().whenComplete((v, e) -> close());
        }
      }

  
    
      private final SingleResponseRequestBuilder<com.lsmichel.akka.grpc.java.rabbitmq.Card, com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed> postCardRequestBuilder(Future<ManagedChannel> channel){
        return new JavaUnaryRequestBuilder<>(postCardDescriptor, channel, options, settings, ec);
      }
    
  

      

        /**
         * For access to method metadata use the parameterless version of postCard
         */
        public CompletionStage<com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed> postCard(com.lsmichel.akka.grpc.java.rabbitmq.Card request) {
          return postCard().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer postCard(com.lsmichel.akka.grpc.java.rabbitmq.Card) if possible.
         */
        
          public SingleResponseRequestBuilder<com.lsmichel.akka.grpc.java.rabbitmq.Card, com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed> postCard()
        
        {
          return clientState.withChannel( this::postCardRequestBuilder);
        }
      

      
        private static MethodDescriptor<com.lsmichel.akka.grpc.java.rabbitmq.Card, com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed> postCardDescriptor =
          MethodDescriptor.<com.lsmichel.akka.grpc.java.rabbitmq.Card, com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("CardManager.CardeManager", "PostCard"))
            .setRequestMarshaller(new ProtoMarshaller<com.lsmichel.akka.grpc.java.rabbitmq.Card>(CardSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed>(CardCreateActionPerformedSerializer))
            .setSampledToLocalTracing(true)
            .build();
        

      /**
       * Initiates a shutdown in which preexisting and new calls are cancelled.
       */
      public CompletionStage<Done> close() {
        return clientState.closeCS() ;
      }

     /**
      * Returns a CompletionState that completes successfully when shutdown via close()
      * or exceptionally if a connection can not be established after maxConnectionAttempts.
      */
      public CompletionStage<Done> closed() {
        return clientState.closedCS();
      }
  }

}



