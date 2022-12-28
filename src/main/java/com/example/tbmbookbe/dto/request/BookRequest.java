package com.example.tbmbookbe.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private Integer id;
    private String name;
    private String author;
    private String unitPrice;
    private String year;
    private Integer typeId;
    private Integer producerId;
}
