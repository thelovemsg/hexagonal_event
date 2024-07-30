package com.msa.book.framework.kafkaadapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.book.application.usecase.MakeAvailableUsecase;
import com.msa.book.application.usecase.MakeUnavailableUsecase;
import com.msa.book.domain.model.event.ItemRented;
import com.msa.book.domain.model.event.ItemReturned;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BookEventConsumers {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MakeAvailableUsecase makeAvailableUsecase;
    private final MakeUnavailableUsecase makeUnavailableUsecase;

    @KafkaListener(topics = "${consumer.topic1.name}" ,groupId = "${consumer.groupid.name}")
    public void consumeRental(ConsumerRecord<String, String> record) throws IOException {
        System.out.println("rental_rent: " + record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        makeUnavailableUsecase.makeUnavailable(Long.valueOf(itemRented.getItem().getNo()));
    }

    @KafkaListener(topics = "${consumer.topic2.name}", groupId = "${consumer.groupid.name}")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException {
        System.out.println("return_rent: " + record.value());
        ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        makeAvailableUsecase.makeAvailable(Long.valueOf(itemReturned.getItem().getNo()));
    }

}
