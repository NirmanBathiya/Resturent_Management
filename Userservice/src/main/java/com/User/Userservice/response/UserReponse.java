package com.User.Userservice.response;

import com.Order.Oredrservice.response.OrderResponse;

public class UserReponse {
    private int Uid;
    private String Name;
    private String Email;
    private int Tp;

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getTp() {
        return Tp;
    }

    public void setTp(int tp) {
        Tp = tp;
    }

    public void setOrderResponse(OrderResponse orderResponse) {
    }
}
