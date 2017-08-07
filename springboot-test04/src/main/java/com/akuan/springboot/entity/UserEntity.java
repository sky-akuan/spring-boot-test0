package com.akuan.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: UserEntity
 * @Description: UserEntity
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午2:41
 * @version: V1.0
 */
@ApiModel(value = "user", description = "用户实体")
@Data
public class UserEntity {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("性别")
    private Integer sex;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("地址")
    private String address;
}
