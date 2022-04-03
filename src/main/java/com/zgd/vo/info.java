package com.zgd.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class info {
    private Integer id;
    private String name;
    private String email;
    private String autograph;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;


}
