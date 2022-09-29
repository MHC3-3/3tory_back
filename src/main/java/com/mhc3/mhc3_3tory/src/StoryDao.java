package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.src.model.PartnerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import static com.mhc3.mhc3_3tory.config.response.BaseResponseStatus.DATABASE_ERROR;

@Repository
public class StoryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetResTestResult getTestResult(int programId) throws BaseException {
        try {
            String getResTestResultQuery = "select id, name, title, description, image " +
                    "from Programs where id=?;";
//        int getResTestResultParam = programId;

            String partnerModelQuery = "select id as partner_id, name as partner_name, title as partner_title, image as partner_img " +
                    "from Programs where partner_id=?;";
//        int partnerModelParam = programId;

            updateCount(programId);

            PartnerModel partnerModel = this.jdbcTemplate.queryForObject(partnerModelQuery,
                    (rk, rowNumk) -> new PartnerModel(
                            rk.getInt("partner_id"),
                            rk.getString("partner_name"),
                            rk.getString("partner_title"),
                            rk.getString("partner_img")
                    ), programId);
            GetResTestResult testResult = this.jdbcTemplate.queryForObject(getResTestResultQuery,
                    (rs, rowNum) -> new GetResTestResult(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("image"),
                            partnerModel
                    ), programId
            );
            return testResult;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void updateCount(int programId) throws BaseException {
        try {
            String updateCountQuery = "UPDATE Programs SET Programs.count = (SELECT * FROM (SELECT p.count FROM Programs as p WHERE p.id =?) as a)+1 WHERE Programs.id =?;";
            Object[] updateCountParams = new Object[]{programId,programId};
            this.jdbcTemplate.update(updateCountQuery, updateCountParams);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
