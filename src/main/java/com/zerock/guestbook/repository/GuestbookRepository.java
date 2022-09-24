package com.zerock.guestbook.repository;

import com.zerock.guestbook.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * packageName : com.zerock.guestbook.repository
 * className : GuestbookRepository
 * user : jwlee
 * date : 2022/09/23
 */
public interface GuestbookRepository extends JpaRepository<Guestbook, Long>, QuerydslPredicateExecutor<Guestbook> {
}
