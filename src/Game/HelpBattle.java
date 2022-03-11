package Game;

import Pokemons.Ability;
import Pokemons.Pokemon;

import java.util.logging.Logger;

public class HelpBattle {
    // this method coordinates what happens if both pokemons use one of their abilities
    static void abilityVsAbility(Pokemon pokemonA, Pokemon pokemonB, Ability abilityA,
                                 Ability abilityB, Logger logger,
                                 int indexAbilityA, int indexAbilityB) {
        if(CoachesBattle.stun[0] == 1) {    // pokemon A is stunned
            logger.info("Pokemon " + pokemonA.getName() + " is stunned!");
            if(CoachesBattle.stun[1] == 0) {    // pokemon B is not stunned
                logger.info("Pokemon " + pokemonB.getName() + " uses ability " + indexAbilityB + "!");
                pokemonA.setHP(pokemonA.getHP() - abilityB.getDamage());
                if(!abilityB.getStun()) {
                    CoachesBattle.stun[0] = 0;
                }
            } else {    // pokemon B is stunned
                logger.info("Pokemon " + pokemonB.getName() + " is stunned!");
                CoachesBattle.stun[0] = 0;
                CoachesBattle.stun[1] = 0;
            }
        } else {    // pokemon A is not stunned
            logger.info("Pokemon " + pokemonA.getName() + " uses ability " + indexAbilityA + "!");
            if(CoachesBattle.stun[1] == 1) {    // pokemon B is stunned
                logger.info("Pokemon " + pokemonB.getName() + " is stunned!");
                pokemonB.setHP(pokemonB.getHP() - abilityA.getDamage());
                if(!abilityA.getStun()) {
                    CoachesBattle.stun[1] = 0;
                }
            } else {    // pokemon B is not stunned
                logger.info("Pokemon " + pokemonB.getName() + " uses ability " + indexAbilityB + "!");
                if(!abilityA.getDodge()) {
                    pokemonA.setHP(pokemonA.getHP() - abilityB.getDamage());
                }
                if(!abilityB.getDodge()) {
                    pokemonB.setHP(pokemonB.getHP() - abilityA.getDamage());
                }
                if(abilityA.getStun()) {
                    CoachesBattle.stun[1] = 1;
                }
                if(abilityB.getStun()) {
                    CoachesBattle.stun[0] = 1;
                }
            }
        }
    }
}
