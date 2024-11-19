package com.short_url.Short_Url;

import com.short_url.Short_Url.service.UrlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShortUrlApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ShortUrlApplication.class, args);
		UrlService sv = context.getBean(UrlService.class);
		Long cout = sv.getCount("https://x.com/AliRamji2/status/1853281005140148570");
		System.out.println(cout);
	}

}
