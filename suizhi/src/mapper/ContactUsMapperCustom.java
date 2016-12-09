package mapper;

import model.pojo.ContactUs;
import model.pojo.ContactUsCustom;
import model.pojo.ContactUsExample;
import model.pojo.ContactUsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactUsMapperCustom {
    //联系方式的列表查询
	public List<ContactUsCustom> findContactUsList(ContactUsQueryVo contactUsQueryVo) throws	Exception;
}