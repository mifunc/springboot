package com.rumenz.lession5.controller;

import com.rumenz.lession5.controller.component.AnnotationComponent;
import com.rumenz.lession5.controller.entity.Rumenz;
import com.rumenz.lession5.controller.repository.RumenzRepository;
import com.rumenz.lession5.controller.service.AnnotationRumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @className: AnnotationRumenController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com 微信公众号:入门小站
 * @date: 2021/11/2
 **/

@PropertySource(value = "classpath:rumenz.properties",encoding = "UTF-8")
@Controller //标注是一个控制层类
@RequestMapping("/rumenz") //下面的所有的请求都会带上此前缀
public class AnnotationRumenController {


    @RequestMapping("/index")
    public String index(){
        //错误示例,会返回错误页面
        //默认会去src/main/resources/templates路径找"入门小站.html"页面,不存在就报错
        return "入门小站";
    }

    @RequestMapping("/index1")
    public String index1(){
        //src/main/resources/templates目录下存在"index1.html"页面,所有会成功返回页面
        return "index1";
    }

    @RequestMapping("/index2")
    @ResponseBody
    public String index2(){
        //如果只想返回"入门小站"这几个字符串,则需要加上@ResponseBody注解
        return "入门小站";
    }

    @RequestMapping(value = "/index3",method = RequestMethod.GET,consumes = "application/json")
    @ResponseBody
    public String index3(){
        //设置了请求头中Content-Type中必须包含application/json
        //直接用浏览器请求会报错,返回415错误码
        //用PostMan测试设置上Content-Type=application/json
        return "入门小站,rumenz.com";
    }


    @RequestMapping(value = "/index4",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String index4(){
        //使用PostMan测试设置 Accept=text/plain 请求失败,不会返回数据
        //使用PostMan测试设置 Accept=application/json 请求成功,返回数据
        return "入门小站,rumenz.com";
    }

    @RequestMapping(value = "/index5",method = RequestMethod.GET,params = "name=rumenz.com")
    @ResponseBody
    public String index5(){
        //直接用浏览器请求,会报400的错误

        //用浏览器请求加上?name=rumenz.com就会成功
        return "入门小站,rumenz.com";
    }


    @RequestMapping(value = "/index6",method = RequestMethod.GET,headers = "token=rumenz.com")
    @ResponseBody
    public String index6(){
        //直接用浏览器请求会报错,因为请求头中没有设置token,会报404错误
        //用PostMan请求设置token=rumenz.com
        return "入门小站,rumenz.com";
    }




    @RequestMapping(value = "/index7/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String index7(@PathVariable("id") Integer id){
        //从URI中获取参数值
        return "入门小站,rumenz.com"+id;
    }


    @RequestMapping(value = "/index8",method = RequestMethod.GET)
    @ResponseBody
    public String index8(@RequestParam Integer id){
        //从请求HTTP请求头中
        return "入门小站,rumenz.com"+id;
    }


    @ModelAttribute
    void setAttribute(HttpServletRequest request){
        //@ModelAttribute`注解的方法将在每次调用该控制器类的请求处理方法前被调用
        request.setAttribute("name", "rumenz.com");
    }

    @RequestMapping("/index9")
    @ResponseBody
    public String index9(@RequestAttribute("name") String name){
        //`@RequestAttribute`注解取的参数是项目中解析出来的。不是从前端传过来的。可以通过`ModeAttribute`或`HandlerInterceptor`中预存。
        return "入门小站,rumenz.com::"+name;
    }


    @Autowired
    private AnnotationRumenService annotationRumenService;

    @RequestMapping("/index10")
    @ResponseBody
    public String index10(){
        //@Service层方法返回
        return annotationRumenService.index10();
    }



    @Autowired
    private AnnotationComponent annotationComponent;

    @RequestMapping("/index11")
    @ResponseBody
    public String index11(){
        //@Component 定义的数据
        return annotationComponent.index11();
    }

    @Autowired
    private String index12;


    @RequestMapping("/index12")
    @ResponseBody
    public String index12(){
        //@Bean注入的数据
        return index12;
    }

    @Autowired
    private RumenzRepository annotationRepository;

    @RequestMapping("/index13")
    @ResponseBody
    public List<Rumenz> index13(){
        //@Repository 查询数据库返回的数据
        List<Rumenz> list = annotationRepository.getList();
        System.err.println("list"+list.size());
        list.forEach(item->{
            System.out.println(item.toString());
        });
        return list;
    }
    @Value("${rumenz.name}")
    private String name;

    @Value("${rumenz.url}")
    private String url;

    @RequestMapping(value = "/index14",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String index14(){
        //通过@Value注入配置文件中定义的值
        return name+"::::"+url;
    }


}
