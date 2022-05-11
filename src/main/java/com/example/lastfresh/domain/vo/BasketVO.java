package com.example.lastfresh.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_BASKET")
@Getter
@ToString
@NoArgsConstructor
public class BasketVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BASKET_NUM")
    private Long basketNum;
    @Column(name = "BASKET_QUANTITY")
    private Long basketQuantity;
    /*1픽업 2배달 3배송*/
    @Column(name = "BASKET_DELIVERY_METHOD")
    private String basketDeliveryMethod;

    @ManyToOne // 다대일
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @ManyToOne // 다대일
    @JoinColumn(name = "SELL_PRODUCT_NUM")
    private ProductVO productVO;

    @Builder
    public BasketVO(Long basketNum, Long basketQuantity, String basketDeliveryMethod) {
        this.basketNum = basketNum;
        this.basketQuantity = basketQuantity;
        this.basketDeliveryMethod = basketDeliveryMethod;
    }
}
