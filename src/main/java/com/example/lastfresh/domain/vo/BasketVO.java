package com.example.lastfresh.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Entity
@Table(name = "tbl_basket")
@Getter
@Setter
@ToString(of={"basketNum", "basketQuantity", "basketDeliveryMethod", "basketGoOrder", "basketPrice"})
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
    /* 0주문선택X, 1주문선택O */
    @Column(name = "BASKET_GO_ORDER")
    private Long basketGoOrder;
    /*총 금액*/
    @Column(name = "BASKET_PRICE")
    private Long basketPrice;

    @ManyToOne
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @ManyToOne
    @JoinColumn(name = "SELL_PRODUCT_NUM")
    private ProductVO productVO;

    @Builder
    public BasketVO(Long basketNum, Long basketQuantity, String basketDeliveryMethod, Long basketGoOrder, UserVO userVO, ProductVO productVO) {
        this.basketNum = basketNum;
        this.basketQuantity = basketQuantity;
        this.basketDeliveryMethod = basketDeliveryMethod;
        this.basketGoOrder = basketGoOrder;
        this.userVO = userVO;
        this.productVO = productVO;
    }

}
