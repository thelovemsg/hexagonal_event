package com.msa.book.framework.jpaadapter;

import com.msa.book.domain.model.RentalCard;
import com.msa.book.domain.model.vo.RentalCardNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RentalCardRepository extends JpaRepository<RentalCard, RentalCardNo> {

    @Query("select m from RentalCard m where m.member.id = :id")
    Optional<RentalCard> findByMemberId(@Param("id") String memberId);

    @Query("select m from RentalCard m where m.rentalCardNo.no = :id")
    Optional<RentalCard> findById(@Param("id") Long rentalCardId);
}
