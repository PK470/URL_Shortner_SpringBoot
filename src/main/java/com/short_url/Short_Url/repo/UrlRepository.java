package com.short_url.Short_Url.repo;

import com.short_url.Short_Url.DataBaseErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlRepository {
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Autowired
    private JdbcTemplate jdbc;
    public String getLongUrl(String shortUrl) {
        String sql = "SELECT longurl FROM url WHERE shorturl = ?";

        //System.out.println(row);
        return jdbc.queryForObject(sql, String.class, shortUrl);
    }


    public String getShortUrl(String longUrl) throws DataBaseErro {
        //System.out.println(longUrl);
        try{
            if(isExist(longUrl)){
                String q = "select shorturl from url where longurl = ?";
                return jdbc.queryForObject(q,
                        (rs,row)->
                                rs.getString("shorturl"), longUrl);
            }
            String sql = "insert into url (shorturl, longurl, count) values(?,?,?)";
            int num = shortNo() + 1;
            System.out.println(num);
            String s = String.format("%06d",num);
            jdbc.update(sql,s,longUrl,0);
            updateUrlCount(num);
            return s;
        }
        catch(Exception e){
            throw new DataBaseErro(e.getMessage());
        }
    }
    private void updateUrlCount(int n){
        String w = "update url_counter set current_value = ? where id = 1";
        jdbc.update(w,n);
    }
    private boolean isExist(String s) {
        String sql = "select count(*) from url where longurl = ?";
        int count = jdbc.queryForObject(sql, Integer.class,s);
        //System.out.println(count);
        return count > 0;
    }

    private int shortNo() {
        String sql = "select current_value from url_counter where id = 1";
        int current = jdbc.queryForObject(sql,(rs,rowNum) -> rs.getInt("current_value"));
        return current;
    }

    public Long getCount(String url) {
        String sql = "select count from url where longurl = ?";
        Long count = Long.valueOf(jdbc.queryForObject(sql, Integer.class, url));

        return count;
    }

    public void updateCount(String url) {
        String q = "update url set count = count + 1 where shorturl = ?";
        int row = jdbc.update(q,url);
    }
}
