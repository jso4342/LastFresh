package com.example.lastfresh.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_BILLS")
@Getter
@ToString
@NoArgsConstructor
public class BillVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_ORDER_NUM")
    private Long billOrderNum;
    @Column(name = "BILL_DELIVERY_ADDRESS")
    private String billDeliveryAddress;
    @Column(name = "BILL_DELIVERY_ADDRESS_DETAIL")
    private String billDeliveryAddressDetail;
    @Column(name = "BILL_DELIVERY_ADDRESS_POST_NUM")
    private String billDeliveryAddressPostNum;
    @Column(name = "BILL_TOTAL_PRICE")
    private Long billTotalPrice;
    @Column(name = "BILL_ORDER_DATE")
    private Date billOrderDate;

    @ManyToOne // 다대일
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @Builder

    public BillVO(Long billOrderNum, String billDeliveryAddress, String billDeliveryAddressDetail, String billDeliveryAddressPostNum, Long billTotalPrice, Date billOrderDate) {
        this.billOrderNum = billOrderNum;
        this.billDeliveryAddress = billDeliveryAddress;
        this.billDeliveryAddressDetail = billDeliveryAddressDetail;
        this.billDeliveryAddressPostNum = billDeliveryAddressPostNum;
        this.billTotalPrice = billTotalPrice;
        this.billOrderDate = billOrderDate;
    }
}
