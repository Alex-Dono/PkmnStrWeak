package com.pkmn

import android.R
import android.app.ActionBar
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import com.google.android.material.appbar.AppBarLayout
import com.pkmn.core.Type
import com.pkmn.core.calculateDamageTaken
import com.pkmn.core.noType
import com.pkmn.core.typeArray
import com.pkmn.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var typeNamesArray =
        arrayOf("", "Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost",
                 "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water")

    private lateinit var binding: ActivityMainBinding   ///// BINDING //////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.BarLayout2.visibility = View.INVISIBLE

        setContentView(binding.root)


        //Create Array Adapter
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.select_dialog_singlechoice, typeNamesArray)
        //Find TextView control
        val acTextView1 = binding.FirstTypeText
        val acTextView2 = binding.SecondTypeText
        //Set the number of characters the user must type before the drop down list is shown
        acTextView1.threshold = 0
        acTextView2.threshold = 0
        //Set the adapter
        acTextView1.setAdapter(adapter)
        acTextView2.setAdapter(adapter)


        binding.CheckButton.setOnClickListener { onCheckClicked() }

        binding.FirstTypeText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) onTypeClicked() }
        binding.SecondTypeText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) onTypeClicked() }
    }

/////// CHECK IS CLICKED ////////
    private fun onCheckClicked() {
        var firstType = Type("", arrayOf());  var secondType = Type("", arrayOf())
        
        var firstTypeOk = false;  var secondTypeOk = false;  var allOK = false

        if (binding.FirstTypeText.text.toString().equals("")) {
            firstType = noType
            firstTypeOk = true }

        if (binding.SecondTypeText.text.toString().equals("")) {
            secondType = noType
            secondTypeOk = true }

        if (firstType == noType && secondType == noType) {
            errorDialogNoType()
            return }

        if (binding.FirstTypeText.text.toString().equals
                (binding.SecondTypeText.text.toString())) {
            errorDialogSameType()
            return }

        for (i in 0..17) {
            if (!firstTypeOk && binding.FirstTypeText.text.toString().
                equals(typeArray[i].name)) {
                firstType = typeArray[i]
                firstTypeOk = true }

            if (!secondTypeOk && binding.SecondTypeText.text.toString().
                equals(typeArray[i].name) ) {
                secondType = typeArray[i]
                secondTypeOk = true }

            if (firstTypeOk && secondTypeOk) {
                allOK = true
                break }

        }

        if (allOK) {

            val theArrays = calculateDamageTaken(firstType, secondType)

            val x4 = theArrays[0]; val x2 = theArrays[1];
            val x05 = theArrays[2]; val x0 = theArrays[3]

            type4xViewManagement(x4)
            type2xViewManagement(x2)
            type05xViewManagement(x05)
            type0xViewManagement(x0)

            binding.BarLayout2.visibility = View.VISIBLE
        }
    }
///////////////

    private fun onTypeClicked(){
        binding.BarLayout2.visibility = View.INVISIBLE
    }

/////////// PRINTING RESULT /////////////
    private fun type4xViewManagement(array:ArrayList<String>){

        if (array.size == 0){
            binding.Result4x.visibility = View.INVISIBLE
            binding.Types4x.visibility = View.INVISIBLE
            return
        }

        val remainingTypes = Array(array.size-2) { TextView(this) }

        for (i in 0 until array.size){
            if (i == 0){
                binding.Type4xLabel1.text = array[0]
                binding.Type4xLabel2.visibility = View.INVISIBLE
                continue
            }
            if (i == 1){
                binding.Type4xLabel1.text = array[1]
                binding.Type4xLabel2.visibility = View.VISIBLE
                continue
            }

            remainingTypes[i - 2].layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layout(10, 5, 5, 0)
            remainingTypes[i - 2].setPadding(5)
            remainingTypes[i - 2].text = array[i]
            remainingTypes[i - 2].setTextColor(Color.BLACK)
            remainingTypes[i - 2].textSize = 15F
            remainingTypes[i - 2].setTypeface(null, Typeface.BOLD)
            remainingTypes[i - 2].setBackgroundResource(com.pkmn.R.drawable.rounded_corner_view)

            binding.Types4x.addView(remainingTypes[i - 2])
        }
    }

    private fun type2xViewManagement(array:ArrayList<String>){

        if (array.size == 0){
            binding.Result2x.visibility = View.INVISIBLE
            binding.Types2x.visibility = View.INVISIBLE
            return
        }

        val remainingTypes = Array(array.size-2) { TextView(this) }

        for (i in 0 until array.size){
            if (i == 0){
                binding.Type2xLabel1.text = array[0]
                binding.Type4xLabel2.visibility = View.INVISIBLE
                continue
            }
            if (i == 1){
                binding.Type2xLabel1.text = array[1]
                binding.Type2xLabel2.visibility = View.VISIBLE
                continue
            }

            remainingTypes[i - 2].layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layout(10, 5, 5, 0)
            remainingTypes[i - 2].setPadding(5)
            remainingTypes[i - 2].text = array[i]
            remainingTypes[i - 2].setTextColor(Color.BLACK)
            remainingTypes[i - 2].textSize = 15F
            remainingTypes[i - 2].setTypeface(null, Typeface.BOLD)
            remainingTypes[i - 2].setBackgroundResource(com.pkmn.R.drawable.rounded_corner_view)

            binding.Types2x.addView(remainingTypes[i - 2])
        }
    }

    private fun type05xViewManagement(array:ArrayList<String>){

        if (array.size == 0){
            binding.Result05x.visibility = View.INVISIBLE
            binding.Types05x.visibility = View.INVISIBLE
            return
        }

        val remainingTypes = Array(array.size-2) { TextView(this) }

        for (i in 0 until array.size){
            if (i == 0){
                binding.Type05xLabel1.text = array[0]
                binding.Type05xLabel2.visibility = View.INVISIBLE
                continue
            }
            if (i == 1){
                binding.Type05xLabel1.text = array[1]
                binding.Type05xLabel2.visibility = View.VISIBLE
                continue
            }

            remainingTypes[i - 2].layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layout(10, 5, 5, 0)
            remainingTypes[i - 2].setPadding(5)
            remainingTypes[i - 2].text = array[i]
            remainingTypes[i - 2].setTextColor(Color.BLACK)
            remainingTypes[i - 2].textSize = 15F
            remainingTypes[i - 2].setTypeface(null, Typeface.BOLD)
            remainingTypes[i - 2].setBackgroundResource(com.pkmn.R.drawable.rounded_corner_view)

            binding.Types05x.addView(remainingTypes[i - 2])
        }
    }

    private fun type0xViewManagement(array:ArrayList<String>){

        if (array.size == 0){
            binding.Result0x.visibility = View.INVISIBLE
            binding.Types0x.visibility = View.INVISIBLE
            return
        }

        val remainingTypes = Array(array.size-2) { TextView(this) }

        for (i in 0 until array.size){
            if (i == 0){
                binding.Type0xLabel1.text = array[0]
                binding.Type0xLabel2.visibility = View.INVISIBLE
                continue
            }
            if (i == 1){
                binding.Type0xLabel1.text = array[1]
                binding.Type0xLabel2.visibility = View.VISIBLE
                continue
            }

            remainingTypes[i - 2].layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            remainingTypes[i - 2].layout(10, 5, 5, 0)
            remainingTypes[i - 2].setPadding(5)
            remainingTypes[i - 2].text = array[i]
            remainingTypes[i - 2].setTextColor(Color.BLACK)
            remainingTypes[i - 2].textSize = 15F
            remainingTypes[i - 2].setTypeface(null, Typeface.BOLD)
            remainingTypes[i - 2].setBackgroundResource(com.pkmn.R.drawable.rounded_corner_view)

            binding.Types0x.addView(remainingTypes[i - 2])
        }
    }
///////////////////


//////// ERRORS //////////
    private fun errorDialogNoType() {
        AlertDialog.Builder(this)
            .setTitle("Check failed")
            .setMessage("Must select at least a Type")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun errorDialogSameType() {
        AlertDialog.Builder(this)
            .setTitle("Check failed")
            .setMessage("Select two different Types or just one Type")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
///////////////
}