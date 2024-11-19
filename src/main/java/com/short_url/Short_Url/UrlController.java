package com.short_url.Short_Url;

import com.short_url.Short_Url.model.UrlModel;
import com.short_url.Short_Url.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UrlController {
    @Autowired
    public void setUs(UrlService us) {
        this.us = us;
    }

    private UrlService us;
    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/url-short")
    public String urlShort(String url,Model model) throws DataBaseErro {
        System.out.println(url);
        try {

            UrlModel u = new UrlModel();
            u.setShortUrl(us.getShortUrl(url));
            u.setLongUrl(url);


            model.addAttribute("url",u);

        } catch (Exception eq) {
            return "redirect :/";
        }
        return "short";
    }


    @RequestMapping ("/count/{url}")
    public String urlCount(@PathVariable String url, Model model)  {
        //System.out.println(url);
        try {
            UrlModel u = new UrlModel();
            u.setLongUrl(us.getLongUrl(url));
            u.setShortUrl(url);
            u.setCount(us.getCount(us.getLongUrl(url)));
            //System.out.println(u.getCount());
            model.addAttribute("u",u);
            model.addAttribute("unique", us.getUnique(url));
        } catch (Exception e) {
            return "redirect:/";
        }
        return "count";

    }
    @RequestMapping("/{url}")
    public String redirectUrl(@PathVariable String url, HttpServletRequest request){
        try {
            if (url == null) return "redirect:/";
            //System.out.println("hiii");
            String s = us.getLongUrl(url);
            us.updateCount(url);
            String ip = request.getRemoteAddr();
            us.registerClick(url,ip);
            return "redirect:" + s;
        }
        catch (Exception e){
            return "redirect:/";
        }
    }

}
