package jpabook.jpashop;

import jpabook.jpashop.domain.Album;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin(); // db 트랜젝션을 시작

        try {
//            // 주문생성
//            Order order = new Order();
//            order.setOrderStatus(OrderStatus.ORDER);
//            em.persist(order);
//
//            // 주문상품 1 생성
//            OrderItem orderItem1 = new OrderItem();
//            orderItem1.setOrderPrice(1);
//            orderItem1.setCount(1);
//            orderItem1.setOrder(order);
//
//            // 주문상품 2 생성
//            OrderItem orderItem2 = new OrderItem();
//            orderItem2.setOrderPrice(2);
//            orderItem2.setCount(2);
//            orderItem2.setOrder(order);
//
//            em.persist(orderItem1);
//            em.persist(orderItem2);
//
//            em.flush();
//            em.clear();


//            // 상속관계 매핑 테스트
//            // movie insert
//            Movie movie = new Movie();
//            movie.setActor("actor1");
//            movie.setDirector("director1");
//            movie.setName("name~");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//            // Album insert
//            Album album = new Album();
//            album.setName("album name");
//            album.setPrice(20000);
//            album.setArtist("album artist");
//            em.persist(album);
//
//            // book insert
//            Book book = new Book();
//            book.setIsbn("isbn");
//            book.setAuthor("book author");
//            book.setPrice(222);
//            book.setName("book name");
//            em.persist(book);
//
//            em.flush();
//            em.clear();
//
//            // movie 조회
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
//
//            // album 조회
//            Album findAlbum = em.find(Album.class, album.getId());
//            System.out.println("findAlbum = " + findAlbum);
//
//            // book 조회
//            Book findBook = em.find(Book.class, book.getId());
//            System.out.println("findBook = " + findBook);

            tx.commit();    // 커밋
        } catch (Exception e) {
            tx.rollback();  // 롤백
        } finally {
            em.close();
        }

        emf.close();

    }
}

