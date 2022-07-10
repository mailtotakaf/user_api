package userApi;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * ユーザ別情報
     * 
     * @param id ユーザid
     * @return UserData
     */
    User findUserDataById(Long id);

    /**
     * ユーザリスト
     * 
     * @return
     */
    @Select("select * from user_data")
    List<User> findAll();

}