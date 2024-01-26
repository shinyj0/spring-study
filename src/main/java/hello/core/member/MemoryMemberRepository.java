package hello.core.member;

import java.util.HashMap;
import java.util.Map;


//테스트용으로만 써야함
public class MemoryMemberRepository implements MemberRepository {

    //저장소이니 map만들기
    private static Map<Long, Member> store = new HashMap<>();//사실은 concurrnet해시맵을 써야함
    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //원래는 오류처리해야하지만 너무 복잡해질까봐

    }

    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }
}
