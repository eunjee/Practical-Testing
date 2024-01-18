package sample.cafekiosk.api.service.order;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sample.cafekiosk.api.domain.order.OrderRepository;
import sample.cafekiosk.api.domain.product.Product;
import sample.cafekiosk.api.domain.product.ProductRepository;
import sample.cafekiosk.api.domain.product.ProductSellingStatus;
import sample.cafekiosk.api.domain.product.ProductType;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderStatisticsServiceTest {
    @Autowired
    private OrderStatisticsService orderStatisticsService;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @AfterEach
    void tearDown(){
        orderRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
    }
    @DisplayName("결제완료 주문들을 조회하여 매출 통계 메일을 전송한다.")
    @Test
    void sendOrderStatisticsMail(){
        //given
        //when
        //then
    }

    private Product createProduct(ProductType type, String productNumber, int price){
        return Product.builder()
                .type(type)
                .productNumber(productNumber)
                .price(price)
                .sellingStatus(ProductSellingStatus.SELLING)
                .name("메뉴 이름")
                .build();
    }

}