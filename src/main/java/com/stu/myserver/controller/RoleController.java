package com.stu.myserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.PathVariable;
import com.stu.myserver.service.IRoleService;
import com.stu.myserver.entity.Role;
import com.stu.myserver.utils.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 
 * </p>
 *
 * @author 程序员小明1024
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    // 新增或者更新
    /***********************************
     * 用途说明:
     * @param role
     * 返回值说明:
     * @return R
     ***********************************/
    @PostMapping("add")
    public R add(@RequestBody Role role){
        boolean result= roleService.save(role);
        if(result){
            return R.ok().message(ResultCodeEnum.SUCCESS.getMessage());
        }else{
            return R.error().message(ResultCodeEnum.UPDATE_ERROR.getMessage());
        }
    }

    /***********************************
     * 用途说明:
     * @param id
     * 返回值说明:
     * @return R
     ***********************************/
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        boolean result= roleService.removeById(id);
        if(result){
            return R.ok().message(ResultCodeEnum.SUCCESS.getMessage());
        }else{
            return R.error().message(ResultCodeEnum.UPDATE_ERROR.getMessage());
        }
    }

    /***********************************
     * 用途说明:
     * @param ids
     * 返回值说明:
     * @return R
     ***********************************/
    @PostMapping("/del/batch")
    public R deleteBatch(@RequestBody List<Integer> ids){
        boolean result=  roleService.removeByIds(ids);
        if(result){
            return R.ok().message(ResultCodeEnum.SUCCESS.getMessage());
        }else{
            return R.error().message(ResultCodeEnum.UPDATE_ERROR.getMessage());
        }
    }

    /***********************************
     * 用途说明:
     * @param:
     * 返回值说明:
     * @return R
     ***********************************/
    @GetMapping
    public R findAll(){
        return  R.ok().data("data", roleService.list());
    }

    /***********************************
     * 用途说明:
     * @param id
     * 返回值说明:
     * @return R
     ***********************************/
    @GetMapping("/{id}")
    public R findOne(@PathVariable Integer id){
        return R.ok().data("data", roleService.getById(id));
    }

    /***********************************
     * 用途说明:
     * @param pageNum pageSize role
     * 返回值说明:
     * @return  R
     ***********************************/
    @PostMapping("/page")
    public R findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestBody Role role){
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return R.ok().data("data", roleService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }
}

