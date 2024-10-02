package com.example.travelphotoapp

import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    lateinit var image : ImageView
    var places = arrayOf("Roorkee","Chandighar","Delhi","Kadar Nath","Meerut")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnprev)
        val placeName = findViewById<TextView>(R.id.tvName)

        next.setOnClickListener{
            // I want to see the next Image
            var idCurrentImageString= "pic$currentImage"

            // i have to get the integer address associated with each view
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f     // f = Float AND MAKE IMAGE TO HIDE

            currentImage = (5 + currentImage + 1) % 5     // add and mod of 5 here means when we are at img 4 & click next we go to zero
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f     // f = Float AND MAKE IMAGE TO VISIBLE
            placeName.text= places[currentImage]     // Show the place name
        }

        prev.setOnClickListener{
            // I want to see the next Image
            var idCurrentImageString= "pic$currentImage"

            // i have to get the integer address associated with each view
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f     // f = Float AND MAKE IMAGE TO HIDE

            currentImage = (5 + currentImage - 1) % 5     // add and mod of 5 here means when we are at img 4 & click privews we go to zero
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f     // f = Float AND MAKE IMAGE TO VISIBLE
            placeName.text= places[currentImage]     // Show the place name
        }
    }
}