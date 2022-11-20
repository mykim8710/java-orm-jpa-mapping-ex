package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;

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

            tx.commit();    // 커밋
        } catch (Exception e) {
            tx.rollback();  // 롤백
        } finally {
            em.close();
        }

        emf.close();

    }
}

