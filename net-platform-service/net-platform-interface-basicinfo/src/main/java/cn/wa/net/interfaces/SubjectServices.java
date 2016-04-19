package cn.wa.net.interfaces;


import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.SubjectsVo;

import java.util.Map;

/**
 * Created by liupd on 2015/6/25 .
 * 学科 services
 **/
public interface SubjectServices {

    public PageResultVo findSubjectByPage(Map<String, String> queryMap, int currentPage, int pageSize);

    int addSubject(SubjectsVo subjectVo);

    int updateSubject(SubjectsVo subjectVo);

    int deleteSubject(String id, String status);

    public SubjectsVo findByKey(String key);

    public SubjectsVo findByName(String name);
}