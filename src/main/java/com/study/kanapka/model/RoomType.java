package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "room_types")
public class RoomType {

    @Id
    @GeneratedValue(generator = "sec_room_type", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_room_type", sequenceName = "sec_room_type",allocationSize=1)
    private Long id;

    @Column(name = "type", nullable = false, length = 60)
    private String roomType;
}
