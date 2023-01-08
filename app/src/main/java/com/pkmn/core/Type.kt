package com.pkmn.core

class Type(var name: String, var damageTaken: Array<DamageTaken>)

/////// TYPES ////////
val noType = Type("", noTypeTakes)

val Bug = Type("Bug", BugTakes)

val Dark = Type("Dark", DarkTakes)

val Dragon = Type("Dragon", DragonTakes)

val Electric = Type("Electric", ElectricTakes)

val Fairy = Type("Fairy", FairyTakes)

val Fighting = Type("Fighting", FightingTakes)

val Fire = Type("Fire", FireTakes)

val Flying = Type("Flying", FlyingTakes)

val Ghost = Type("Ghost", GhostTakes)

val Grass = Type("Grass", GrassTakes)

val Ground = Type("Ground", GroundTakes)

val Ice = Type("Ice", IceTakes)

val Normal = Type("Normal", NormalTakes)

val Poison = Type("Poison", PoisonTakes)

val Psychic = Type("Psychic", PsychicTakes)

val Rock = Type("Rock", RockTakes)

val Steel = Type("Steel", SteelTakes)

val Water = Type("Water", WaterTakes)
///////////////

val typeArray = arrayOf (Bug, Dark, Dragon, Electric, Fairy, Fighting, Fire, Flying,
                         Ghost, Grass, Ground, Ice, Normal, Poison, Psychic, Rock, Steel, Water)

/////// DAMAGE CALCULATION /////////
fun calculateDamageTaken(type1: Type, type2: Type): ArrayList<ArrayList<String>> {
    var combination = Type("Combination", Array(18) { DamageTaken("", 1F) })
    val currentDamageTaken = DamageTaken("", 1F)
    for (i in 0..17) {
        if (type1 == noType) {
            combination = type2; break
        }
        if (type2 == noType) {
            combination = type1; break
        }

        currentDamageTaken.type = type1.damageTaken[i].type
        currentDamageTaken.multiplier =
            type1.damageTaken[i].multiplier * type2.damageTaken[i].multiplier
        combination.damageTaken[i].type = currentDamageTaken.type
        combination.damageTaken[i].multiplier = currentDamageTaken.multiplier
    }

    val x4 = arrayListOf<String>()
    val x2 = arrayListOf<String>()
    val x05 = arrayListOf<String>()
    val x0 = arrayListOf<String>()

    for (i in 0..17) {
        if (combination.damageTaken[i].multiplier == 4F) x4.add(combination.damageTaken[i].type)
        if (combination.damageTaken[i].multiplier == 2F) x2.add(combination.damageTaken[i].type)
        if (combination.damageTaken[i].multiplier == 0.5F) x05.add(combination.damageTaken[i].type)
        if (combination.damageTaken[i].multiplier == 0F) x0.add(combination.damageTaken[i].type)
    }

    return arrayListOf(x4, x2, x05, x0)
}
////////////