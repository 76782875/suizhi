package mapper;

import java.util.List;
import model.pojo.Summarize;
import model.pojo.SummarizeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface SummarizeMapper2 {
   
	public List<Summarize> listAll()throws Throwable;
	

}