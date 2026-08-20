package com.myapp.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {

    private LoginManagerBean loginManagerBean;

    

    public LoginAspect(LoginManagerBean loginManagerBean) {
        this.loginManagerBean = loginManagerBean;
    }


    @Before("execution(* com.myapp.spring.service.*.*(..))")
    public void verify(){
        LoginBean loginBean = loginManagerBean.getLoggedInUser();
        if(loginBean ==null){
            throw new SecurityException("Please Login to Search");
        }
        else {
            if(loginBean.username().equalsIgnoreCase("admin")){
                System.out.println("Welcome user");
            } else{
                throw new SecurityException("Invalid username");
            }
        }

    }

}
