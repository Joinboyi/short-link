package cn.liuboyi.controller;

import cn.liuboyi.dto.LinkDto;
import cn.liuboyi.mongodb.dao.LinkDao;
import cn.liuboyi.mongodb.entity.Link;
import cn.liuboyi.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author liuboyi
 */
@RestController
@RequestMapping("/")
public class LinkController {

    @Autowired
    private LinkDao linkDao;

    @Value("${short.link.num}")
    private int num;

    @Value("${short.link.url}")
    private String url;


    @RequestMapping(value = "/link/save", method= RequestMethod.POST)
    public String save(@Valid @RequestBody LinkDto params) {
        Link link = new Link();
        link.setUrl(params.getUrl());
        link.setCreatedAt(LocalDateTime.now());
        try {
            for (int i = 0; i < num; i++) {
                //获取6位数随机码
                String code = RandomUtil.getRandom(6);
                if (linkDao.findByCode(code) == null) {
                    link.setCode(code);
                    linkDao.save(link);
                    return url + code;
                }
            }
            return "400";
        }catch (Exception e) {
            return "400";
        }
    }

    @RequestMapping(value = "/s/{code}", method= RequestMethod.GET)
    public void shift(HttpServletResponse resp, @PathVariable("code") String code) throws IOException {
        Link link = linkDao.findByCode(code);
        resp.sendRedirect(link.getUrl());
    }

}
