package cn.wa.net.myBatisDao;

import cn.wa.net.domain.Phases;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

/**
 * PhasesMapper数据库操作接口类
 */
public interface PhasesDao extends AutoMapper<Phases> {

    public List<Map<String, Object>> findAllPhases();

    public List<Phases> selectListByPage(Page<Phases> pagePhase, Phases phases);

}