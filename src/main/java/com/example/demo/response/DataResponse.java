package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataResponse<T> {
    private String message = "Success";
    private T data;

    public DataResponse(T data) {
        this.data = data;
    }
}
