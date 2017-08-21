package bookcloud.service;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ForNow implements ForDate {

	
	@Override
	@Bean
	public FastDateFormat getFormat() {
		// TODO Auto-generated method stub
		FastDateFormat df = FastDateFormat.getInstance("yyyy-MM-dd", Locale.getDefault());
		return df;
	}

	@Override
	@Bean
	public Date getDate() {
		// TODO Auto-generated method stub
		Date date = new Date();
		return date;
	}

}
