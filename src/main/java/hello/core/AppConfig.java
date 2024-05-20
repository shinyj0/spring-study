package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberSeriviceImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//환경 구성에 대한 것은 여기서 댜
public class AppConfig {

    //생성자 주입
    public MemberService memberService(){
        return new MemberSeriviceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
