package cn.liuboyi.mongodb.dao;

import cn.liuboyi.mongodb.entity.Link;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author liuboyi
 */
@Component
public class LinkDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param link
     */
    public void save(Link link) {
        mongoTemplate.save(link);
    }

    /**
     * 根据code查询对象
     * @param code
     * @return
     */
    public Link findByCode(String code) {
        Query query=new Query(Criteria.where("code").is(code));
        Link link =  mongoTemplate.findOne(query , Link.class);
        return link;
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Link.class);
    }
}
