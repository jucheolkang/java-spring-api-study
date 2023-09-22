package com.project.springapistudy.entityTest;

import com.project.springapistudy.entity.MenuEntity;
import com.project.springapistudy.entity.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static com.project.springapistudy.entity.MenuType.COFFEE;

@SpringBootTest
@Transactional
@Rollback(false)
public class MenuEntityTest {
    @Autowired
    MenuRepository menuRepository;

    @Test
    public void saveTest(){
        MenuEntity menuEntity = MenuEntity.builder()
                .name("아메리카노")
                .price(4000)
                .menuType(COFFEE)
                .build();
        MenuEntity savedMenuEntity = menuRepository.save(menuEntity);
        Assertions.assertEquals("아메리카노",savedMenuEntity.getName() );
        Assertions.assertEquals(4000, savedMenuEntity.getPrice());
        Assertions.assertEquals(COFFEE, savedMenuEntity.getMenuType());


    }
}
