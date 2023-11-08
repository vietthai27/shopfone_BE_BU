package com.thai27.shopfone_be_bu.Repository;

import com.thai27.shopfone_be_bu.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    List<UserRole> findByRolename(String userRole);
}
