package userApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    /**
     * ユーザ情報リスト取得
     */
    @GetMapping("/getUserList")
    public String getUserDataList() {
        String jsonStr = null;

        List<User> userDataList = mapper.findAll();

        if (userDataList == null || userDataList.size() == 0) {
            return null;
        }
        for (User userData : userDataList) {
            userData.setSex("1".equals(userData.getSex()) ? "male" : "female");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonStr = objectMapper.writeValueAsString(userDataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
