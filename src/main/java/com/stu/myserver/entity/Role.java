package com.stu.myserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 程序员小明1024
 * @since 2023-06-28
 */
@Getter
@Setter
  @TableName("acl_role")
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("角色id")
        private String id;

      @ApiModelProperty("角色名称")
      private String roleName;

      @ApiModelProperty("角色编码")
      private String roleCode;

      @ApiModelProperty("备注")
      private String remark;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      private Integer isDeleted;

      @ApiModelProperty("创建时间")
      private LocalDateTime gmtCreate;

      @ApiModelProperty("更新时间")
      private LocalDateTime gmtModified;


}
