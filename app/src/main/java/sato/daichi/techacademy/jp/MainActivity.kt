package sato.daichi.techacademy.jp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_second.*
import org.w3c.dom.Text
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction



class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        //入力した数字を文字列に変換して変数に格納
        var Text1 = editValue1.text.toString()
        var Text2 = editValue2.text.toString()

        //空欄判定
        if (TextUtils.isEmpty(Text1) || TextUtils.isEmpty(Text2)){
            Snackbar.make(v, "空欄があります。何か数値を入力してください。", Snackbar.LENGTH_SHORT).show();
        }
        else {
            //入力した数字(文字列)をDouble型に変換
            var val1: Double = Text1.toDouble()
            var val2: Double = Text2.toDouble()

            //ボタンによる四則演算の出し分け
            when (v.id) {
                R.id.button1 -> Addition(val1,val2)
                R.id.button2 -> Subtraction(val1,val2)
                R.id.button3 -> Multiplication(val1,val2)
                R.id.button4 -> Division(val1,val2)
            }
        }
    }

    //足し算
    private fun Addition( val1: Double, val2: Double ){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("ANSWER", val1 + val2)
        startActivity(intent)
    }
    //引き算
    private fun Subtraction( val1: Double, val2: Double ){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("ANSWER", val1 - val2)
        startActivity(intent)
    }
    //掛け算
    private fun Multiplication( val1: Double, val2: Double ){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("ANSWER", val1 * val2)
        startActivity(intent)
    }
    //割り算
    private fun Division( val1: Double, val2: Double ){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("ANSWER", val1 / val2)
        startActivity(intent)
    }
}
