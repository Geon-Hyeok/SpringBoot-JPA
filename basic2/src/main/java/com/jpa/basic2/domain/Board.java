package com.jpa.basic2.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "JPA_BOARD")
@Data
public class Board {
    @GeneratedValue
    @Id private Long id;
    private String title;
    private String content;
     @ManyToOne // 다대일 연관관계 매핑
     @JoinColumn(name = "USER_ID") // 외래키로 사용할 컬럼명을 매핑한다.
     private User user;
}










