package com.bodax.home.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class Category {

    @Id
    private Long id;
    private Long oldId;
    private LocalDateTime tCreated;
    private LocalDateTime tUpdated;
    private Long parentId;
    private String status;
    private Integer sort;

}
