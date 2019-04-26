package sato.daichi.techacademy.jp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //戻ってきた計算結果をDouble型変数に格納
        val ans = intent.getDoubleExtra("ANSWER", 0.0)
        //答え表示
        textView.text = "$ans"
    }
}
