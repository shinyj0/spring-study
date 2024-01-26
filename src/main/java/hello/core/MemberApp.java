package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSeriviceImpl;
import hello.core.member.MemberService;

public class MemberApp {

    //psvm enter
    public static void main(String[] args) {
        MemberService memberService = new MemberSeriviceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());//soutv

        System.out.println("findMember = " + findMember.getName());//sout

        //매번확인해야함 그래서 junit



    }
}
