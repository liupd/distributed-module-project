package cn.wa.net.webapp.common;


import cn.wa.net.formbean.PageResultVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liupd on 14-6-10.
 **/
public class JsonHelp {

    public final static String CURRENT_PAGE="currentPage";
    public final static String CURRENT_SIZE="currentSize";
    public final static String PAGE = "page";
    public final static String ROWS = "rows";

    public static  String getPageJson( PageResultVo p ,Integer page,Integer currentsize){
        Integer totalPage = (int)Math.ceil(Float.parseFloat(String.valueOf(p.getTotal())) / currentsize);
        StringBuffer sb =new StringBuffer();
        sb.append("{"+escapeDQ("page")+":"+page+",");
        sb.append(escapeDQ("records")+":"+p.getTotal()+",");
        sb.append(escapeDQ("total")+":"+totalPage+",");
        sb.append(escapeDQ("rows")+":"+ JSON.toJSONString(p.getResult(), SerializerFeature.WriteDateUseDateFormat)+"}");
        return sb.toString();
    }

    public static Map<String,Object> parserPageParms(HttpServletRequest request){
        Map<String,Object> pagemap=new HashMap<String,Object>();
        String page = request.getParameter(PAGE);
        String pageSize = request.getParameter(ROWS);
        pagemap.put(CURRENT_PAGE,"".equals(page) || page == null ? 1 : Integer.parseInt(page));
        pagemap.put(CURRENT_SIZE,"".equals(pageSize) || pageSize == null? 10 : Integer.parseInt(pageSize));
        return pagemap;
    }

    static  String escapeDQ(String str){
        return  '"'+str+'"';
    }

}
