package cn.wa.net.service;


import cn.wa.net.domain.Subjects;
import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.SubjectsVo;
import cn.wa.net.interfaces.SubjectServices;
import cn.wa.net.myBatisDao.SubjectsDao;
import cn.wa.net.utils.EntityUtils;
import cn.wa.net.utils.IdSequence;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/15.
 **/
@Service
@Transactional(value = "transactionManager")
public class SubjectServicesImpl implements SubjectServices {

    @Resource
    private SubjectsDao subjectsDao;

    /**
     * 分页查询，返回domain的list
     * @param queryMap
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageResultVo findSubjectByPage(Map<String, String> queryMap, int currentPage, int pageSize) {
        PageResultVo pageResultVo = new PageResultVo();
        Page<Subjects> page = new Page<Subjects>(currentPage,pageSize);

        Subjects subjects = new Subjects();
        subjects.setIsDelete(queryMap.get("isDelete"));
        subjects.setName(queryMap.get("name"));

        List<Subjects> list = subjectsDao.selectListForPage(page,subjects);
        List<SubjectsVo> vos = new ArrayList<SubjectsVo>();
        for(Subjects s : list){
            SubjectsVo vo = new SubjectsVo();
            vo= EntityUtils.copyProperties(vo.getClass(), s);
            vos.add(vo);
        }
        pageResultVo.setResult(vos);
        pageResultVo.setTotal(page.getTotal());
        return pageResultVo;
    }

    @Override
    public int addSubject(SubjectsVo subjectVo) {
        Subjects subjects = new Subjects();
        subjects=EntityUtils.copyProperties(subjects.getClass(),subjectVo);
        subjects.setId(IdSequence.nextId());
        subjects.setBusinessKey(subjects.getId());
        subjects.setCreateTime(new Date());
        subjects.setUpdateTime(new Date());
        return subjectsDao.insert(subjects);
    }

    @Override
    public int updateSubject(SubjectsVo subjectVo) {
        Subjects subjects = new Subjects();
        subjects=EntityUtils.copyProperties(subjects.getClass(),subjectVo);
        return subjectsDao.updateById(subjects);
    }

    @Override
    public int deleteSubject(String id, String status) {
        return subjectsDao.deleteSubjects(id,status);
    }

    @Override
    public SubjectsVo findByKey(String key) {
        Subjects subjects = new Subjects();
        subjects.setBusinessKey(key);
        Subjects s = subjectsDao.selectOne(subjects);
        SubjectsVo vo = new SubjectsVo();
        vo=EntityUtils.copyProperties(vo.getClass(),s);
        return vo;
    }

    @Override
    public SubjectsVo findByName(String name) {
        Subjects subjects = new Subjects();
        subjects.setName(name);
        Subjects s = subjectsDao.selectOne(subjects);
        if(s==null){
            return  null;
        }
        SubjectsVo vo = new SubjectsVo();
        vo=EntityUtils.copyProperties(vo.getClass(),s);
        return vo;
    }
}
