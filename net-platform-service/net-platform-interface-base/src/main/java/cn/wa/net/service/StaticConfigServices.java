package cn.wa.net.service;

import cn.wa.net.formbean.StaticConfigVo;

import java.util.List;

/**
 * Created by liupd on 16-4-15.
 **/
public interface StaticConfigServices {

    /**
     * 获取所有的种类
     * @return
     */
    public List<StaticConfigVo> getAllCategroy();

    /**
     * 获得所有的试题类型
     * @return
     */
    public List<StaticConfigVo> getAllQuestionType();

    /**
     * 获取所有电子书类型
     * @return
     */
    List<StaticConfigVo> getAllEbookType();

    /**
     * 获取所有资源分类
     * @return
     */
    List<StaticConfigVo> getAllResourceCategroy();

    /**
     * 获取所有资源类型
     * @return
     */
    List<StaticConfigVo> getAllResourceTeachType();

    /**
     * 获取所有教材类型
     * @return
     */
    List<StaticConfigVo> getAllTextbookType();


}
