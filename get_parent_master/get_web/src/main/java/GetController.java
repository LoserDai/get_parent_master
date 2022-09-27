import com.df.feign.GetFeign;
import com.df.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result getAll(){
        //TODO
        return new Result();
    }
}
