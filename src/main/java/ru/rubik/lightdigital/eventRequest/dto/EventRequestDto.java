package ru.rubik.lightdigital.eventRequest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.event.dto.EventDto;
import ru.rubik.lightdigital.eventRequest.entity.enums.EventRequestStatus;
import ru.rubik.lightdigital.user.dto.UserDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDto {
    private Long id;
    private String fullname;
    private Integer age;
    private Boolean pcr;
    private EventRequestStatus status;
    private UserDto author;
    private EventDto event;
}
