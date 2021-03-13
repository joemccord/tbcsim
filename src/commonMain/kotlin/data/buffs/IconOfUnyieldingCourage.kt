package data.buffs

import character.Ability
import character.Buff
import character.Stats
import sim.SimIteration

class IconOfUnyieldingCourage : Buff() {
    companion object {
        const val name = "Icon of Unyielding Courage (static)"
    }
    override val id: Int = 33807
    override val name: String = Companion.name
    override val durationMs: Int = -1
    override val hidden: Boolean = true

    val buffDurationMs = 20000
    val arpBuff = object : Buff() {
        override val name: String  = "Icon of Unyielding Courage"
        override val durationMs: Int = buffDurationMs

        override fun modifyStats(sim: SimIteration): Stats? {
            return Stats(armorPen = 600)
        }
    }

    val ability = object : Ability() {
        override val id: Int = 33807
        override val name: String = "Icon of Unyielding Courage"
        override fun gcdMs(sim: SimIteration): Int = 0
        override fun cooldownMs(sim: SimIteration): Int = 120000

        override fun trinketLockoutMs(sim: SimIteration): Int = buffDurationMs

        override fun cast(sim: SimIteration) {
            sim.addBuff(arpBuff)
        }
    }

    override fun activeTrinketAbility(sim: SimIteration): Ability = ability
}
