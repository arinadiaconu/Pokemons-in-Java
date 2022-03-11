package Game;

import Pokemons.Pokemon;
import Pokemons.PokemonFactory;

import java.util.Random;
import java.util.logging.Logger;

public class FightNeutrel2 {
    // this method coordinates the fight with a Neutrel 2
    public static Boolean fight (Pokemon pokemon, Logger logger) {
        Pokemon neutral2 = PokemonFactory.getSingletonInstance().returnPokemon(PokemonFactory.PokemonType.Neutrel2);
        logger.info("This duel is between the following two pokemons!");
        logger.info(pokemon.toString());
        logger.info(neutral2.toStringWithoutAbility());
        int[] cooldown = {0, 0};    // the cooldown for the 2 abilities from the given pokemon
        int stun = 0;               // the stun status for the Neutrel pokemon
        //the actions are random
        Random randomAction = new Random();
        while(neutral2.getHP() > 0) {
            int action = randomAction.nextInt(3);
            if (action == 0) { // the pokemon attacks
                if (pokemon.getNormalAttack() != 0) {
                    neutral2.setHP(neutral2.getHP() - (pokemon.getNormalAttack()
                            - neutral2.getNormalDefense()));
                } else {
                    neutral2.setHP(neutral2.getHP() - (pokemon.getSpecialAttack()
                            - neutral2.getSpecialAttack()));
                }

                if (stun == 0) {    // checks if Neutrel 2 is stunned
                    if (neutral2.getNormalAttack() >= pokemon.getNormalDefense()) {
                        pokemon.setHP(pokemon.getHP() - (neutral2.getNormalAttack()
                                - pokemon.getNormalDefense()));
                    }
                    logger.info(pokemon.getName() + " attacks and Neutrel2 attacks!");
                } else {
                    stun = 0;
                    logger.info(pokemon.getName() + " attacks and Neutrel2 is stuned!");
                }

                FightNeutrel1.checkCooldown(pokemon, logger, neutral2, cooldown);
            } else if (action == 1) {   // the pokemon uses ability 1
                if (cooldown[0] == 0) {
                    if ((pokemon.getAbility1().getDodge() != null) && !pokemon.getAbility1().getDodge()) {
                        if (neutral2.getNormalAttack() >= pokemon.getNormalDefense()
                                && (stun == 0)) {
                            pokemon.setHP(pokemon.getHP() - (neutral2.getNormalAttack()
                                    - pokemon.getNormalDefense()));
                            logger.info(pokemon.getName() + " uses ability 1" +
                                    " and Neutrel2 attacks!");
                        } else if (stun != 0) {
                            logger.info(pokemon.getName() + " uses ability 1" +
                                    " and Neutrel2 is stuned!");
                        }
                    }
                    stun = FightNeutrel1.getStunAbility1(pokemon, logger, neutral2, cooldown, stun);
                }
            } else {    // the pokemon uses ability 2
                if (cooldown[1] == 0) {
                    if ((pokemon.getAbility2().getDodge() != null) && !pokemon.getAbility2().getDodge()) {
                        if (neutral2.getNormalAttack() >= pokemon.getNormalDefense()
                                && (stun == 0)) {
                            pokemon.setHP(pokemon.getHP() - (neutral2.getNormalAttack()
                                    - pokemon.getNormalDefense()));
                            logger.info(pokemon.getName() + " uses ability 2" +
                                    " and Neutrel2 attacks!");
                        } else if (stun != 0) {
                            logger.info(pokemon.getName() + " uses ability 2" +
                                    " and Neutrel2 is stuned!");
                        }
                        stun = FightNeutrel1.getStunAbility2(pokemon, logger, neutral2, cooldown, stun);
                    }
                }
            }
        }
        logger.info(pokemon.getName() + " wins!");
        return true;
    }
}

