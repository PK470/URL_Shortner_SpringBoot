package com.short_url.Short_Url.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClickRepo {
    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private JdbcTemplate jdbc;
    public void registerClick(String url, String ip) {
        Long urlId = getId(url);

        String checkSql = "SELECT COUNT(*) FROM url_click WHERE url_id = ? AND ip = ?";
        int count = jdbc.queryForObject(checkSql, Integer.class, urlId, ip);

        if (count > 0) {
            //System.out.println("hiiii");
            String updateSql = "UPDATE url_click SET click_count = click_count + 1 WHERE url_id = ? AND ip = ?"; // Update click count
            jdbc.update(updateSql, urlId, ip);
        } else {

            String insertSql = "INSERT INTO url_click (url_id, ip, click_count) VALUES (?, ?, 1)"; // Insert new record
            jdbc.update(insertSql, urlId, ip);
        }
    }

    private Long getId(String url){
        String sql = "select id from url where shorturl = ?";
        return jdbc.queryForObject(sql, Long.class, url);
    }

    public Long uniqueCount(String url){
        Long id = getId(url);
        String sql = "select count(*) from url_click where url_id = ?";
        return jdbc.queryForObject(sql, Long.class, id);
    }
}
