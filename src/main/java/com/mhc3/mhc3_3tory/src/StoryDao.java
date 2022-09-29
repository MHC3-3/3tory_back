package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.src.model.PartnerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StoryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetResTestResult getTestResult(int programId) {
        String getResTestResultQuery = "select id, name, description, image " +
                                        "from programs where id=?;";
        int getResTestResultParam = programId;

        String partnerModelQuery = "select name as partner_name, id as partner_id, image as partner_img " +
                                    "from programs where partner_id=?;";
        int partnerModelParam = programId;

        updateCount(programId);
        return this.jdbcTemplate.queryForObject(getResTestResultQuery,
                (rs, rowNum) -> new GetResTestResult (
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("image"),
                        this.jdbcTemplate.queryForObject(partnerModelQuery,
                        (rk, rowNumk) -> new PartnerModel(
                                rk.getInt("partner_id"),
                                rk.getString("partner_name"),
                                rk.getString("partner_img")
                        ), getResTestResultParam)
                ), partnerModelParam
        );
    }

    public void updateCount(int programId) {
        String updateCountQuery = "UPDATE programs SET programs.count = (SELECT * FROM (SELECT p.count FROM programs as p WHERE p.id =?) as a)+1 WHERE programs.id =?;";
        Object[] updateCountParams = new Object[]{programId,programId};
        this.jdbcTemplate.update(updateCountQuery, updateCountParams);
    }
}
