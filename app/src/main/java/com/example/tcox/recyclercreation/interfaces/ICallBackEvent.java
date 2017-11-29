package com.example.tcox.recyclercreation.interfaces;

import com.example.tcox.recyclercreation.models.MobileEngineer;

import java.util.ArrayList;

/**
 * Created by tcox on 11/29/17.
 */

public interface ICallBackEvent {

    void onComplete(ArrayList<MobileEngineer> aMobileEngineer);

    void onError(Exception e);
}
