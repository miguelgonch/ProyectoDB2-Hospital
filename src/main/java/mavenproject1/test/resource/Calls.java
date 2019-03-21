/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavenproject1.test.resource;

/**
 *
 * @author migue
 */
public class Calls {
    private int callId;
    private String callName;
    private String timeStamp;

    public Calls(int callId, String callName, String timeStamp) {
        this.callId = callId;
        this.callName = callName;
        this.timeStamp = timeStamp;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    
}
