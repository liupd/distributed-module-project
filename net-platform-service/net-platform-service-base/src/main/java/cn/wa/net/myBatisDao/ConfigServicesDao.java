package cn.wa.net.myBatisDao;

import cn.wa.net.formbean.StaticConfigVo;

import java.util.List;

/**
 * Created by Liupd on 15-12-17.
 **/
public interface ConfigServicesDao {

     List<StaticConfigVo> getAllCategroy();

     List<StaticConfigVo> getAllQuestionType();

     List<StaticConfigVo> getAllEbookType();

     List<StaticConfigVo> getAllResourceCategroy();

     List<StaticConfigVo> getAllResourceTeachType();

     List<StaticConfigVo> getAllTextbookType();

}
