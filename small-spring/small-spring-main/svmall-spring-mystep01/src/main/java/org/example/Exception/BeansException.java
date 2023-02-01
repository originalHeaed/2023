package org.example.Exception;

/**
 * Bean 异常
 */
public class BeansException extends Exception{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
