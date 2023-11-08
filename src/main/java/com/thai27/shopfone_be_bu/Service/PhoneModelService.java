package com.thai27.shopfone_be_bu.Service;


import com.thai27.shopfone_be_bu.DTO.PhoneModelDetail;
import com.thai27.shopfone_be_bu.DTO.PhoneModelList;
import com.thai27.shopfone_be_bu.Entity.PhoneModel;
import com.thai27.shopfone_be_bu.Exception.ResourceNotFoundException;
import com.thai27.shopfone_be_bu.Exception.UnclearSortingDirectionException;
import org.springframework.data.domain.Page;

public interface PhoneModelService {

    PhoneModelDetail getPhoneModelById(int phoneModelId) throws ResourceNotFoundException;

    Page<PhoneModelList> getAllPhoneModelPaging(Integer pageNum, Integer pageSize, String sortBy, String sortDirection) throws UnclearSortingDirectionException;

    Page<PhoneModel> searchPhoneModel(String search, Integer pageNum, Integer pageSize, String sortBy, String sortDirection) throws UnclearSortingDirectionException;

    String addPhoneModel(PhoneModel phoneModel, int phoneLineId) throws ResourceNotFoundException;

    String editPhoneModel(int phoneId, PhoneModel phoneModel, int newPhoneLineId) throws ResourceNotFoundException;

    String deletePhoneModel(int phoneId);
}
