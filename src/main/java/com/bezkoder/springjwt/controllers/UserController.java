package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.RolesUserModule;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.RolesUserModuleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.response.BaseResponse;
import com.bezkoder.springjwt.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RolesUserModuleRepository rolesUserModuleRepository;

    @GetMapping("/{id}/roles")
    public ResponseEntity<BaseResponse> getRolesUserModule(@PathVariable(value = "id") Long id) {
        DataResponse dataResponse = new DataResponse(0, "Không lấy được danh sách quyền từ tài khoản");
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            dataResponse = new DataResponse(1, "Danh sách quyền từ tài khoản "+user.getUsername());
            dataResponse.setData(user);
//            List<RolesUserModule> rolesUserModule = rolesUserModuleRepository.findAllByUser(user);
//            dataResponse.setDatas(rolesUserModule);
        }else{
            dataResponse = new DataResponse(0, "Tài khoản không tồn tại!!!");
        }
        return ResponseEntity.ok(dataResponse);
    }
}
