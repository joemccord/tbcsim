package data.buffs

import character.Ability
import character.Buff
import character.Stats
import sim.SimIteration

class AbacusOfViolentOdds : Buff() {
    companion object {
        const val name = "Abacus of Violent Odds (static)"
    }
    override val id: Int = 33807
    override val name: String = Companion.name
    override val durationMs: Int = -1
    override val hidden: Boolean = true

    val buffDurationMs = 10000
    val hasteBuff = object : Buff() {
        override val name: String  = "Abacus of Violent Odds"
        override val durationMs: Int = buffDurationMs

        override fun modifyStats(sim: SimIteration): Stats? {
            return Stats(physicalHasteRating = 260.0)
        }
    }

    val ability = object : Ability() {
        override val id: Int = 33807
        override val name: String = "Abacus of Violent Odds"
        override fun gcdMs(sim: SimIteration): Int = 0
        override fun cooldownMs(sim: SimIteration): Int = 120000

        override fun trinketLockoutMs(sim: SimIteration): Int = buffDurationMs

        override fun cast(sim: SimIteration) {
            sim.addBuff(hasteBuff)
        }
    }

    override fun activeTrinketAbility(sim: SimIteration): Ability = ability
}
