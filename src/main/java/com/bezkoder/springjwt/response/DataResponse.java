/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.springjwt.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author HIEU
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> extends BaseResponse {
    private T data;
    private List<T> datas;

    public DataResponse(T data) {
        this.data = data;
    }

    public DataResponse(List<T> datas) {
        this.datas = datas;
    }

    public DataResponse(Integer code, String message) {
        super(code, message);
    }

}
