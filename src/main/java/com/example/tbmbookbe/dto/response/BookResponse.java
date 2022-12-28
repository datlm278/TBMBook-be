package com.example.tbmbookbe.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private Integer id;
    private String name;
    private String author;
    private String unitPrice;
    private String year;
    private Integer typeId;
    private Integer producerId;
}
