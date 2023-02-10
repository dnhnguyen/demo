/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.springjwt.response;

import lombok.Data;

/**
 *
 * @author HIEU
 */
@Data
public class BaseResponse {

    private Integer code = 1;
    private String message = "Success";

    public BaseResponse() {
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
