package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    // 양방향 연관관계 매핑 : 꼭 필요한것은 아니다
    @OneToMany(mappedBy = "member")  // default (fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    // 양방향 연관관계 편의 메서드(Member - Order, 1 : N)
    public void addOrder(Order order) {
        orders.add(order);
        order.setMember(this);
    }

    private String name;
    private String city;
    private String street;
    private String zipCode;
}
