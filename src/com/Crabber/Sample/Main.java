/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Crabber.Sample;

import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.*;
import java.io.*;


/**
 *
 * @author Frederick
 */
public class Main 
{
    
    public static void main(String args[]) throws XMPPException, IOException {
        String host = "kth.se";
        int port = 5222;

        //ConnectionConfiguration conf = new ConnectionConfiguration(host, port);
        ConnectionConfiguration conf = new ConnectionConfiguration(host);
        conf.setCompressionEnabled(true);
        conf.setSASLAuthenticationEnabled(true);
//        conf.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);

        Connection conn = new XMPPConnection(conf);
        conn.connect();
        conn.login("fceder", "43BJk8aeLSkwOnmA", null);

        ChatManager chatManager = conn.getChatManager();

        Chat newChat = chatManager.createChat("juddholm@kth.se", new MessageListener() {
        public void processMessage(Chat chat, Message message) {
            System.out.println("Received message: " + message.getBody());
        }});
        //newChat.sendMessage("Hejsan!");
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            Thread.yield();
            String input = in.readLine();
            if(input.toLowerCase().equals("exit"))
                System.exit(0);
            newChat.sendMessage(input);
        }
    }
    
    
    
    
   
    
}
