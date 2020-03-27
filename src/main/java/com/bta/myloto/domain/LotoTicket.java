package com.bta.myloto.domain;

public class LotoTicket extends BaseEntenty{

    private Long resultId;
    private Long userAccountId;
    private int myTicketNum1;
    private int myTicketNum2;
    private int myTicketNum3;
    private int myTicketNum4;
    private int myTicketNum5;
    private int myTicketNum6;

    public LotoTicket(Long id, Long resultId , Long userAccountId,int myTicketNum1, int myTicketNum2, int myTicketNum3, int myTicketNum4, int myTicketNum5, int myTicketNum6) {
        super(id);
        this.userAccountId = userAccountId;
        this.resultId = resultId;
        this.myTicketNum1 = myTicketNum1;
        this.myTicketNum2 = myTicketNum2;
        this.myTicketNum3 = myTicketNum3;
        this.myTicketNum4 = myTicketNum4;
        this.myTicketNum5 = myTicketNum5;
        this.myTicketNum6 = myTicketNum6;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public int getMyTicketNum1() {
        return myTicketNum1;
    }

    public void setMyTicketNum1(int myTicketNum1) {
        this.myTicketNum1 = myTicketNum1;
    }

    public int getMyTicketNum2() {
        return myTicketNum2;
    }

    public void setMyTicketNum2(int myTicketNum2) {
        this.myTicketNum2 = myTicketNum2;
    }

    public int getMyTicketNum3() {
        return myTicketNum3;
    }

    public void setMyTicketNum3(int myTicketNum3) {
        this.myTicketNum3 = myTicketNum3;
    }

    public int getMyTicketNum4() {
        return myTicketNum4;
    }

    public void setMyTicketNum4(int myTicketNum4) {
        this.myTicketNum4 = myTicketNum4;
    }

    public int getMyTicketNum5() {
        return myTicketNum5;
    }

    public void setMyTicketNum5(int myTicketNum5) {
        this.myTicketNum5 = myTicketNum5;
    }

    public int getMyTicketNum6() {
        return myTicketNum6;
    }

    public void setMyTicketNum6(int myTicketNum6) {
        this.myTicketNum6 = myTicketNum6;
    }
}
