package skyline.platform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skyline.platform.repository.dao.PtdeptMapper;
import skyline.platform.repository.dao.PtoperMapper;
import skyline.platform.repository.model.Ptdept;
import skyline.platform.repository.model.PtdeptExample;
import skyline.platform.repository.model.Ptoper;
import skyline.platform.repository.model.PtoperExample;

import java.util.List;

/**
 * 机构管理
 */
@Service
public class PtdeptService {
    private static final Logger logger = LoggerFactory.getLogger(PtdeptService.class);

    @Autowired
    private PtdeptMapper ptdeptMapper;

    public List<Ptdept> qryDepts() {
        PtdeptExample example = new PtdeptExample();
        example.createCriteria().andDeptidIsNotNull();
        return ptdeptMapper.selectByExample(example);
    }
}
