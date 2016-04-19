package cn.wa.net.myBatisDao;

import cn.wa.net.domain.TestitemType;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 *
 * BdTestitemTypeMapper数据库操作接口类
 *
 */
public interface TestitemTypeDao extends AutoMapper<TestitemType> {

    List<TestitemType> selectListByProps(RowBounds rowBounds, TestitemType testitemType);

    Integer selectMaxId();

}