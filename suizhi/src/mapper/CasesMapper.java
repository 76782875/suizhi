package mapper;

import java.util.List;
import model.pojo.Cases;
import model.pojo.CasesExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CasesMapper {
    int countByExample(CasesExample example);

    int deleteByExample(CasesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cases record);

    int insertSelective(Cases record);

    List<Cases> selectByExampleWithBLOBsWithRowbounds(CasesExample example, RowBounds rowBounds);

    List<Cases> selectByExampleWithBLOBs(CasesExample example);

    List<Cases> selectByExampleWithRowbounds(CasesExample example, RowBounds rowBounds);

    List<Cases> selectByExample(CasesExample example);

    Cases selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByExampleWithBLOBs(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByExample(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByPrimaryKeySelective(Cases record);

    int updateByPrimaryKeyWithBLOBs(Cases record);

    int updateByPrimaryKey(Cases record);
}