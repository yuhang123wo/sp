package com.yh.st.common.result;

public class ResponseData extends Response{
    private Object data;

    public ResponseData(Object data) {
        this.data = data;
    }
    
    public ResponseData(ExceptionMsg msg) {
    	  super(msg);
    }
    
    public ResponseData(String rspCode, String rspMsg) {
        super(rspCode, rspMsg);
    }

    public ResponseData(String rspCode, String rspMsg, Object data) {
        super(rspCode, rspMsg);
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                "} " + super.toString();
    }
    
    
    public static void main(String[] args) {
    	Response s = new Response(ExceptionMsg.SUCCESS);
    	ResponseData ss = new ResponseData("ss");
    	System.out.println(s);
    	System.out.println(ss.getData());
	}
}
