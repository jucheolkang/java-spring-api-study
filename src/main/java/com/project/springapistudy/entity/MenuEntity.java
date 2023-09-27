package com.project.springapistudy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true)
    private String name; // 메뉴명
    @Column(nullable = true)
    private Integer price;// 가격
    @Column(nullable = true)
    private MenuType menuType;// 메뉴 카테고리
    public void update(String name, Integer price, MenuType menuType){
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

}
