package com.entity;

public class T_user {
    private int id;
    private String name;
    private String trueName;
    private String cardId;
    private String email;
    private String telephone;
    private String qqId;
    private String pwd;
    private String regTime;
    private String question;
    private String answer;
    private int state;

    public T_user(String name, String trueName, String cardId, String email, String telephone, String qqId) {
        this.name = name;
        this.trueName = trueName;
        this.cardId = cardId;
        this.email = email;
        this.telephone = telephone;
        this.qqId = qqId;
    }

    public T_user(int id, String name, String trueName, String cardId, String email, String telephone, String qqId, String pwd, String regTime, String question, String answer, int state) {
        this.id = id;
        this.name = name;
        this.trueName = trueName;
        this.cardId = cardId;
        this.email = email;
        this.telephone = telephone;
        this.qqId = qqId;
        this.pwd = pwd;
        this.regTime = regTime;
        this.question = question;
        this.answer = answer;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
