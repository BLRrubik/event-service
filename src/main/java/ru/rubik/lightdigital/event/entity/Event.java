package ru.rubik.lightdigital.event.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.organization.entity.Organization;
import ru.rubik.lightdigital.user.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

}
