package com.primavera.CoursProject.application;

import com.primavera.CoursProject.domain.AbsUser;
import com.primavera.CoursProject.domain.Admin;
import com.primavera.CoursProject.domain.Bidder;
import com.primavera.CoursProject.domain.Broker;

public class UserFacotry {

    public static AbsUser getUser(String tipus){
        switch (tipus){
            case "ADMIN": return new Admin();
            case "BIDDER": return new Bidder();
            case "BROKER": return new Broker();
            default: throw new IllegalArgumentException();
        }

    }
}
