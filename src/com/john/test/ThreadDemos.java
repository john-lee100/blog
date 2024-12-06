package com.john.test;

import java.util.concurrent.Executor;

class Executors implements Executor {

  @Override
  public void execute(Runnable r) {
      new Thread(r).start();
  }
}

public class ThreadDemos {
  private Executor e;
  private static int usm;
  
  public ThreadDemos(Executor e) {
    this.e = e;
  }
  
  public void executorMehtod() {
    e.execute(new Runnable() {
      public void run() {
        sumMethod();
      }
    });
  }
  
  public static void sumMethod() {
    synchronized (ThreadDemos.class) {
      for(int i = 0 ; i < 1000 ;i ++) {
        usm  = usm + 1;
      }
      System.out.println("總和計算:"+usm);  
    }
  } 
  
  public static void main(String[] args)throws Exception {
    new ThreadDemos(new Executors()).executorMehtod();
    new ThreadDemos(new Executors()).executorMehtod();
    new ThreadDemos(new Executors()).executorMehtod();
    new ThreadDemos(new Executors()).executorMehtod();
    new ThreadDemos(new Executors()).executorMehtod();
    new ThreadDemos(new Executors()).executorMehtod();
  }
}
