package com.project.springapistudy.controller;

import com.project.springapistudy.controller.dto.MenuDto;
import com.project.springapistudy.controller.dto.MenuListResponseDto;
import com.project.springapistudy.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping()
    public String save(@RequestBody MenuDto requestDto){
        return menuService.save(requestDto);
    }


    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody MenuDto requestDto){
        return menuService.update(id,requestDto);
    }

    @GetMapping("/{id}")
    public MenuListResponseDto findById(@PathVariable Integer id){
        return menuService.findById(id);
    }
}
