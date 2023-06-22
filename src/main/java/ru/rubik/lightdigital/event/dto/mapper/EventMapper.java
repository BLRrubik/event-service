package ru.rubik.lightdigital.event.dto.mapper;

import ru.rubik.lightdigital.event.dto.EventDto;
import ru.rubik.lightdigital.event.entity.Event;
import ru.rubik.lightdigital.user.dto.UserDto;

public class EventMapper {
    public static EventDto toDto(Event event) {
        return new EventDto(
                event.getTitle(),
                event.getMinAge(),
                event.getPrice(),
                new UserDto(
                        event.getAuthor().getUsername()
                )
        );
    }
}
