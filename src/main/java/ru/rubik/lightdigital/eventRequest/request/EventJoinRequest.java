package ru.rubik.lightdigital.eventRequest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventJoinRequest {
    private Long eventId;
    private String fullname;
    private Integer age;
    private Boolean pcr;
}
