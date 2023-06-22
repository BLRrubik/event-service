package ru.rubik.lightdigital.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rubik.lightdigital.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
