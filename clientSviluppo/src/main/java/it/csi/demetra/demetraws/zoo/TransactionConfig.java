package it.csi.demetra.demetraws.zoo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

//@Configuration
//@EnableJpaRepositories
//@EnableTransactionManagement
public class TransactionConfig {
//
//	@Bean
//	   public PlatformTransactionManager transactionManager(){
//	      JpaTransactionManager transactionManager
//	        = new JpaTransactionManager();
////	      transactionManager.setEntityManagerFactory(
////	        entityManagerFactoryBean().getObject() );
//	      return transactionManager;
//	   }
//
//  @Bean
//  public TransactionTemplate transactionTemplate()
//  {
//    TransactionTemplate transactionTemplate = new TransactionTemplate();
//    transactionTemplate.setTransactionManager(transactionManager());
//    return transactionTemplate;
//  }
}

