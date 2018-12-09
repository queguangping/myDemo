package com.demo.baseBean;

import java.io.Serializable;

public class ReturnUtil implements Serializable{

    private static final long serialVersionUID = -1583513692813327439L;
    /**
     * 返回类型
     */
    private String returnType;

    /**
     * 返回结果
     */
    private Object returnValue;

    /**
     *成功
     */
    private final String SUCCESS = "SUCCESS";

    /**
     * 失败
     */
    private final String FAIL = "FAIL";

    public ReturnUtil(){

    }

    @Override
    public String toString() {
        return "ReturnUtil{" +
                "returnType='" + returnType + '\'' +
                ", returnValue='" + returnValue + '\'' +
                ", SUCCESS='" + SUCCESS + '\'' +
                ", FAIL='" + FAIL + '\'' +
                '}';
    }



    public void ok(Object returnValue){
        this.returnType = this.SUCCESS;
        this.returnValue = returnValue;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }
}
