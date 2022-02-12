package com.rumenz.lession9.controller;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/10
 **/
@RestController
@RequestMapping("/rumenz")
//@Api用在类上,用于说明类功能的说明
@Api(tags = "入门小站Controller入口",value = "页面上看不见的内容")
public class RumenzController {

    @GetMapping("/index")
    public String index(){
        return "入门小站";
    }

    @GetMapping("/user")
    @ApiOperation(value = "方法的作用说明",notes = "方法的备注说明")
    //传入参数说明
    @ApiImplicitParams({@ApiImplicitParam(name = "page",value = "当前页"),@ApiImplicitParam(name = "pageSize",value = "分页大小")})
    //说明请求返回的状态码及描述
    @ApiResponses({@ApiResponse(code = 200,message = "成功"),@ApiResponse(code=201,message = "参数错误")})
    public String index1(@ApiParam("页数") @RequestParam("page") Integer page,@ApiParam("每页条数") Integer pageSize){
        return "入门小站";
    }

    @PostMapping("/save")
    @ApiOperation("保存用户")
    public String save(@RequestBody User user){
        return "入门小站";
    }

}
@Data
@NoArgsConstructor
@AllArgsConstructor
//描述实体类
@ApiModel("用戶信息")
class User {
    //描述实体类的属性
    @ApiModelProperty(value = "名字",name = "name",example = "入门小站")
    private String name;

    @ApiModelProperty(value = "年龄",name="age",example = "20")
    private Integer age;

    @ApiModelProperty(value = "地址",name="address",example = "rumenz.com")
    private String address;

    @ApiModelProperty(value = "邮箱",name="email",example = "372669319@qq.com")
    private String email;

}