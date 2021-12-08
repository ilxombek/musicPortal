package com.uzs.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileTO implements Serializable {
    private Integer id;
    private String musicName;
    private String urlAddress;
    private Integer duration;
    private Date uploadedDate;
}
