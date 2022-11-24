package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)  // default (fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL : 순서로 들어가기때문에 가급적 사용 X
    private OrderStatus orderStatus;

    // 양방향 연관관계 매핑 : 꼭 필요한것은 아니다
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // default (fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    // 양방향 연관관계 편의 메서드(Order - OrderItem, 1 : N)
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  // default (fetch = FetchType.EAGER)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;
}
