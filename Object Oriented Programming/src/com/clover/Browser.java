package com.clover;

public class Browser {
    public void navigate(String address){
        String ip = findIpAddress(address);
        String html = sendHttpRequest(ip);
        System.out.println(html);
    }

    private String sendHttpRequest(String ip) { //not used in main class so its private. impact of changes
        return "<html></html>";
    }

    private String findIpAddress(String address) {
        return "127.0.1";
    }
}
