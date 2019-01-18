package com.duo.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class TbContentCategory {

    private Long id;
    private Long parentId;
    private String name;
    private int status;
    private String sortOrder;
    @JsonProperty("isParent")
    private boolean isParent;
    private Date created;
    private Date updated;


}
