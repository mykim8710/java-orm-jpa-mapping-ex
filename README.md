Java ORM JPA - example Project
- Project 요구사항
  - 회원은 상품을 주문할 수 있다.
  - 주문 시 여러종류의 상품을 선택 할 수 있다.

- 기능 목록
  - **회원기능(Member)**
    - 회원등록
    - 회원조회
  - **상품기능(Item)**
    - 상품등록
    - 상품수정
    - 상품조회
  - **주문기능(Order)**
    - 상품주문
    - 주문내역조회
    - 주문취소

- 도메인 모델 분석
  - 회원과 주문의 관계
    - 회원은 여러 번 주문할 수 있다.
    - **Member - Order, 1 : N**
  - 주문과 상품의 관계
    - 주문 할 때 여러상품을 선택할 수 있다.
    - 반대로 같은 상품도 여러 번 주문될 수 있다.
    - 주문상품 이라는 모델을 만들어서 다대다 관계를 일다대, 다대일 관계로 풀어냄
    - **Orders - Item, N : N  ⇒  Order - OrderItem, 1 : N  |  OrderItem - Item, N : 1**

- 연관관계 매핑
  - Order - Member    |  N : 1, 양방향 매핑
  - OrderItem - Order |  N : 1, 양방향 매핑
  - Item - OrderItem  |  N : 1, 단방향 매핑
  - Order - Delivery  |  1 : 1, 양방향 매핑
  - Item - Category   |  N : M, 양방향 매핑

- 고급매핑
  - 상속관계 매핑
    - Item - Album, Book, Movie
  - @MappedSuperclass : BaseEntity