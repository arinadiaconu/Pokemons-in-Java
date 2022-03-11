package Game;

import Pokemons.Ability;
import Pokemons.Pokemon;

import java.util.logging.Logger;

public class HelpBattle1 {
    // this method coordinates what happens if a pokemon attacks and the other uses one of its abilities
    static void abilityVsAttack(Pokemon attackPokemon, Pokemon abilityPokemon, Ability ability,
                        Logger logger, int abilityIndex, int attackIndex, int abilityIndexForStun) {
        if(CoachesBattle.stun[attackIndex] == 1) {  // attackPokemon is stunned
            logger.info("Pokemon " + attackPokemon.getName() + " is stunned!");
            if(CoachesBattle.stun[abilityIndexForStun] == 0) {  // abilityPokemon is not stunned
                logger.info("Pokemon " + abilityPokemon.getName() + " uses ability "
                        + abilityIndex + "!");
                attackPokemon.setHP(attackPokemon.getHP() - ability.getDamage());
                if(!ability.getStun()) {
                    CoachesBattle.stun[attackIndex] = 0;
                }
            } else {    // abilityPokemon is stunned
                logger.info("Pokemon " + abilityPokemon.getName() + " is stunned!");
                CoachesBattle.stun[abilityIndexForStun] = 0;
                CoachesBattle.stun[attackIndex] = 0;
            }
        } else {    // attack pokemon is not stunned
            logger.info("Pokemon " + attackPokemon.getName() + " attacks!");
            if(CoachesBattle.stun[abilityIndexForStun] == 1) {  // abilityPokemon is stunned
                logger.info("Pokemon " + abilityPokemon.getName() + " is stunned!");
                HelpBattle2.attackPokemon(abilityPokemon, attackPokemon);
            } else {    // abilityPokemon is not stunned
                logger.info("Pokemon " + abilityPokemon.getName() + " uses ability "
                        + abilityIndex + "!");
                if (!ability.getDodge()) {
                    HelpBattle2.attackPokemon(abilityPokemon, attackPokemon);
                } else {
                    logger.info("Pokemon " + abilityPokemon.getName() + " dodges the attack!");
                }
                attackPokemon.setHP(attackPokemon.getHP() - ability.getDamage());
                if (ability.getStun()) {
                    CoachesBattle.stun[attackIndex] = 1;
                }
            }
        }
    }
}
