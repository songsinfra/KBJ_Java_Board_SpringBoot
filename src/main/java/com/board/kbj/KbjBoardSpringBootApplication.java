package com.board.kbj;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.kbj.utility.InterceptHandler;

@SpringBootApplication
@MapperScan(value= {"com.board.kbj.mapper"})
public class KbjBoardSpringBootApplication implements WebMvcConfigurer, ErrorController  {

	public static void main(String[] args) {
		SpringApplication.run(KbjBoardSpringBootApplication.class, args);
	}
	
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
    
    
    @Autowired
    InterceptHandler interceptHandler; // utility의 InterceptHandler와 연결된다
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptHandler); // addPathPattern과 excludePathPattern을 사용해서 인터셉터를 설정/해제 가능
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
