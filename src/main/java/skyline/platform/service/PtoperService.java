package skyline.platform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skyline.platform.repository.dao.PtoperMapper;
import skyline.platform.repository.model.Ptoper;
import skyline.platform.repository.model.PtoperExample;

import java.util.List;

/**
 * 用户管理
 */
@Service
public class PtoperService {
    private static final Logger logger = LoggerFactory.getLogger(PtoperService.class);

    @Autowired
    private PtoperMapper ptoperMapper;

    public Ptoper qryOperById(String id) {
        PtoperExample example = new PtoperExample();
        example.createCriteria().andOperidEqualTo(id);
        return ptoperMapper.selectByPrimaryKey(id);
    }

    public List<Ptoper> qryOpers() {
        PtoperExample example = new PtoperExample();
        example.createCriteria().andOperidIsNotNull();
        return ptoperMapper.selectByExample(example);
    }
}
