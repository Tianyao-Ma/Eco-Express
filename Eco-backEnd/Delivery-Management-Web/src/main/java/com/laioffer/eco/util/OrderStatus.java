package com.laioffer.eco.util;

public enum OrderStatus {
    PLACED,     //order is placed, not picked up yet
    PICKED,     //order is picked up by the agent and on the way to destination
    COMPLETED,  //order is completed
    CANCELED    //order is canceled
}
