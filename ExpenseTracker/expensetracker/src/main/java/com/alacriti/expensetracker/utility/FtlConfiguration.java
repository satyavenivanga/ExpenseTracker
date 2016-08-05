package com.alacriti.expensetracker.utility;

import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class FtlConfiguration {
	
	static Configuration cfg = null;
	public static Configuration createConfiguration(){
	  cfg = new Configuration();
	  cfg.setClassForTemplateLoading(FtlConfiguration.class, "/");
	  cfg.setIncompatibleImprovements(new Version(2, 3, 20));
	  cfg.setDefaultEncoding("UTF-8");
	  cfg.setLocale(Locale.US);
	  cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	  return cfg;
}
	
}
