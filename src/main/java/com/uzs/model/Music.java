package com.uzs.model;

import com.uzs.to.FileTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String musicName;

    @NotBlank
    private String artist;

    private String description;

    private String urlAddress;

    private Integer duration;

    private Date uploadedDate;

    public FileTO toTO() {
        return new FileTO(getId(), getMusicName(), getUrlAddress(), getDuration(), getUploadedDate());
    }
}
