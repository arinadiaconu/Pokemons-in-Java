package Game;

import Pokemons.Pokemon;

import java.util.logging.Logger;

public class HelpBattle2 {
    // this method checks the cooldown status for a given Pokemon for both abilities
    static void checkCooldown(Logger logger, Pokemon pokemon, int[] cooldownPokemon) {
        if (cooldownPokemon[0] != 0) {
            cooldownPokemon[0]--;
        }
        if(cooldownPokemon[0] >= 0) {
            logger.info("Cooldown ability 1 for " + pokemon.getName() +
                    " is " + cooldownPokemon[0]);
        }
        if (cooldownPokemon[1] != 0) {
            cooldownPokemon[1]--;
            logger.info("Cooldown ability 2 for " + pokemon.getName() +
                    " is " + cooldownPokemon[1]);
        }
    }

    // this method checks if the pokemons are not stunned and can attack
    static void pokemonsAttack(Logger logger, int[] stun, Pokemon pokemon1, Pokemon pokemon2) {
        if(stun[0] == 0) {
            attackPokemon(pokemon2, pokemon1);
            logger.info("Pokemon " + pokemon1.getName() + " attacks!");
        } else {
            stun[0] = 0;
            logger.info("Pokemon " + pokemon1.getName() + " is stunned!");
        }
        if(stun[1] == 0) {
            attackPokemon(pokemon1, pokemon2);
            logger.info("Pokemon " + pokemon2.getName() + " attacks!");
        } else {
            stun[1] = 0;
            logger.info("Pokemon " + pokemon2.getName() + " is stunned!");
        }
    }

    // this method coordinates the attack and verifies each pokemon's type of attack
    static void attackPokemon(Pokemon attackedPokemon, Pokemon attackerPokemon) {
        if(attackerPokemon.getNormalAttack() != 0) {    // normal attack
            if(attackerPokemon.getNormalAttack() > attackedPokemon.getNormalDefense()) {
                attackedPokemon.setHP(attackedPokemon.getHP() - (attackerPokemon.getNormalAttack() -
                        attackedPokemon.getNormalDefense()));
            } else {
                attackedPokemon.setNormalDefense(attackedPokemon.getNormalDefense() - 1);
            }
        } else {    // special attack
            if(attackerPokemon.getSpecialAttack() > attackedPokemon.getSpecialDefense()) {
                attackedPokemon.setHP(attackedPokemon.getHP() - (attackerPokemon.getSpecialAttack() -
                        attackedPokemon.getSpecialDefense()));
            } else {
                attackedPokemon.setSpecialDefense(attackedPokemon.getSpecialDefense() - 1);
            }
        }
    }
}
