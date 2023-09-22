package com.project.springapistudy.controller.dto;

import com.project.springapistudy.entity.MenuEntity;
import com.project.springapistudy.entity.MenuType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class MenuDto {
    private String name; // 메뉴명
    private Integer price;// 가격
    private MenuType menuType;// 메뉴 카테고리


    public MenuEntity toEntity(){
        return MenuEntity.builder().name(name).price(price).menuType(menuType).build();
    }

}
