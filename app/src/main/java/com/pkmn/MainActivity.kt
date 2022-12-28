package com.pkmn

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pkmn.core.Type
import com.pkmn.core.calculateDamageTaken
import com.pkmn.core.noType
import com.pkmn.core.typeArray
import com.pkmn.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var typeNamesArray =
        arrayOf("", "Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost",
                 "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water")

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
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

    }

    private fun onCheckClicked() {
        var firstType = Type("", arrayOf())
        var secondType = Type("", arrayOf())
        
        var firstTypeOk = false
        var secondTypeOk = false
        var allOK = false

        if (binding.FirstTypeText.text.toString().equals("")) {
            firstType = noType
            firstTypeOk = true
        }
        if (binding.SecondTypeText.text.toString().equals("")) {
            secondType = noType
            secondTypeOk = true
        }

        for (i in 0..17) {
            if (binding.FirstTypeText.text.toString().equals
               (binding.SecondTypeText.text.toString())) {
                errorDialogSameType()
                break
            }

            if (firstType == noType && secondType == noType) {
                errorDialogNoType()
                break
            }
            
            if (firstTypeOk && secondTypeOk) {
                allOK = true
                break
            }
            
            if (!firstTypeOk && binding.FirstTypeText.text.toString().equals(typeArray[i].name)) {
                firstType = typeArray[i]
                firstTypeOk = true
            }
            if (!secondTypeOk && binding.SecondTypeText.text.toString().equals(typeArray[i].name) ) {
                secondType = typeArray[i]
                secondTypeOk = true
            }
        }

        if (allOK) {
            binding.ResultText.setText(calculateDamageTaken(firstType, secondType))
        }
    }

    private fun errorDialogNoType() {
        AlertDialog.Builder(this)
            .setTitle("Check failed")
            .setMessage("Must select at least a type")
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
}