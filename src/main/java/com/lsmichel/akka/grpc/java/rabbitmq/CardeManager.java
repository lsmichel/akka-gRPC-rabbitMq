

// Generated by Akka gRPC. DO NOT EDIT.
package com.lsmichel.akka.grpc.java.rabbitmq;

import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.stream.javadsl.Source;

import akka.grpc.ProtobufSerializer;
import akka.grpc.javadsl.GoogleProtobufSerializer;

public interface CardeManager {
  
  CompletionStage<com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed> postCard(com.lsmichel.akka.grpc.java.rabbitmq.Card in);
  

  static String name = "CardManager.CardeManager";

  public static class Serializers {
    
      public static ProtobufSerializer<com.lsmichel.akka.grpc.java.rabbitmq.Card> CardSerializer = new GoogleProtobufSerializer<>(com.lsmichel.akka.grpc.java.rabbitmq.Card.class);
    
      public static ProtobufSerializer<com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed> CardCreateActionPerformedSerializer = new GoogleProtobufSerializer<>(com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed.class);
    
  }
}