package org.zerock.applicationtest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDTO {

    private int no;
    private String title;
    private String text;
    private String subtext;
    private String schedule;
    private String img;
    private Date create_date;

}
