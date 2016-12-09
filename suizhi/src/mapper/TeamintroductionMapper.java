package mapper;

import java.util.List;
import model.pojo.Teamintroduction;
import model.pojo.TeamintroductionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeamintroductionMapper {
    int countByExample(TeamintroductionExample example);

    int deleteByExample(TeamintroductionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teamintroduction record);

    int insertSelective(Teamintroduction record);

    List<Teamintroduction> selectByExampleWithBLOBsWithRowbounds(TeamintroductionExample example, RowBounds rowBounds);

    List<Teamintroduction> selectByExampleWithBLOBs(TeamintroductionExample example);

    List<Teamintroduction> selectByExampleWithRowbounds(TeamintroductionExample example, RowBounds rowBounds);

    List<Teamintroduction> selectByExample(TeamintroductionExample example);

    Teamintroduction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teamintroduction record, @Param("example") TeamintroductionExample example);

    int updateByExampleWithBLOBs(@Param("record") Teamintroduction record, @Param("example") TeamintroductionExample example);

    int updateByExample(@Param("record") Teamintroduction record, @Param("example") TeamintroductionExample example);

    int updateByPrimaryKeySelective(Teamintroduction record);

    int updateByPrimaryKeyWithBLOBs(Teamintroduction record);

    int updateByPrimaryKey(Teamintroduction record);
}