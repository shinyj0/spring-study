package hello.core.member;


//interface 뒤에 imp이라고 많이 붙임 구연체가 하나만 있을때
public class MemberSeriviceImpl implements MemberService{

    //회원 찾으려면 memberrepository 필요함 그런데 인터페이스만 가지고 있으면 nullv 포인트 예외나옴
    //구연객체 선택해주어야함
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
//다형성에 의해서

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
