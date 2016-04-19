package cn.wa.net.service;


import cn.wa.net.common.util.Constants;
import cn.wa.net.domain.Phases;
import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.PhasesVo;
import cn.wa.net.interfaces.PhasesServices;
import cn.wa.net.myBatisDao.PhasesDao;
import cn.wa.net.utils.BaseUtils;
import cn.wa.net.utils.IdSequence;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Administrator on 2016/3/17.
 **/
@Service
@Transactional(value = "transactionManager")
public class PhasesServicesImpl implements PhasesServices {
    @Resource
    private PhasesDao phasesDao;

    @Override
    public PageResultVo findPhasesByPage(Map<String, String> queryMap, int pageSize, int currentPage) {
        PageResultVo pageResultVo = new PageResultVo();
        List<PhasesVo> phasesVoList = new ArrayList<PhasesVo>();
        Page<Phases> page = new Page<Phases>(currentPage, pageSize);
        Phases phases = new Phases();
        phases.setName(queryMap.get("phasesName"));
        List<Phases> phasesList=phasesDao.selectListByPage(page,phases);

        for(Phases p:phasesList){
            PhasesVo phasesVo = new PhasesVo();
            phasesVo.setName(p.getName());
            phasesVo.setId(p.getId());
            phasesVoList.add(phasesVo);
        }
        pageResultVo.setResult(phasesVoList);
        pageResultVo.setTotal(page.getTotal());
        return pageResultVo;
    }

    @Override
    public String addPhases(PhasesVo resourcesVo) {
        // 属性拷贝
        Phases phases = new Phases();
        String key = IdSequence.nextId();
        phases.setId(key);
        phases.setBusinessKey(key);
        phases.setName(resourcesVo.getName());
        phases.setCreateTime(new Date());
        phases.setUpdateTime(new Date());
        phases.setIsDelete("N");
        phasesDao.insert(phases);
        return phases.getId();
    }

    @Override
    public String updatePhases(PhasesVo phasesVo) {

        Phases phases = phasesDao.selectById(phasesVo.getId());
        // 属性拷贝
        try {
            BaseUtils.convert(phasesVo, phases);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        phases.setUpdateTime(new Date());
        phasesDao.updateById(phases);
        return phases.getId();
    }

    @Override
    public boolean deletePhases(String id) {
        Phases phases = phasesDao.selectById(id);
        phases.setIsDelete("Y");
        phasesDao.updateById(phases);
        return true;
    }

    public PhasesVo findByKey(String key) {
        PhasesVo vo = new PhasesVo();
        Phases phases = new Phases();
        phases.setBusinessKey(key);
        phases = phasesDao.selectOne(phases);
        try {
            BaseUtils.convert(phases, vo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
