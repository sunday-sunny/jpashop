package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    //jpa가 제공하는 표준 어노테이션, 스프링이 em을 만들어서 주입
    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByname(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class
        )
                .setParameter("name", name)
                .getResultList();
    }

}
