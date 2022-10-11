import com.df.feign.GetFeign;
import com.df.pojo.User;
import com.df.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author feng.dai
 * @package PACKAGE_NAME
 * @project get_parent_master
 * @Date 2022/9/27 17:15
 */
@RestController
@RequestMapping("/")
public class GetController {

    @Autowired
    private GetFeign getFeign;

    @RequestMapping("/list")
    public Result getAll(@PathVariable Long Id){
        List<User> userList = getFeign.getAll(Id);
        if (userList.isEmpty()){
            return new Result("GET ERROR~");
        }
        return new Result(userList);
    }
}
