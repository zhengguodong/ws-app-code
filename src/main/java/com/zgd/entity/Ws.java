package com.zgd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2022-03-21
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("ws")
@ApiModel(value="Ws对象", description="")
public class Ws implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "账号")
      private String username;

      @ApiModelProperty(value = "密码")
      private String password;

      @ApiModelProperty(value = "用户名")
      private String name;

      @ApiModelProperty(value = "性别")
      private String gender;

    private String content;

      @ApiModelProperty(value = "签名")
      private String autograph;

      @ApiModelProperty(value = "邮箱")
      private String email;

      @ApiModelProperty(value = "生日")
      private Date birthday;

      @ApiModelProperty(value = "头像")
      private String portrait;


}
