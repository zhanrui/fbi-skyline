package skyline.platform.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import skyline.platform.repository.model.Ptresource;
import skyline.platform.repository.model.PtresourceExample;

public interface PtresourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    int countByExample(PtresourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    int deleteByExample(PtresourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    int insert(Ptresource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    int insertSelective(Ptresource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    List<Ptresource> selectByExample(PtresourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    int updateByExampleSelective(@Param("record") Ptresource record, @Param("example") PtresourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTRESOURCE
     *
     * @mbggenerated Tue Jun 23 18:13:29 CST 2015
     */
    int updateByExample(@Param("record") Ptresource record, @Param("example") PtresourceExample example);
}