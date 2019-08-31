package com.natuan.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionBarView.ActionBarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        action_bar.actionBarListener = this
    }

    override fun onActionBarItemSelected(view: View) {
        when (view.id) {
            R.id.left_btn -> {
                Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show()
            }
            R.id.right_btn -> {
                Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
