package com.study.kanapka.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GuestDTO {
    private Long id;
    private String firstName;
    private String secondName;
    private String phone;
    private String roomNumber;
}
