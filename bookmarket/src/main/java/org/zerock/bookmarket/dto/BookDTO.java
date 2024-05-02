package org.zerock.bookmarket.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String id;
    private String name;
    private String description;
    private String category;
    private String author;
    private String publisher;
    private String releaseDate;
    private int pages;
    private int unitPrice;
    private int unitInStock;
    private String imageFileName;
    private LocalDate createDate;

}
