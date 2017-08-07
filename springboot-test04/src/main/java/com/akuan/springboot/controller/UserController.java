package com.akuan.springboot.controller;

import com.akuan.springboot.entity.UserEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: UserController
 * @Description: UserController
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午2:45
 * @version: V1.0
 */
@Api(value = "用户controller", tags = "用户", position = 0)
@RestController
@RequestMapping("/user")
public class UserController {
//    @Api：用在类上，说明该类的作用
//    @ApiOperation：用在方法上，说明方法的作用
//    @ApiImplicitParams：用在方法上包含一组参数说明
//    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
//    paramType：参数放在哪个地方
//    header-->请求参数的获取：@RequestHeader
//    query-->请求参数的获取：@RequestParam
//    path（用于restful接口）-->请求参数的获取：@PathVariable
//    body（不常用）
//    form（不常用）
//    name：参数名
//    dataType：参数类型
//    required：参数是否必须传
//    value：参数的意思
//    defaultValue：参数的默认值
//    @ApiResponses：用于表示一组响应
//    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
//    code：数字，例如400
//    message：信息，例如"请求参数没填好"
//    response：抛出异常的类
//    @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
//    @ApiModelProperty：描述一个model的属性
    private static ConcurrentHashMap<Long, UserEntity> map = new ConcurrentHashMap<>();

    /**
     * 增
     *
     * @param userEntity
     */
    @ApiOperation(value = "新增用户", notes = "add user")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserEntity postUser(@ModelAttribute("userEntity") UserEntity userEntity) {
        if (userEntity != null) {
            map.put(userEntity.getId(), userEntity);
        }
        return userEntity;

    }

    /**
     * 删
     *
     * @param id
     */
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @ApiImplicitParam(value = "用户ID", name = "id", required = true, dataType = "java.lang.Long", defaultValue = "1", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserEntity deleteUser(@PathVariable("id") Long id) {
        return map.remove(id);
    }

    /**
     * 改
     *
     * @param id
     * @param userEntity
     */
    @ApiOperation(value = "更新用户", notes = "根据ID更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户ID", name = "id", required = true, dataType = "java.lang.Long", defaultValue = "1", paramType = "path")
    }
    )
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserEntity postUser(@PathVariable("id") Long id, @ModelAttribute("userEntity") UserEntity userEntity) {
        return map.put(id, userEntity);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询用户", notes = "根据ID查询用户")
    @ApiImplicitParam(value = "用户ID", name = "id", required = true, dataType = "java.lang.Long", defaultValue = "1", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id) {
        return map.get(id);
    }

    /**
     * 批量查
     *
     * @return
     */
    @ApiOperation(value = "批量查询用户", notes = "批量查询用户")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserEntity> listUser() {
        return new ArrayList<>(map.values());
    }


}
