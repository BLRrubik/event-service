package ru.rubik.lightdigital.eventRequest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.event.entity.Event;
import ru.rubik.lightdigital.eventRequest.entity.enums.EventRequestStatus;
import ru.rubik.lightdigital.user.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_requests")
public class EventRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_request_id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "pcr")
    private Boolean pcr = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EventRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
