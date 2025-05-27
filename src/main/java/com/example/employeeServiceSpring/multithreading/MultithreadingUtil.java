package com.example.employeeServiceSpring.multithreading;

public class MultithreadingUtil {
	
	
	
	private String notice = "Welcome to the company.";

    public String getNotice() {
        return notice;
    }

    public void updateNotice(String newNotice) {
        this.notice = newNotice;
    }
    
    
    public static void main(String[] args) 
    {
        MultithreadingUtil util = new MultithreadingUtil();
        System.out.println("Running in: " + Thread.currentThread().getName());

        Thread updater = new Thread(() -> {
            util.updateNotice("Office will be closed tomorrow.");
            System.out.println(Thread.currentThread().getName() + " updated notice.");
        }, "Updater-Thread");

        Thread reader = new Thread(() -> {
            String currentNotice = util.getNotice();
            System.out.println(Thread.currentThread().getName() + " read notice: " + currentNotice);
        }, "Reader-Thread");

        updater.start();
        reader.start();

        try {
            updater.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
