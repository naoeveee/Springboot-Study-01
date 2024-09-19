package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository MemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        MemberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        MemberRepository.save(member);

        Member result =MemberRepository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        MemberRepository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        MemberRepository.save(member2);

        Member result= MemberRepository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        MemberRepository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        MemberRepository.save(member2);

        List<Member> result = MemberRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
