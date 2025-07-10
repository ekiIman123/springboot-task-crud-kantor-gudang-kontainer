package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> {
    private String message = "Success";
    private List<T> data;

    public ListResponse(List<T> data) {
        this.data = data;
    }
}
