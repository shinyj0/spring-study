package hello.core.member;

public interface MemberRepository {


    void save(Member member); //회원 저장
    //회원의 아이디 찾는 기능
    Member findById(Long memberId);

}
