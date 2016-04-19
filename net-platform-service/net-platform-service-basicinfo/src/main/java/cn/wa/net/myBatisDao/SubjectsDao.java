package cn.wa.net.myBatisDao;

import cn.wa.net.domain.Subjects;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by liupd on 2016/3/15.
 **/
public interface SubjectsDao  extends AutoMapper<Subjects>{

    public  int deleteSubjects(String id, String status);

    public List<Subjects> selectListForPage(Page page, Subjects subjects);

    public List<Map<String,Object>> findAllSubject();

}
