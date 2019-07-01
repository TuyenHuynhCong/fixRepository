package com.vnext.interjava.userproduct.idea.configuaration;

import com.vnext.interjava.userproduct.idea.IdeaApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringMvc1Application.class);
//	}
	@Override
	protected SpringApplicationBuilder configure ( SpringApplicationBuilder application)
	{
		return  application.sources(IdeaApplication.class);
	}

}
