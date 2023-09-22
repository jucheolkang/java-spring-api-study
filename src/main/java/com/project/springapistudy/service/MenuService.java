package com.project.springapistudy.service;

import com.project.springapistudy.entity.MenuEntity;
import com.project.springapistudy.entity.MenuRepository;
import com.project.springapistudy.controller.dto.MenuDto;
import com.project.springapistudy.controller.dto.MenuListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public String save(MenuDto menuDto){
        return menuRepository.save(menuDto.toEntity()).toString();
    }

    @Transactional
    public String update(Integer id, MenuDto menuDto){
        MenuEntity menuEntity = menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. .id = "+id));
        menuEntity.update(menuDto.getName(),menuDto.getPrice(),menuDto.getMenuType());
        return menuDto.toString();
    }


    public MenuListResponseDto findById (Integer id){
        MenuEntity entity = menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id =" + id));
        return new MenuListResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MenuListResponseDto> findAllDesc(){
        return menuRepository.findAllDesc().stream().map(MenuListResponseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public void delete (Integer id){
        MenuEntity posts = menuRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 id가 없습니다. id=" + id));
        menuRepository.delete(posts);

    }





}
