package com.thai27.shopfone_be_bu.Controller;


import com.thai27.shopfone_be_bu.DTO.PhoneModelDetail;
import com.thai27.shopfone_be_bu.DTO.PhoneModelList;
import com.thai27.shopfone_be_bu.Entity.PhoneModel;
import com.thai27.shopfone_be_bu.Exception.ResourceNotFoundException;
import com.thai27.shopfone_be_bu.Exception.UnclearSortingDirectionException;
import com.thai27.shopfone_be_bu.ServiceImplement.PhoneModelSrvImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phoneModel")
public class PhoneModelController {

    @Autowired
    PhoneModelSrvImp phoneModelSrvImp;

    @GetMapping("/get/getPhoneModelById/{phoneId}")
    public PhoneModelDetail getPhoneModelById(@PathVariable int phoneId) throws ResourceNotFoundException {
        return phoneModelSrvImp.getPhoneModelById(phoneId);
    }

    @GetMapping("/get/getPhoneModel")
    Page<PhoneModelList> getAllPhoneModelPaging(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                                @RequestParam String sortBy, @RequestParam String sortDirection) throws UnclearSortingDirectionException {
        return phoneModelSrvImp.getAllPhoneModelPaging(pageNum, pageSize, sortBy, sortDirection);
    }

    @GetMapping("/get/searchPhoneModel")
    Page<PhoneModel> searchPhoneModel(@RequestParam String search, @RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize, @RequestParam String sortBy, @RequestParam String sortDirection)
            throws UnclearSortingDirectionException {
        return phoneModelSrvImp.searchPhoneModel(search, pageNum, pageSize, sortBy, sortDirection);
    }

    @PostMapping("/transaction/addPhoneModel")
    String addPhoneModel(@RequestBody PhoneModel phoneModel, @RequestParam Integer phoneLineId)
            throws ResourceNotFoundException {
        return phoneModelSrvImp.addPhoneModel(phoneModel, phoneLineId);
    }

    @PutMapping("/transaction/editPhoneModel")
    String editPhoneModel(@RequestParam int phoneId, @RequestBody PhoneModel phoneModel, @RequestParam int newLineId)
            throws ResourceNotFoundException {
        return phoneModelSrvImp.editPhoneModel(phoneId, phoneModel, newLineId);
    }

    @DeleteMapping("/deletePhoneModel/{phoneId}")
    String deletePhoneModel(@PathVariable int phoneId) {
        return phoneModelSrvImp.deletePhoneModel(phoneId);

    }
}
