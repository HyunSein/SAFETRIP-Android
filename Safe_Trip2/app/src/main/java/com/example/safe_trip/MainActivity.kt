package com.example.safe_trip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private val jsonString =
        "{\"UserInfo\":[{\"travelNo\":1252563,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"갤러리 엠\",\"inside\":true}" +
                ",{\"travelNo\":1288095,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"디아프바인\",\"inside\":true}" +
                ",{\"travelNo\":1304231,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"금강제화 (강남본점)\",\"inside\":true}" +
                ",{\"travelNo\":1756249,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"강남목장\",\"inside\":true}" +
                ",{\"travelNo\":1781832,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"더 비 (The B)\",\"inside\":true}" +
                ",{\"travelNo\":2642151,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"갤러리JJ\",\"inside\":true}" +
                ",{\"travelNo\":2643060,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"게방식당\",\"inside\":true}" +
                ",{\"travelNo\":2652946,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"계절밥상 코엑스몰\",\"inside\":true}" +
                ",{\"travelNo\":2660518,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"강정희 간장새우\",\"inside\":true}" +
                ",{\"travelNo\":2685274,\"star\":0.0,\"pplNo\":0,\"fieldNo\":1,\"name\":\"갓덴스시 강남\",\"inside\":true}]}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {


            val userInfo = JSONObject(jsonString)
            val jsonArray = userInfo.optJSONArray("UserInfo")

            var i = 0
            var tempStr = ""
            while (i < jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)

                val travelNo = jsonObject.getString("travelNo")
                val star = jsonObject.getDouble("star")
                val pplNo = jsonObject.getInt("pplNo")
                val fieldNo = jsonObject.getInt("fieldNo")
                val name = jsonObject.getString("name")
                val inside = jsonObject.getBoolean("inside")

                tempStr += "여행지번호: $travelNo\n평점: $star\n" +
                        "pplno: $pplNo\n" +
                        "fieldNo: $fieldNo\n" + "이름: $name\n" + "실내 : $inside\n"
                i++
            }

            resultTextView.text = tempStr
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}