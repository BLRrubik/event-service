package ru.rubik.lightdigital.eventRequest.dto.mapper;

import ru.rubik.lightdigital.event.dto.mapper.EventMapper;
import ru.rubik.lightdigital.eventRequest.dto.EventRequestDto;
import ru.rubik.lightdigital.eventRequest.entity.EventRequest;
import ru.rubik.lightdigital.user.dto.UserDto;

public class EventRequestMapper {
    public static EventRequestDto toDto(EventRequest request) {
        return new EventRequestDto(
                request.getId(),
                request.getFullname(),
                request.getAge(),
                request.getPcr(),
                request.getStatus(),
                new UserDto(
                        request.getAuthor().getUsername()
                ),
                EventMapper.toDto(request.getEvent())
        );
    }
}
