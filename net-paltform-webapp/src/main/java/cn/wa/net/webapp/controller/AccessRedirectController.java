package cn.wa.net.webapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 16-4-18.
 **/
@RestController
public class AccessRedirectController {

    @Value("${idocv_url}")
    private String idocv_url;//idocv路径

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/index");
        System.out.println(idocv_url);
        return mv;
    }

}
