package com.jpa.basic2.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Table(name = "JPA_MEMBER")
@SequenceGenerator(
        name = "SEQ_MEMBER_GENERATOR",
        sequenceName = "SEQ_JPA_MEMBER"
)
public class Member {
    @Id @GeneratedValue(generator = "SEQ_MEMBER_GENERATOR")
    private Long id;
    private String name;
    private String address;
//    @ManyToMany @JoinColumn(name = "MEMBER_ID")
//    @JoinTable(
//            name = "JPA_ORDER", //연결시킬 테이블 지정(중간 테이블)
//            joinColumns = @JoinColumn(name = "MEMBER_ID"), // 회원과 매핑할 컬럼 지정
//            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID") // 반대쪽(상품)과 매핑할 컬럼
//    ) // 이렇게 설정하면 중간테이블인 ORDER 엔티티 없이 연결이 가능하다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
















