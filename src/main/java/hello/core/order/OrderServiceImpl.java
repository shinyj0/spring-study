package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy= new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//ctrl aLT V
        int discountPrice = discountPolicy.discount(member, itemPrice);
    //오더는 할인은 모름 디스카운트가 알아서 해 할인 변경은 할인만 고치면됨 주문 말고..
        //단일책임원칙 잘 지킴
        return new Order(memberId,itemName,itemPrice,discountPrice);
        //최종적으로 할인된 가격

    }
}
