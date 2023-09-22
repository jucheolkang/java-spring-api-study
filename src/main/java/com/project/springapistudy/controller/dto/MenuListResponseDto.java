package com.project.springapistudy.controller.dto;

import com.project.springapistudy.entity.MenuEntity;
import com.project.springapistudy.entity.MenuType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@AllArgsConstructor
public class MenuListResponseDto {
    private Integer id;
    private String name; // 메뉴명
    private Integer price;// 가격
    private MenuType menuType;// 메뉴 카테고리

    public MenuListResponseDto(MenuEntity menuEntity){
        this.id = menuEntity.getId();
        this.name = menuEntity.getName();
        this.price = menuEntity.getPrice();
        this.menuType = menuEntity.getMenuType();
    }

}
