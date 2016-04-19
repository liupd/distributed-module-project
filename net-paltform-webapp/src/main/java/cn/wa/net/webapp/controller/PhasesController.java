package cn.wa.net.webapp.controller;


import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.PhasesVo;
import cn.wa.net.interfaces.PhasesServices;
import cn.wa.net.webapp.common.JsonHelp;
import cn.wa.net.webapp.utils.AjaxStatus;
import cn.wa.net.webapp.utils.JsonResult;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liupd on 2016/4/18.
 **/
@RestController
@RequestMapping("/phases/")
public class PhasesController {

    @Reference
    private PhasesServices phasesServices;

    //website  http://localhost:8086/net-platform-webapp/phases/findPhasesByPage?rows=10&page=1
    @RequestMapping(value = "findPhasesByPage", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody String findPhasesByPage(HttpServletRequest request) {
        String phasesName = request.getParameter("phasesName");
        Map<String,String> queryMap = new HashMap<String,String>();
        queryMap.put("phasesName",phasesName);
        Map<String, Object> currentParam = JsonHelp.parserPageParms(request);
        Integer current_size=(Integer)currentParam.get(JsonHelp.CURRENT_SIZE);
        Integer current_page=(Integer)currentParam.get(JsonHelp.CURRENT_PAGE);
        PageResultVo p = phasesServices.findPhasesByPage(queryMap,current_size, current_page);
        return JsonHelp.getPageJson(p, current_page,current_size);
    }

    //添加学段
    @RequestMapping(value = "addPhases", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String addPhases(@RequestBody PhasesVo phasesVo) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        //String userBusinessKey = (String)request.getSession().getAttribute("userBusinessKey");
        if(null!=phasesVo){
            String id=phasesServices.addPhases(phasesVo);
            result.setBean(id);
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
        }
        return JSON.toJSONString(result);
    }

    //添加学段
    @RequestMapping(value = "updatePhases", method = RequestMethod.POST)
    public @ResponseBody String updatePhases(@RequestBody PhasesVo phasesVo) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        if(null!=phasesVo){
            String id=phasesServices.updatePhases(phasesVo);
            result.setBean(id);
            result.setResultstr("success");
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
        }
        return JSON.toJSONString(result);
    }

    //删除学段
    @RequestMapping(value = "/deletePhases", method = RequestMethod.POST)
    public @ResponseBody String deletePhases(HttpServletRequest request) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        String id = request.getParameter("id");
        if(StringUtils.isNotBlank(id)){
            phasesServices.deletePhases(id);
            result.setResultstr("success");
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
        }
        return JSON.toJSONString(result);
    }


}
