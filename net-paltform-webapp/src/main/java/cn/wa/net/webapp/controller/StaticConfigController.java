package cn.wa.net.webapp.controller;


import cn.wa.net.formbean.StaticConfigVo;
import cn.wa.net.service.StaticConfigServices;
import cn.wa.net.webapp.utils.AjaxStatus;
import cn.wa.net.webapp.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liupd on 2016/1/14 0014.
 **/
@RestController
@RequestMapping("/basic/")
public class StaticConfigController {

    @com.alibaba.dubbo.config.annotation.Reference
    private StaticConfigServices staticConfigServices;


    //获得资源分类类型列表
    @RequestMapping(value = "getAllResourceCategroy", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody JsonResult getAllResourceCategroy(){
        JsonResult result=new JsonResult(AjaxStatus.OK);
        try{
            List<StaticConfigVo> configVos=staticConfigServices.getAllResourceCategroy();
            result.setBean(configVos);
            result.setResultstr("success");
            return result;
        }catch (Exception e){
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
            return result;
        }

    }

    //获得教学资源类型列表
    @RequestMapping(value = "getAllResourceTeachType", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody JsonResult getAllResourceTeachType(){
        JsonResult result=new JsonResult(AjaxStatus.OK);
        try{
            List<StaticConfigVo> configVos=staticConfigServices.getAllResourceTeachType();
            result.setBean(configVos);
            result.setResultstr("success");
            return result;
        }catch (Exception e){
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
            return result;
        }

    }

    //获得电子教材类型列表
    @RequestMapping(value = "getAllEbookType", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody JsonResult getAllEbookType(){
        JsonResult result=new JsonResult(AjaxStatus.OK);
        try{
            List<StaticConfigVo> configVos=staticConfigServices.getAllEbookType();
            result.setBean(configVos);
            result.setResultstr("success");
            return result;
        }catch (Exception e){
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
            return result;
        }
    }

    //获得教材类型列表
    @RequestMapping(value = "getAllTextbookType", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody JsonResult getAllTextbookType(){
        JsonResult result=new JsonResult(AjaxStatus.OK);
        try{
            List<StaticConfigVo> configVos=staticConfigServices.getAllTextbookType();
            result.setBean(configVos);
            result.setResultstr("success");
            return result;
        }catch (Exception e){
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
            return result;
        }

    }

}
