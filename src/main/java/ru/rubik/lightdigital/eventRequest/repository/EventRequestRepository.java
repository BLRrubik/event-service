package ru.rubik.lightdigital.eventRequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rubik.lightdigital.event.entity.Event;
import ru.rubik.lightdigital.eventRequest.entity.EventRequest;

import java.util.List;

public interface EventRequestRepository extends JpaRepository<EventRequest, Long> {
    List<EventRequest> findAllByEvent(Event event);
}
