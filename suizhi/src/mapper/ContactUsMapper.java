package mapper;

import java.util.List;
import model.pojo.ContactUs;
import model.pojo.ContactUsExample;
import org.apache.ibatis.annotations.Param;

public interface ContactUsMapper {
    int countByExample(ContactUsExample example);

    int deleteByExample(ContactUsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContactUs record);

    int insertSelective(ContactUs record);

    List<ContactUs> selectByExample(ContactUsExample example);
    
    List<ContactUs> selectAll();//按列表显示的方法
    
    ContactUs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContactUs record, @Param("example") ContactUsExample example);

    int updateByExample(@Param("record") ContactUs record, @Param("example") ContactUsExample example);

    int updateByPrimaryKeySelective(ContactUs record);

    int updateByPrimaryKey(ContactUs record);
}