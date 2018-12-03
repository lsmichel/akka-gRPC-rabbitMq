/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsmichel.akka.grpc.java.rabbitmq.services;

import akka.actor.ActorRef;
import akka.pattern.PatternsCS;
import akka.util.Timeout;
import com.lsmichel.akka.grpc.java.rabbitmq.Card;
import com.lsmichel.akka.grpc.java.rabbitmq.CardCreateActionPerformed;
import com.lsmichel.akka.grpc.java.rabbitmq.CardeManager;
import com.lsmichel.akka.grpc.java.rabbitmq.message.ICardMessages.CardCreate;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import scala.concurrent.duration.Duration;

/**
 *
 * @author lathsessakpamichel
 */
public class CardManagerImpl implements CardeManager{
final private ActorRef cardRegistryActor;
final Timeout timeout = new Timeout(Duration.create(200000, TimeUnit.SECONDS));
public CardManagerImpl(ActorRef cardRegistryActor){
    this.cardRegistryActor=cardRegistryActor;
}
    @Override
    public CompletionStage<CardCreateActionPerformed> postCard(Card card) {
     CompletionStage<CardCreateActionPerformed> cardCreated = PatternsCS
                                .ask(cardRegistryActor, new CardCreate (card), timeout)
                                .thenApply(obj ->(CardCreateActionPerformed) obj);
                                
     return cardCreated;           
        
    }
    
}
