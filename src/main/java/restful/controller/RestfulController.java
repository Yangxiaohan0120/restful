package restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chris Yang
 * created 2022-07-20 16:47
 **/

@Controller
@RequestMapping("/restful")
public class RestfulController {

    @GetMapping("/request")
    @ResponseBody
    public String doGetRequest(){
        return "{\"message\":\"返回查询结果\"}";
    }
}
