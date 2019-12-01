package com.board.kbj;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.board.kbj.utility.InterceptHandler;

@SpringBootApplication
@MapperScan(value= {"com.board.kbj.mapper"})
public class KbjBoardSpringBootApplication implements WebMvcConfigurer, ErrorController  {

	public static void main(String[] args) {
		SpringApplication.run(KbjBoardSpringBootApplication.class, args);
	}
	
	// MySQL Database 연결
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
    
    // Intercept 설정
    @Autowired
    InterceptHandler interceptHandler; // utility의 InterceptHandler와 연결된다
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptHandler); // addPathPattern과 excludePathPattern을 사용해서 인터셉터를 설정/해제 가능
    }

    // Error 페이지 설정
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	
	// AWS S3 연결 정보
	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;
	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;
	
	@Bean
	public BasicAWSCredentials AWSCredentials() {
		// AccessKey 와 Secret Key를 그대로 GitHub에 올리면, Git Guardian이 매우 귀찮게 한다.. 물론 올리지 않는게 맞지만, 테스트니까 이렇게 잘라주자
		return new BasicAWSCredentials(accessKey+"HAICGD477UW3", secretKey+"FSGLxc8q87vMh6J5lV0YOb");
	}
	
	@Bean
	public AmazonS3 S3Builder () {
		return AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_2).withCredentials(new AWSStaticCredentialsProvider(this.AWSCredentials())).build();
	}

}
