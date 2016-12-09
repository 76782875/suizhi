package mapper;

import java.util.List;
import model.pojo.UsVO;
import model.pojo.UsVOExample;
import org.apache.ibatis.annotations.Param;

public interface UsVOMapper {
    int countByExample(UsVOExample example);

    int deleteByExample(UsVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsVO record);

    int insertSelective(UsVO record);

    List<UsVO> selectByExample(UsVOExample example);

    UsVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsVO record, @Param("example") UsVOExample example);

    int updateByExample(@Param("record") UsVO record, @Param("example") UsVOExample example);

    int updateByPrimaryKeySelective(UsVO record);

    int updateByPrimaryKey(UsVO record);
}