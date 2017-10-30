package com.yh.st.common.result;

public class ResultData extends ResultMsg{
    private Object data;

    public ResultData(Object data) {
        this.data = data;
    }
    
    public ResultData(ExceptionMsg msg) {
    	  super(msg);
    }
    
    public ResultData(String rspCode, String rspMsg) {
        super(rspCode, rspMsg);
    }

    public ResultData(String rspCode, String rspMsg, Object data) {
        super(rspCode, rspMsg);
        this.data = data;
    }

    public ResultData(ExceptionMsg msg, Object data) {
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
    	ResultMsg s = new ResultMsg(ExceptionMsg.SUCCESS);
    	ResultData ss = new ResultData("ss");
    	System.out.println(s);
    	System.out.println(ss.getData());
	}
}
