package ru.rubik.lightdigital.event.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventCreateRequest {
    private String title;
    private Integer minAge;
    private Float price;
    private String inn;
}
