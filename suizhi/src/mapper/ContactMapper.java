package mapper;

import java.util.List;
import model.pojo.Contact;

public interface ContactMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    Contact selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Contact record);
    
    List<Contact> selectContactByStatus(Contact contact);
    
}