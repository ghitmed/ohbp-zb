package com.p2ohbpzabokradno.ohbp.repository;

import com.p2ohbpzabokradno.ohbp.model.CaseOhbp;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CaseOhbpRepository extends JpaRepository <CaseOhbp, Integer>{
    Page<CaseOhbp> findByPatientLastNameContainsIgnoreCase(String keyword, Pageable pageable);

}
