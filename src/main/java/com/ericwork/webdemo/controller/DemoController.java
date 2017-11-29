package com.ericwork.webdemo.controller;


import com.alibaba.fastjson.JSON;
import com.ericwork.webdemo.bean.PeopleService;
import com.ericwork.webdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {

    @Autowired
    PeopleService peopleService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String greeting(@RequestParam(value = "name", required = false) String name) {
        return "hello, " + name;
    }


    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String register(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "age", required = false) int age,
                           @RequestParam(value = "address", required = false) String addr,
                           @RequestParam(value = "mobile", required = false) String mobile) {
        User people = new User();
        people.setName(name);
        people.setAddr(addr);
        people.setAge(age);
        people.setMobile(mobile);


        if (!peopleService.updatePeople(people)) {
            return JSON.toJSONString(people);

        } else {
            return "{\"data\":false}";
        }
    }

}
