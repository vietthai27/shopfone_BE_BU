package com.thai27.shopfone_be_bu.Repository;

import com.thai27.shopfone_be_bu.DTO.PhoneModelList;
import com.thai27.shopfone_be_bu.Entity.PhoneModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneModelRepo extends JpaRepository<PhoneModel, Integer> {

    @Query(value = "select * from phone_model where LOWER(phone_name) LIKE LOWER (concat('%', :search,'%')) ", nativeQuery = true)
    Page<PhoneModel> searchPhoneModel(@Param("search") String search, Pageable pageable);

    @Query(value = "select id as id , ROW_NUMBER() OVER(ORDER BY phone_price ASC) as rowNum, phone_name as phoneName, phone_price as phonePrice,phone_imei as phoneImei, sold_status as soldStatus from phone_model", nativeQuery = true)
    Page<PhoneModelList> getAllPhoneModel(Pageable pageable);
}
