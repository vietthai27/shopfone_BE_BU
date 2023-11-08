package com.thai27.shopfone_be_bu.ServiceImplement;


import com.thai27.shopfone_be_bu.DTO.PhoneModelDetail;
import com.thai27.shopfone_be_bu.DTO.PhoneModelList;
import com.thai27.shopfone_be_bu.Entity.PhoneModel;
import com.thai27.shopfone_be_bu.Exception.ResourceNotFoundException;
import com.thai27.shopfone_be_bu.Exception.UnclearSortingDirectionException;
import com.thai27.shopfone_be_bu.Repository.PhoneLineRepo;
import com.thai27.shopfone_be_bu.Repository.PhoneModelRepo;
import com.thai27.shopfone_be_bu.Security.JWTUltil;
import com.thai27.shopfone_be_bu.Service.PhoneModelService;
import com.thai27.shopfone_be_bu.Ulti.GenerateRandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneModelSrvImp implements PhoneModelService {

    @Autowired
    PhoneModelRepo phoneModelRepo;

    @Autowired
    PhoneLineRepo phoneLineRepo;

    @Autowired
    GenerateRandomString generateIMEI;

    @Autowired
    JWTUltil jwtUltil;

    @Override
    public PhoneModelDetail getPhoneModelById(int phoneModelId) throws ResourceNotFoundException {
        if (!phoneModelRepo.existsById(phoneModelId))
            throw new ResourceNotFoundException("Không tồn tại mẫu điện thoại với id " + phoneModelId);
        else {
            Optional<PhoneModel> modelInfo = Optional.of(new PhoneModel());
            modelInfo = phoneModelRepo.findById(phoneModelId);
            PhoneModelDetail modelDetail = new PhoneModelDetail();
            modelDetail.setId(modelInfo.get().getId());
            modelDetail.setPhoneName(modelInfo.get().getPhoneName());
            modelDetail.setPhonePrice(modelInfo.get().getPhonePrice());
            modelDetail.setPhoneImei(modelInfo.get().getPhoneImei());
            modelDetail.setSoldStatus(modelInfo.get().getSoldStatus());
            modelDetail.setLineName(modelInfo.get().getPhoneLine().getLineName());
            modelDetail.setBrandName(modelInfo.get().getPhoneLine().getPhoneBrand().getBrandName());
            return modelDetail;
        }

    }

    @Override
    public Page<PhoneModelList> getAllPhoneModelPaging(Integer pageNum, Integer pageSize, String sortBy,
                                                       String sortDirection) throws UnclearSortingDirectionException {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.by(Direction.ASC, sortBy));
        ;
        return phoneModelRepo.getAllPhoneModel(pageRequest);

    }

    @Override
    public Page<PhoneModel> searchPhoneModel(String search, Integer pageNum, Integer pageSize, String sortBy,
                                             String sortDirection) throws UnclearSortingDirectionException {
        PageRequest pageRequest;
        switch (sortDirection) {
            case "ASC":
                pageRequest = PageRequest.of(pageNum, pageSize, Sort.by(Direction.ASC, sortBy));
                break;
            case "DESC":
                pageRequest = PageRequest.of(pageNum, pageSize, Sort.by(Direction.DESC, sortBy));
                break;
            default:
                throw new UnclearSortingDirectionException("Không hiểu kiểu sắp xếp " + sortDirection);
        }
        return phoneModelRepo.searchPhoneModel(search, pageRequest);
    }

    @Override
    public String addPhoneModel(PhoneModel phoneModel, int phoneLineId) throws ResourceNotFoundException {
        if (!phoneLineRepo.existsById(phoneLineId)) {
            throw new ResourceNotFoundException("Không tồn tại dòng điện thoại với id " + phoneLineId);
        }
        PhoneModel newPhoneModel = new PhoneModel();
        if (phoneModel.getPhoneImei().isEmpty()) {
            newPhoneModel.setPhoneImei(generateIMEI.generateRandomCode(8));
        } else {
            newPhoneModel.setPhoneImei(phoneModel.getPhoneImei());
        }
        newPhoneModel.setPhoneName(phoneModel.getPhoneName());
        newPhoneModel.setPhonePrice(phoneModel.getPhonePrice());
        newPhoneModel.setSoldStatus(false);
        newPhoneModel.setPhoneLine(phoneLineRepo.getReferenceById(phoneLineId));
        phoneModelRepo.save(newPhoneModel);
        return "Đã tạo mới mẫu điện thoại";


    }

    @Override
    public String editPhoneModel(int phoneId, PhoneModel phoneModel, int newPhoneLineId)
            throws ResourceNotFoundException {
        if (!phoneModelRepo.existsById(phoneId))
            throw new ResourceNotFoundException("Không tồn tại mẫu điện thoại với id " + phoneId);
        if (!phoneLineRepo.existsById(newPhoneLineId))
            throw new ResourceNotFoundException("Không tồn tại dòng điện thoại với id " + newPhoneLineId);
        PhoneModel newPhoneModel = phoneModelRepo.findById(phoneId).orElse(null);
        newPhoneModel.setPhoneImei(phoneModel.getPhoneImei());
        newPhoneModel.setPhoneName(phoneModel.getPhoneName());
        newPhoneModel.setPhonePrice(phoneModel.getPhonePrice());
        newPhoneModel.setSoldStatus(phoneModel.getSoldStatus());
        newPhoneModel.setSoldStatus(false);
        newPhoneModel.setPhoneLine(phoneLineRepo.getReferenceById(newPhoneLineId));
        phoneModelRepo.save(newPhoneModel);
        return "Đã sửa mẫu điện thoại";
    }

    @Override
    public String deletePhoneModel(int phoneId) {
        phoneModelRepo.deleteById(phoneId);
        return "Đã xóa mẫu điện thoại";
    }

}
