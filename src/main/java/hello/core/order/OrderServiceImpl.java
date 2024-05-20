package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //현재는 dip지키고 있음
    private final MemberRepository memberRepository ;//= new MemoryMemberRepository();
    private final  DiscountPolicy discountPolicy;

    //rate, fix중 뭐가 들어올지 모름
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //    private final DiscountPolicy discountPolicy= new FixDiscountPolicy();
    //추상에만 의존해야하는데 구체에도 의존

    //private final RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();


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
