package skyline.platform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skyline.platform.repository.dao.PtdeptMapper;
import skyline.platform.repository.model.Ptdept;
import skyline.platform.repository.model.PtdeptExample;

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

    public Ptdept qryDeptById(String id) {
        PtdeptExample example = new PtdeptExample();
        example.createCriteria().andDeptidEqualTo(id);
        return ptdeptMapper.selectByPrimaryKey(id);
    }
}
