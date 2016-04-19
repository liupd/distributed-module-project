package cn.wa.net.service;



import cn.wa.net.domain.TestitemType;
import cn.wa.net.formbean.PageResultVo;
import cn.wa.net.formbean.TestItemTypeVo;
import cn.wa.net.interfaces.TestItemTypeServices;
import cn.wa.net.myBatisDao.TestitemTypeDao;
import cn.wa.net.utils.BaseUtils;
import cn.wa.net.utils.Const;
import cn.wa.net.utils.EntityUtils;
import cn.wa.net.utils.IdSequence;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Administrator on 2015/6/26 0026.
 **/
@Service
@Transactional(value = "transactionManager")
public class TestItemTypeServicesImpl implements TestItemTypeServices {
    @Resource
    private TestitemTypeDao testitemTypeDao;

    @Override
    public PageResultVo findTestItemByPage(Map<String, String> queryMap, int currentPage,int pageSize) {
        PageResultVo pageResultVo = new PageResultVo();
        List<TestItemTypeVo> voList = new ArrayList<TestItemTypeVo>();
        TestitemType reqTestitemType = new TestitemType();
        reqTestitemType.setIsDelete(queryMap.get("isDelete"));
        reqTestitemType.setName(queryMap.get("name"));
        Page<TestitemType> page = new Page<>(currentPage, pageSize);
        List<TestitemType> testList = testitemTypeDao.selectListByProps(page,reqTestitemType);
        for(TestitemType testitemType:testList){
            TestItemTypeVo vo = new TestItemTypeVo();
            vo.setIsObject(testitemType.getIsObject());
            vo.setName(testitemType.getName());
            vo.setId(testitemType.getId());
            vo.setIsDelete(testitemType.getIsDelete());
            voList.add(vo);
        }
        pageResultVo.setResult(voList);
        pageResultVo.setTotal(page.getTotal());
        return pageResultVo;
    }


  @Override
  @CachePut(value = "testItemType_cache", key="#testItemTypeVo.businessKey")
  public Map addTestItem(TestItemTypeVo testItemTypeVo) {
        TestitemType testItemType = new TestitemType();
        TestitemType reqTestitemType = new TestitemType();
        reqTestitemType.setName(testItemTypeVo.getName());
        TestitemType type = testitemTypeDao.selectOne(reqTestitemType);
        if(Const.isNotNull(type)){
            if(type.getIsDelete().equals(testItemTypeVo.getIsObject())){
                Map<String,String> map=new HashMap();
                map.put("fail","data already exists");
                return new HashMap();
            }
        }
        testItemType = EntityUtils.copyProperties(TestitemType.class, testItemTypeVo);
        testItemType.setCreateTime(new Date());
        testItemType.setIsDelete("N");
        testItemType.setId(""+(testitemTypeDao.selectMaxId()+1));
        testItemType.setUpdateTime(new Date());
        testItemType.setBusinessKey(IdSequence.nextId());
        testitemTypeDao.insert(testItemType);
        return  BaseUtils.objectToMap(testItemType);
    }




  @Override
  @CacheEvict(value = "testItemType_cache", allEntries=true)
  public Map updateTestItem(TestItemTypeVo testItemTypeVo) {
        TestitemType testItemType = testitemTypeDao.selectById(testItemTypeVo.getId());
        TestitemType reqTestitemType = new TestitemType();
        reqTestitemType.setName(testItemTypeVo.getName());
        TestitemType type = testitemTypeDao.selectOne(reqTestitemType);
        if(Const.isNotNull(type)){
            if(type.getIsDelete().equals(testItemTypeVo.getIsObject())){
                if(testItemTypeVo.getId() != type.getId()){
                    Map<String,String> map=new HashMap();
                    map.put("fail","data already exists");
                    return new HashMap();
                }
            }
        }
        testItemTypeVo.setBusinessKey(testItemType.getBusinessKey());
        testItemType = EntityUtils.copyProperties(TestitemType.class, testItemTypeVo);
        testItemType.setUpdateTime(new Date());
        testitemTypeDao.updateById(testItemType);
        return  BaseUtils.objectToMap(testItemType);
    }

  @Override
  @CacheEvict(value = "testItemType_cache", allEntries=true)
  public boolean deleteTestItem(String id,String status) {
        TestitemType testItemType = testitemTypeDao.selectById(id);
        testItemType.setIsDelete(status);
        int no=testitemTypeDao.updateById(testItemType);
        return no==1;
  }
}
