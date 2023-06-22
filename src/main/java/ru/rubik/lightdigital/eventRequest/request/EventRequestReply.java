package ru.rubik.lightdigital.eventRequest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.eventRequest.entity.enums.EventRequestStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestReply {
    private EventRequestStatus status;
}
