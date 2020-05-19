package ua.com.cookienechettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle :Bundle? = intent.extras

        val image: String = bundle!!.getString("IMAGE")!!
        val author: String = bundle!!.getString("AUTHOR")!!

        Picasso.get().load(image).into(imageDetails)
        tvDetails.text = author

        btnSave.setOnClickListener(this::onClick)
    }

    private fun onClick(view: View) {
        when(view) {
            btnSave -> {

            }
        }
    }
}
