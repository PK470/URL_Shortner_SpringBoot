package com.short_url.Short_Url.service;

import com.short_url.Short_Url.DataBaseErro;
import com.short_url.Short_Url.repo.ClickRepo;
import com.short_url.Short_Url.repo.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private UrlRepository repo;

    public ClickRepo getCl() {
        return cl;
    }
    @Autowired
    public void setCl(ClickRepo cl) {
        this.cl = cl;
    }

    private ClickRepo cl;

    public UrlRepository getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(UrlRepository repo) {
        this.repo = repo;
    }
    public String getLongUrl(String shortUrl){
        return repo.getLongUrl(shortUrl);
    }
    public String getShortUrl(String longUrl) throws DataBaseErro {
        //System.out.println(repo.getShortUrl(longUrl));
        return repo.getShortUrl(longUrl);
    }

    public Long getCount(String url) {
        return repo.getCount(url);
    }

    public void updateCount(String url){
        repo.updateCount(url);
    }

    public void registerClick(String url,String ip){
        cl.registerClick(url,ip);
    }

    public Long getUnique(String url){
        return cl.uniqueCount(url);
    }
}
