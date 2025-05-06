package com.android.chefshare.api.action

import android.util.Log
import android.widget.EditText
import com.android.chefshare.api.RetrofitInstance
import com.android.chefshare.model.*
import convertToJsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class doAction(private val data: EditText? = null) {

    val api = RetrofitInstance.apiAction

    private fun <T> fetchData(request: suspend () -> Response<T>, onSuccess: (T) -> Unit, onError: (Exception) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = request()
                Log.d("CCC", "Raw response: ${response.raw()}")
                Log.d("CCCC", "Response body: ${response.body()}")
                Log.d("CCCCC", "Error body: ${response.errorBody()?.string()}")
                if (response.isSuccessful) {
                    response.body()?.let { body ->
                        withContext(Dispatchers.Main) {
                            onSuccess(body)
                        }
                    } ?: onError(Exception("Response body is null"))
                } else {
                    val errorBody = response.errorBody()?.string() ?: "No error body"
                    onError(Exception("Request failed with code: ${response.code()}, error: $errorBody"))
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
                Log.e("CCC4", "Error: ${e.message}")
            }
        }
    }

/*----------------------------THEM---------------------------*/
    fun themBaiDang(baidang: baiDang) {
        val dataJson = convertToJsonObject(baidang)
        fetchData(
            request = { api.themBaiDang(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themBaiDangCachNau(baiDangCachNau: baiDangCachNau) {
        val dataJson = convertToJsonObject(baiDangCachNau)
        fetchData(
            request = { api.themBaiDangCachNau(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themBaiDangChiDan(baiDangChiDan: baiDangChiDan) {
        val dataJson = convertToJsonObject(baiDangChiDan)
        fetchData(
            request = { api.themBaiDangChiDan(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themBaiDangDaThich(baiDangDaThich: baiDangDaThich) {
        val dataJson = convertToJsonObject(baiDangDaThich)
        fetchData(
            request = { api.themBaiDangDaThich(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themBaiDangDungCu(baiDangDungCu: baiDangDungCu) {
        val dataJson = convertToJsonObject(baiDangDungCu)
        fetchData(
            request = { api.themBaiDangDungCu(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themBaiDangNguyenLieu(baiDangNguyenLieu: baiDangNguyenLieu) {
        val dataJson = convertToJsonObject(baiDangNguyenLieu)
        fetchData(
            request = { api.themBaiDangNguyenLieu(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themCachNau(cachNau: cachNau) {
        val dataJson = convertToJsonObject(cachNau)
        fetchData(
            request = { api.themCachNau(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themChiDan(chiDan: chiDan) {
        val dataJson = convertToJsonObject(chiDan)
        fetchData(
            request = { api.themChiDan(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themDungCu(dungCu: dungCu) {
        val dataJson = convertToJsonObject(dungCu)
        fetchData(
            request = { api.themDungCu(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themNguyenLieu(nguyenLieu: nguyenLieu) {
        val dataJson = convertToJsonObject(nguyenLieu)
        fetchData(
            request = { api.themNguyenLieu(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun themTheoDoi(theoDoi: theoDoi) {
        val dataJson = convertToJsonObject(theoDoi)
        fetchData(
            request = { api.themTheoDoi(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
/*----------------------------XOA----------------------------*/
    fun xoaBaiDang(idbaiDang: Int) {
    fetchData(
        request = { api.xoaBaiDang(idbaiDang) },
        onSuccess = { result ->

            Log.d("QQQQ", "Success: $result")
        },
        onError = { error ->
            data?.setText("Error: ${error.message}")
            Log.e("QQQQ", "Error: ${error.message}")
        }
    )
}
    fun xoaTheoDoi(idNguoiDung: String) {
//        val dataJson = convertToJsonObject(theoDoi)
        fetchData(
            request = { api.xoaTheoDoi(idNguoiDung) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
/*----------------------------SUA----------------------------*/
fun capnhatBaiDang(baidang: baiDang) {
    val dataJson = convertToJsonObject(baidang)
    fetchData(
        request = { api.capnhatBaiDang(dataJson) },
        onSuccess = { result ->

            Log.d("QQQQ", "Success: $result")
        },
        onError = { error ->
            data?.setText("Error: ${error.message}")
            Log.e("QQQQ", "Error: ${error.message}")
        }
    )
}
    fun capnhatBaiDangCachNau(baiDangCachNau: baiDangCachNau) {
        val dataJson = convertToJsonObject(baiDangCachNau)
        fetchData(
            request = { api.capnhatBaiDangCachNau(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun capnhatBaiDangChiDan(baiDangChiDan: baiDangChiDan) {
        val dataJson = convertToJsonObject(baiDangChiDan)
        fetchData(
            request = { api.capnhatBaiDangChiDan(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun capnhatBaiDangDaThich(baiDangDaThich: baiDangDaThich) {
        val dataJson = convertToJsonObject(baiDangDaThich)
        fetchData(
            request = { api.capnhatBaiDangDaThich(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun capnhatBaiDangDungCu(baiDangDungCu: baiDangDungCu) {
        val dataJson = convertToJsonObject(baiDangDungCu)
        fetchData(
            request = { api.capnhatBaiDangDungCu(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun capnhatBaiDangNguyenLieu(baiDangNguyenLieu: baiDangNguyenLieu) {
        val dataJson = convertToJsonObject(baiDangNguyenLieu)
        fetchData(
            request = { api.capnhatBaiDangNguyenLieu(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
    fun capnhatChiDan(chiDan: chiDan) {
        val dataJson = convertToJsonObject(chiDan)
        fetchData(
            request = { api.capnhatChiDan(dataJson) },
            onSuccess = { result ->

                Log.d("QQQQ", "Success: $result")
            },
            onError = { error ->
                data?.setText("Error: ${error.message}")
                Log.e("QQQQ", "Error: ${error.message}")
            }
        )
    }
}
