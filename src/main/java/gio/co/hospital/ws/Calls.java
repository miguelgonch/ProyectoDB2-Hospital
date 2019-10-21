
package gio.co.hospital.ws;

/**
 *
 * @author migue
 */
public class Calls {
    private String callId;
    private String callName;
    private String timeStamp;

    public Calls(String callId, String callName, String timeStamp) {
        this.callId = callId;
        this.callName = callName;
        this.timeStamp = timeStamp;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
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
