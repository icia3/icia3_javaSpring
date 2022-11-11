package com.jsframe.cumarket.repository;

import com.jsframe.cumarket.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
