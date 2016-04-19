package cn.wa.net.interfaces;


import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.PhasesVo;

import java.util.Map;

/**
 * Created by liupd on 2016/3/17.
 * 学段 services
 **/
public interface PhasesServices{

    public PageResultVo findPhasesByPage(Map<String,String> queryMap,int pageSize,int currentPage);

    public String addPhases(PhasesVo phasesVo);

    public String updatePhases(PhasesVo phasesVo);

    boolean deletePhases(String id);

    public PhasesVo findByKey(String key);
}
