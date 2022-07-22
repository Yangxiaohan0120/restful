package restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restful.entity.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-20 16:47
 **/
@RestController // 将类中所有方法赋值@ResponseBody
//@Controller
@RequestMapping("/restful")
@CrossOrigin(origins = {"http://localhost:8080"},maxAge = 3600)
public class RestfulController {

    //虽然使用了同样的"url"，但是由于请求的方式不同，所以并不冲突

    @GetMapping("/request")
    @ResponseBody
    public String doGetRequest() {
        return "{\"message\":\"返回查询结果\"}";
    }

    @PostMapping("/request/{rid}")
    @ResponseBody
    public String doPostRequest(@PathVariable("rid") Integer requestId, Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据新建成功\",\"id\":" + requestId + "}";
    }

    @PutMapping("/request")
    @ResponseBody
    public String doPutRequest(Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    @ResponseBody
    public String doDeleteRequest() {
        return "{\"message\":\"数据删除成功\"}";
    }

    @GetMapping("/person")
    public Person findByPersonId(Integer id) {
        Person person = new Person();
        if (id == 1) {
            person.setName("Lily");
            person.setAge(23);
        } else if (id == 2) {
            person.setName("Smith");
            person.setAge(22);
        }
        return person;
    }

    @GetMapping("/persons")
    public List<Person> findPersons() {
        List list = new ArrayList();
        Person p1 = new Person();
        p1.setName("Lily");
        p1.setAge(23);
        p1.setBirthday(new Date());
        Person p2 = new Person();
        p2.setName("Smith");
        p2.setAge(22);
        p2.setBirthday(new Date());
        list.add(p1);
        list.add(p2);
        return list;
    }
}
