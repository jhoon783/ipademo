package com.example.ipademo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // getter, setter 생성
@AllArgsConstructor //생성자 생성
@NoArgsConstructor //기본생성자 생성
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 타입일치
    private int id;

    private String name;
    private String email;

    @Column(name = "create_at")// DB에 저장되있는 이름과 여기에 이름과 같다는 것을 알려줌
    private LocalDateTime createAt;

    @Column(name = "create_by")
    private String createBy;
}
