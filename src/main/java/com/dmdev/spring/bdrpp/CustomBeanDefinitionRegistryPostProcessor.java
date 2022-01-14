package com.dmdev.spring.bdrpp;

import com.dmdev.spring.annotation.CustomRepository;
import com.dmdev.spring.database.repository.JpaRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;

public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        for (String beanDefinitionName : registry.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = null;

            try {
                beanClass = Class.forName(beanClassName);
            } catch (ClassNotFoundException e) {}

            if (beanClass.isAnnotationPresent(CustomRepository.class)){
                AbstractBeanDefinition jpaRepositoryBeanDefinition = BeanDefinitionBuilder
                        .rootBeanDefinition(JpaRepository.class)
                        .getBeanDefinition();

                BeanDefinitionReaderUtils.registerWithGeneratedName(jpaRepositoryBeanDefinition, registry);
            }


        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
