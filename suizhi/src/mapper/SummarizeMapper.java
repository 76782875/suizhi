package mapper;

import java.util.List;
import model.pojo.Summarize;
import model.pojo.SummarizeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SummarizeMapper {
    int countByExample(SummarizeExample example);

    int deleteByExample(SummarizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Summarize record);

    int insertSelective(Summarize record);

    List<Summarize> selectByExampleWithBLOBsWithRowbounds(SummarizeExample example, RowBounds rowBounds);

    List<Summarize> selectByExampleWithBLOBs(SummarizeExample example);

    List<Summarize> selectByExampleWithRowbounds(SummarizeExample example, RowBounds rowBounds);

    List<Summarize> selectByExample(SummarizeExample example);

    Summarize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Summarize record, @Param("example") SummarizeExample example);

    int updateByExampleWithBLOBs(@Param("record") Summarize record, @Param("example") SummarizeExample example);

    int updateByExample(@Param("record") Summarize record, @Param("example") SummarizeExample example);

    int updateByPrimaryKeySelective(Summarize record);

    int updateByPrimaryKeyWithBLOBs(Summarize record);

    int updateByPrimaryKey(Summarize record);
}