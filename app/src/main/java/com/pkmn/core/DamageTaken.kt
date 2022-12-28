package com.pkmn.core

class DamageTaken (var type: String, var multiplier: Float)


val noTypeTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val BugTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 0.5F),

    DamageTaken("Fire", 2F), DamageTaken("Flying", 2F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 0.5F), DamageTaken("Ground", 0.5F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 2F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val DarkTakes = arrayOf(
    DamageTaken("Bug", 2F), DamageTaken("Dark", 0.5F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 2F), DamageTaken("Fighting", 2F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 0.5F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 0F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val DragonTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 2F),

    DamageTaken("Electric", 0.5F), DamageTaken("Fairy", 2F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 0.5F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 0.5F), DamageTaken("Ground", 1F), DamageTaken("Ice", 2F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 0.5F),
)

val ElectricTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 0.5F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 0.5F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 2F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 0.5F), DamageTaken("Water", 1F),
)

val FairyTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 0.5F), DamageTaken("Dragon", 0F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 0.5F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 2F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 2F), DamageTaken("Water", 1F),
)

val FightingTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 0.5F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 2F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 2F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 2F),

    DamageTaken("Rock", 0.5F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val FireTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 0.5F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 0.5F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 0.5F), DamageTaken("Ground", 2F), DamageTaken("Ice", 0.5F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 2F), DamageTaken("Steel", 0.5F), DamageTaken("Water", 2F),
)

val FlyingTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 2F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 0.5F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 0F), DamageTaken("Ice", 2F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 2F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val GhostTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 2F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 0F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 2F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 0F), DamageTaken("Poison", 0.5F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val GrassTakes = arrayOf(
    DamageTaken("Bug", 2F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 0.5F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 2F), DamageTaken("Flying", 2F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 0.5F), DamageTaken("Ground", 0.5F), DamageTaken("Ice", 2F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 2F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 0.5F),
)

val GroundTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 0F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 2F), DamageTaken("Ground", 1F), DamageTaken("Ice", 2F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 0.5F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 0.5F), DamageTaken("Steel", 1F), DamageTaken("Water", 2F),
)

val IceTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 2F),

    DamageTaken("Fire", 2F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 0.5F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 2F), DamageTaken("Steel", 2F), DamageTaken("Water", 1F),
)

val NormalTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 2F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 0F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val PoisonTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 0.5F), DamageTaken("Fighting", 0.5F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 0.5F), DamageTaken("Ground", 2F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 0.5F), DamageTaken("Psychic", 2F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val PsychicTakes = arrayOf(
    DamageTaken("Bug", 2F), DamageTaken("Dark", 2F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 0.5F),

    DamageTaken("Fire", 1F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 2F),

    DamageTaken("Grass", 1F), DamageTaken("Ground", 1F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 0.5F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 1F), DamageTaken("Water", 1F),
)

val RockTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 2F),

    DamageTaken("Fire", 0.5F), DamageTaken("Flying", 0.5F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 2F), DamageTaken("Ground", 2F), DamageTaken("Ice", 1F),

    DamageTaken("Normal", 0.5F), DamageTaken("Poison", 0.5F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 2F), DamageTaken("Water", 2F),
)

val SteelTakes = arrayOf(
    DamageTaken("Bug", 0.5F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 0.5F),

    DamageTaken("Electric", 1F), DamageTaken("Fairy", 0.5F), DamageTaken("Fighting", 2F),

    DamageTaken("Fire", 2F), DamageTaken("Flying", 0.5F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 0.5F), DamageTaken("Ground", 2F), DamageTaken("Ice", 0.5F),

    DamageTaken("Normal", 0.5F), DamageTaken("Poison", 0F), DamageTaken("Psychic", 0.5F),

    DamageTaken("Rock", 0.5F), DamageTaken("Steel", 0.5F), DamageTaken("Water", 1F),
)

val WaterTakes = arrayOf(
    DamageTaken("Bug", 1F), DamageTaken("Dark", 1F), DamageTaken("Dragon", 1F),

    DamageTaken("Electric", 2F), DamageTaken("Fairy", 1F), DamageTaken("Fighting", 1F),

    DamageTaken("Fire", 0.5F), DamageTaken("Flying", 1F), DamageTaken("Ghost", 1F),

    DamageTaken("Grass", 2F), DamageTaken("Ground", 1F), DamageTaken("Ice", 0.5F),

    DamageTaken("Normal", 1F), DamageTaken("Poison", 1F), DamageTaken("Psychic", 1F),

    DamageTaken("Rock", 1F), DamageTaken("Steel", 0.5F), DamageTaken("Water", 0.5F),
)