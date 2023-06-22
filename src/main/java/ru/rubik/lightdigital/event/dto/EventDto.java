package ru.rubik.lightdigital.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.user.dto.UserDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private String title;
    private Integer minAge;
    private Float price;
    private UserDto author;
}
