package hello.core.order;

public interface OrderService {

    //최종order전달
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
