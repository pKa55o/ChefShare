package com.android.chefshare.repo

import org.json.JSONObject

class ApiDataProcess {
    fun callDataApi () {

    }
    fun callDataRoom() {

    }
    fun compareData(jsonObject: JSONObject){
        if (callDataRoom() != callDataApi()) {
//            Data data = new (callDataApi())
        }
    }
}