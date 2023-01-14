package com.pkmn

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.pkmn.core.Type
import com.pkmn.core.calculateDamageTaken
import com.pkmn.core.noType
import com.pkmn.core.typeArray
import com.pkmn.databinding.ActivityMainBinding
import com.pkmn.databinding.ForTheLabelsBinding


class MainActivity : AppCompatActivity() {

    var typeNamesArray =
        arrayOf("", "Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost",
                 "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water")

    private lateinit var binding: ActivityMainBinding   ///// BINDING //////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

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

            binding.Types4x.removeAllViews()
            binding.Types2x.removeAllViews()
            binding.Types05x.removeAllViews()
            binding.Types0x.removeAllViews()

            binding.Result4x.visibility = View.VISIBLE
            binding.Types4x.visibility = View.VISIBLE

            binding.Result2x.visibility = View.VISIBLE
            binding.Types2x.visibility = View.VISIBLE

            binding.Result05x.visibility = View.VISIBLE
            binding.Types05x.visibility = View.VISIBLE

            binding.Result0x.visibility = View.VISIBLE
            binding.Types0x.visibility = View.VISIBLE

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

        binding.Result4x.visibility = View.VISIBLE
        binding.Types4x.visibility = View.VISIBLE

        binding.Result2x.visibility = View.VISIBLE
        binding.Types2x.visibility = View.VISIBLE

        binding.Result05x.visibility = View.VISIBLE
        binding.Types05x.visibility = View.VISIBLE

        binding.Result0x.visibility = View.VISIBLE
        binding.Types0x.visibility = View.VISIBLE
    }

/////////// PRINTING RESULT /////////////
    private fun type4xViewManagement(array:ArrayList<String>){
        if (array.size == 0){
            binding.Result4x.visibility = View.INVISIBLE
            binding.Types4x.visibility = View.INVISIBLE
            return
        }

        val typeViews = Array(array.size) { TextView(this) }
        val theParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        for (i in 0 until array.size){
            typeViews[i] = binding.LabelBase
            typeViews[i].setBackgroundResource(setTypeBackground(array[i]))
            typeViews[i].text = array[i]
            typeViews[i].visibility = View.VISIBLE

            runOnUiThread { binding.Types4x.addView(typeViews[i], -1, theParams) }
        }
    }

    private fun type2xViewManagement(array:ArrayList<String>){
        if (array.size == 0){
            binding.Result2x.visibility = View.INVISIBLE
            binding.Types2x.visibility = View.INVISIBLE
            return
        }

        val typeViews = Array(array.size) { TextView(this) }
        val theParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        for (i in 0 until array.size){
            typeViews[i] = binding.LabelBase
            typeViews[i].setBackgroundResource(setTypeBackground(array[i]))
            typeViews[i].text = array[i]
            typeViews[i].visibility = View.VISIBLE

            binding.Types2x.addView(typeViews[i], -1, theParams)
        }
    }

    private fun type05xViewManagement(array:ArrayList<String>){
        if (array.size == 0){
            binding.Result05x.visibility = View.INVISIBLE
            binding.Types05x.visibility = View.INVISIBLE
            return
        }

        val typeViews = Array(array.size) { TextView(this) }
        val theParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        for (i in 0 until array.size){
            typeViews[i] = binding.LabelBase
            typeViews[i].setBackgroundResource(setTypeBackground(array[i]))
            typeViews[i].text = array[i]
            typeViews[i].visibility = View.VISIBLE

            binding.Types05x.addView(typeViews[i], -1, theParams)
        }
    }

    private fun type0xViewManagement(array:ArrayList<String>){
        if (array.size == 0){
            binding.Result0x.visibility = View.INVISIBLE
            binding.Types0x.visibility = View.INVISIBLE
            return
        }

        val typeViews = Array(array.size) { TextView(this) }
        val theParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        for (i in 0 until array.size){
            typeViews[i] = binding.LabelBase
            typeViews[i].setBackgroundResource(setTypeBackground(array[i]))
            typeViews[i].text = array[i]
            typeViews[i].visibility = View.VISIBLE

            binding.Types0x.addView(typeViews[i], -1, theParams)
        }
    }
///////////////////

    private fun setTypeBackground(type:String) :Int {
        if (type == "Bug") return com.pkmn.R.drawable.bug_background
        if (type == "Dark") return com.pkmn.R.drawable.dark_background
        if (type == "Dragon") return com.pkmn.R.drawable.dragon_background
        if (type == "Electric") return com.pkmn.R.drawable.electric_background
        if (type == "Fairy") return com.pkmn.R.drawable.fairy_background
        if (type == "Fighting") return com.pkmn.R.drawable.fighting_background
        if (type == "Fire") return com.pkmn.R.drawable.fire_background
        if (type == "Flying") return com.pkmn.R.drawable.flying_background
        if (type == "Ghost") return com.pkmn.R.drawable.ghost_background
        if (type == "Grass") return com.pkmn.R.drawable.grass_background
        if (type == "Ground") return com.pkmn.R.drawable.ground_background
        if (type == "Ice") return com.pkmn.R.drawable.ice_background
        if (type == "Normal") return com.pkmn.R.drawable.normal_background
        if (type == "Poison") return com.pkmn.R.drawable.poison_background
        if (type == "Psychic") return com.pkmn.R.drawable.psychic_background
        if (type == "Rock") return com.pkmn.R.drawable.rock_background
        if (type == "Steel") return com.pkmn.R.drawable.steel_background
        if (type == "Water") return com.pkmn.R.drawable.water_background

        return 0
    }

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