package com.example.activitytest
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import android.widget.Button
import android.view.MenuItem
class FirstActivity : AppCompatActivity() {
    private val activityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val returnData = result.data
            val msg = returnData?.getStringExtra("result")
            Toast.makeText(this@FirstActivity, "获取返回信息：$msg", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            activityLauncher.launch(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}