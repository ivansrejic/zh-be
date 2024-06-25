package com.example.zhbe.entities;

import com.example.zhbe.util.OrderProductId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="orderproduct")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

}
