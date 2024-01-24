package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myintentapp.MoveActivity
import com.example.myintentapp.MoveWithDataActivity
import com.example.myintentapp.R

class MainActivity : ComponentActivity(), View.OnClickListener {
    val btnMoveActivity: Button = findViewById<Button>(R.id.btn_move_activity)
    val btnMoveWithData: Button = findViewById<Button>(R.id.btn_move_with_data2)
    val btnDialNumber: Button = findViewById<Button>(R.id.btn_dial)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(
                    this@MainActivity,
                    MoveActivity::class.java
                )
                startActivity(moveIntent)
            }

            R.id.btn_move_with_data2 -> {
                val moveWithDataIntent = Intent(
                    this@MainActivity,
                    MoveWithDataActivity::class.java
                )
                moveWithDataIntent.putExtra(
                    MoveWithDataActivity.EXTRA_NAME, "Aulia")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_ADDRESS,"Blitar")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_GENDER,"Perempuan")
                startActivity(moveWithDataIntent)
            }

            R.id.btn_dial -> {
                val phoneNumber = "081259418186"
                val dialPhoneIntent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel: $phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}