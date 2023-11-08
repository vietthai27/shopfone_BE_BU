package com.thai27.shopfone_be_bu.Repository;

import com.thai27.shopfone_be_bu.Entity.ResetPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetPassRepo extends JpaRepository<ResetPass,Integer> {
}
