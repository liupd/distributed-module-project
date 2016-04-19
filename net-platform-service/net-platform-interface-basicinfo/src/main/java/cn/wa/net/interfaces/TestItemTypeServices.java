package cn.wa.net.interfaces;


import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.TestItemTypeVo;

import java.util.Map;

/**
 * Created by Administrator on 2015/6/26
 * 试题类型 services
 **/
public interface TestItemTypeServices {

    public PageResultVo findTestItemByPage(Map<String, String> queryMap, int currentPage, int pageSize);

    Map addTestItem(TestItemTypeVo testItemTypeVo);

    Map updateTestItem(TestItemTypeVo testItemTypeVo);

    boolean deleteTestItem(String id, String status);

}