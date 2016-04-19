package cn.wa.net.webapp.controller;


import cn.wa.net.common.util.Constants;
import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.SubjectsVo;
import cn.wa.net.interfaces.SubjectServices;
import cn.wa.net.webapp.common.JsonHelp;
import cn.wa.net.webapp.utils.AjaxStatus;
import cn.wa.net.webapp.utils.JsonResult;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/25 0025.
 **/
@RestController
@RequestMapping("/subject/")
class SubjectsController {

    @com.alibaba.dubbo.config.annotation.Reference
    private SubjectServices subjectServices;
    @RequestMapping(value = "findSubjectByPage", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody String findSubjectByPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String isDelete = request.getParameter("isDelete");
        Map<String,String> queryMap = new HashMap<String,String>();
        queryMap.put("name",name);
        queryMap.put("isDelete",isDelete);
        Map<String, Object> currentParam = JsonHelp.parserPageParms(request);
        Integer current_size=(Integer)currentParam.get(JsonHelp.CURRENT_SIZE);
        Integer current_page=(Integer)currentParam.get(JsonHelp.CURRENT_PAGE);
        PageResultVo p = subjectServices.findSubjectByPage(queryMap,current_page, current_size);
        return JsonHelp.getPageJson(p, current_page,current_size);
    }

    //添加资源
    @RequestMapping(value = "addSubjects", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody JsonResult addPhases(HttpServletRequest request,HttpSession session) {
        String name = request.getParameter("name");
        //String userBusinessKey = (String)session.getAttribute(Constants.user_key);
        SubjectsVo subjectVo= new SubjectsVo();
        subjectVo.setName(name);
        subjectVo.setUserBusinessKey(Constants.user_key);
        subjectVo.setIsDelete("N");
        SubjectsVo subjectsVo = subjectServices.findByName(name);
        if(null != subjectsVo){
            return new JsonResult(AjaxStatus.ERROR);
        }
        int map = subjectServices.addSubject(subjectVo);
        if(map>0){
            return new JsonResult(AjaxStatus.OK);
        }else{
            return new JsonResult(AjaxStatus.ERROR);
        }
    }

    //添加资源
    @RequestMapping(value = "updateSubjects", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public JsonResult updatePhases(HttpServletRequest request,HttpSession session) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        SubjectsVo subjectsVo= new SubjectsVo();
        subjectsVo.setName(name);
        subjectsVo.setUserBusinessKey(Constants.user_key);
        subjectsVo.setId(id);
        int  no = subjectServices.updateSubject(subjectsVo);
        if(no > 0){
            return new JsonResult(AjaxStatus.OK);

        }else{
            return new JsonResult(AjaxStatus.ERROR);
        }
    }

    //删除资源
    @RequestMapping(value = "/deleteSubjects", method = RequestMethod.POST,produces ="application/json;charset=UTF-8")
    public @ResponseBody String deletePhases(HttpServletRequest request) {
        JsonResult result=new JsonResult(AjaxStatus.OK);
        String id = request.getParameter("id");
        String status=request.getParameter("status");
        if(StringUtils.isNotBlank(id)){
            subjectServices.deleteSubject(id,status);
            result.setResultstr("success");
        }else{
            result.setStatus(AjaxStatus.ERROR);
            result.setResultstr("fail");
        }
        return JSON.toJSONString(result);
    }


}
