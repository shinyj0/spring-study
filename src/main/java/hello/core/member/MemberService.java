package hello.core.member;


//회원가입, 회원조회

//인터페이스 먼저 만들고 구연체 만들기
public interface MemberService {

    void join(Member member);

    Member findMember (Long memberId);

}


