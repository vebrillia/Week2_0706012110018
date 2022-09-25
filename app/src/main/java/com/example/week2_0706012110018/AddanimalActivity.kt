package com.example.week2_0706012110018

import Database.GlobalVar
import Model.Animal
import Model.Chicken
import Model.Cow
import Model.Goat
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_addanimal.*
import kotlinx.android.synthetic.main.activity_recyclerview.*

class AddanimalActivity : AppCompatActivity() {
    private lateinit var animal: Animal
    var position = -1
    var image : String = ""

    private val GetResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val uri = it.data?.data
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if(uri != null){
                    baseContext.getContentResolver().takePersistableUriPermission(uri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                    )
                }}
            imageView2.setImageURI(uri)
            image = uri.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addanimal)
        supportActionBar?.hide()
        getintent()
        listener()
    }

    private fun getintent(){
        position = intent.getIntExtra("position",-1)
        if(position != -1){
            val animal = GlobalVar.listDataAnimal[position]
            toolbar2.title = "Edit Animal"
            add_button.text = "Edit"
            imageView2.setImageURI(Uri.parse(GlobalVar.listDataAnimal[position].imageUri))
            input_name.editText?.setText(animal.name)
            input_age.editText?.setText(animal.age.toString())

            when(animal?.species) {
                "Chicken" -> chickenradio.setChecked(true)
                "Cow" -> cowradio.setChecked(true)
                "Goat" -> goatradio.setChecked(true)
            }

        }
    }

    private fun listener(){
        imageView2.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            myIntent.type = "image/*"
            GetResult.launch(myIntent)
        }

        add_button.setOnClickListener {
//

            if (animalradio.checkedRadioButtonId == -1) {
                var name = input_name.editText?.text.toString().trim()
                var age = 0
                var species = ""
                animal = Chicken(name, species, age)
                checker()
                
            } else {
                var name = input_name.editText?.text.toString().trim()
                var age = 0
                var species =
                    findViewById<RadioButton>(animalradio.checkedRadioButtonId).text.toString()
                if (species == "Chicken") {
                    animal = Chicken(name, species, age)
                    checker()
                } else if (species == "Cow") {
                    animal = Cow(name, species, age)
                    checker()
                } else {
                    animal = Goat(name, species, age)
                    checker()
                }

            }


        }


        toolbar2.getChildAt(1).setOnClickListener {
            finish()
        }
    }

    private fun checker(){
        var isCompleted : Boolean = true
        animal.imageUri = image.toString()


        if(animal.name!!.isEmpty()){
            input_name.error = "Name cannot be empty"
            isCompleted = false
        }else{
            input_name.error= ""
        }

        if(animal.species!!.isEmpty()){
            chickenradio.error = "?"
            cowradio.error = "?"
            goatradio.error = "?"
            isCompleted = false
        }

        if(input_age.editText?.text.toString().isEmpty() || input_age.editText?.text.toString().toInt()<0){
            input_age.error = "Age cannot be empty or 0"
            isCompleted = false
        }else {
            input_age.error = ""
        }




        if (isCompleted == true){
            if (position == -1){
                animal.age = input_age.editText?.text.toString().toInt()
                GlobalVar.listDataAnimal.add(animal)
            }else{
                animal.age = input_age.editText?.text.toString().toInt()
                GlobalVar.listDataAnimal[position] = animal
            }
            finish()

        }
    }
}