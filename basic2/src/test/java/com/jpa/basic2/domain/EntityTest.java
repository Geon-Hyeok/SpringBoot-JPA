package com.jpa.basic2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional @Commit
class EntityTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test @DisplayName("양방향 참조")
    void save2(){
        User user = new User();
        user.setLoginId("aaa");
        user.setName("홍길동");
        user.setPassword("1234");
        user.setAge(22);

        Board board1 = new Board();
        board1.setTitle("ㅎㅇ");
        board1.setContent("반가워요~");
        board1.setUser(user);

        Board board2 = new Board();
        board2.setTitle("ㅎㅇ");
        board2.setContent("반가워요~");
        board2.setUser(user);


        entityManager.persist(user);
        entityManager.persist(board1);
        entityManager.persist(board2);

        entityManager.flush();
        entityManager.clear();

        User foundUser = entityManager.find(User.class, 1L);
        List<Board> boardList = foundUser.getBoard();
        boardList.forEach(System.out::println);

        Board newBoard = new Board();
        newBoard.setTitle("test");
        newBoard.setContent("test");
        boardList.add(newBoard);
//        연관관계의 주인이 아닌 boardList를 통해
//        데이터를 추가하는 것은 불가능하다.(오류 안나고 무시)
    }


    @Test
    void save(){
        User user = new User();
        user.setLoginId("aaa");
        user.setName("홍길동");
        user.setPassword("1234");
        user.setAge(22);

        Board board1 = new Board();
        board1.setTitle("ㅎㅇ");
        board1.setContent("반가워요~");

        Board board2 = new Board();
        board2.setTitle("ㅎㅇ");
        board2.setContent("반가워요~");

        user.getBoard().add(board1);
        user.getBoard().add(board2);

        entityManager.persist(user);
        entityManager.persist(board1);
        entityManager.persist(board2);
    }


//    @Test
//    void save(){
//        User user = new User();
//        user.setLoginId("aaa");
//        user.setName("홍길동");
//        user.setPassword("1234");
//        user.setAge(22);
//
//        Board board1 = new Board();
//        board1.setTitle("ㅎㅇ");
//        board1.setContent("반가워요~");
//        board1.setUser(user);
//
//        Board board2 = new Board();
//        board2.setTitle("ㅎㅇ");
//        board2.setContent("반가워요~");
//        board2.setUser(user);
//
//        entityManager.persist(user);
//        entityManager.persist(board1);
//        entityManager.persist(board2);
//
//    }
//
//    @Test
//    void find(){
//        Board board = entityManager.find(Board.class, 2L);
//        User user = board.getUser(); // 객체 그래프 탐색
//        System.out.println("user = " + user);
//    }
//
//    @Test
//    void find2(){
//        List<Board> boardList = entityManager.createQuery("select b from Board b " +
//                "join b.user u where u.name = :name", Board.class)
//                .setParameter("name", "홍길동")
//                .getResultList();
//
//        boardList.forEach(System.out::println);
//    }
//
//    @Test
//    void update(){
//        User user = new User();
//        user.setLoginId("bbb");
//        user.setName("이유리");
//        user.setPassword("1234");
//        user.setAge(11);
//
////        새로운 회원 정보 등록
//        entityManager.persist(user);
//
////        2번 게시물 조회
//        Board board = entityManager.find(Board.class, 2L);
//        board.setUser(user);
//    }
//
//    @Test
//    void remove(){
//        User user = entityManager.find(User.class, 1L);
//
//        String query = "select b from Board b where b.user.id = :userId";
//
//        Board board = entityManager
//                .createQuery(query, Board.class)
//                .setParameter("userId", 1L)
//                .getSingleResult();
//
//        board.setUser(null); // 연관관계 해제
//
//        entityManager.remove(user);
//    }
}

















