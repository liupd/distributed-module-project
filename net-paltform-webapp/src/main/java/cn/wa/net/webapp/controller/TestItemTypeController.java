package cn.wa.net.webapp.controller;


import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.TestItemTypeVo;
import cn.wa.net.interfaces.TestItemTypeServices;
import cn.wa.net.webapp.common.JsonHelp;
import cn.wa.net.webapp.utils.AjaxStatus;
import cn.wa.net.webapp.utils.JsonResult;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/testType/")
class TestItemTypeController {

    @com.alibaba.dubbo.config.annotation.Reference
    private TestItemTypeServices testItemTypeServices;

    @RequestMapping(value = "findTestItemByPage", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public String findTestItemByPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String isDelete = request.getParameter("isDelete");
        Map<String,String> queryMap = new HashMap<String,String>();
        queryMap.put("name",name);
        queryMap.put("isDelete",isDelete);
        Map<String, Object> currentParam = JsonHelp.parserPageParms(request);
        Integer current_size=(Integer)currentParam.get(JsonHelp.CURRENT_SIZE);
        Integer current_page=(Integer)currentParam.get(JsonHelp.CURRENT_PAGE);
        PageResultVo p = testItemTypeServices.findTestItemByPage(queryMap,current_page, current_size);
        return JsonHelp.getPageJson(p,current_page,current_size);
    }

    @RequestMapping(value = "addTestItem", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody String addTestItem(@RequestBody TestItemTypeVo testItemTypeVo,HttpSession session) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        Map map = testItemTypeServices.addTestItem(testItemTypeVo);
        if(map.size() > 0){
            result.setBean(map);
            result.setResultstr("success");
            return JSON.toJSONString(result);
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
            return JSON.toJSONString(result);
        }
    }

    @RequestMapping(value = "updateTestItem", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public  @ResponseBody String updateTestItem(@RequestBody TestItemTypeVo testItemTypeVo) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        Map  map = testItemTypeServices.updateTestItem(testItemTypeVo);
        if(map.size() > 0){
            result.setBean(map);
            result.setResultstr("success");
            return JSON.toJSONString(result);
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
            return JSON.toJSONString(result);
        }
    }

    //删除资源
    @RequestMapping(value = "/deleteTestItem", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody
    String deleteTestItem(HttpServletRequest request) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        String id = request.getParameter("id");
        String status=request.getParameter("status");
        if(StringUtils.isNotBlank(id)){
            testItemTypeServices.deleteTestItem(id, status);
            result.setResultstr("success");
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
        }
        return JSON.toJSONString(result);
    }
}
