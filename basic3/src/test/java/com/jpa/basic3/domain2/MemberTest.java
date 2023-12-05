package com.jpa.basic3.domain2;

import com.jpa.basic3.embedded.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional @Commit
class MemberTest {
    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Address address = new Address("강남구", "1101호", "111222");
//        address.setAddress("강남구");
//        address.setAddressDetail("1011호");
//        address.setZipcode("111222");

        Member member = new Member();
        member.setName("홍길동");
        member.setAddress(address);

        entityManager.persist(member);

        Member member2 = new Member();
        member2.setName("김철수");
        member2.setAddress(new Address("강북구", "100호", "11111"));

        entityManager.persist(member2);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void save() {

    }

    @Test
    void equal() {
        Address address = new Address("강북구", "100호", "11111");
        Member foundMember = entityManager.find(Member.class, 2L);
        System.out.println("isTrue : " + address.equals(foundMember.getAddress()));
    }

}