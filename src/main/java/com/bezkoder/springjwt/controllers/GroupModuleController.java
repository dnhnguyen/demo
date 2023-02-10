package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.GroupModule;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.response.BaseResponse;
import com.bezkoder.springjwt.repository.GroupModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/module")
public class GroupModuleController {

    @Autowired
    GroupModuleRepository groupModuleRepository;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public String allAccess() {
        return "List module";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse> add(@Valid @RequestBody GroupModule groupModule) {

        if (groupModuleRepository.existsByName(groupModule.getName())) {
            return ResponseEntity.ok(new BaseResponse(0,"Module đã tồn tại"));
        }

        System.out.println(groupModule.toString());
        groupModuleRepository.save(groupModule);
        return ResponseEntity.ok(new BaseResponse(1,"Thêm mới module thành công"));
    }
}
