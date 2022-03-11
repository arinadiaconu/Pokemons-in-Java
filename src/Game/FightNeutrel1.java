package Game;

import Pokemons.Pokemon;
import Pokemons.PokemonFactory;

import java.util.Random;
import java.util.logging.Logger;

public class FightNeutrel1 {
    // this method coordinates the fight with a Neutrel 1
    public static Boolean fight (Pokemon pokemon, Logger logger) {
        Pokemon neutral1 = PokemonFactory.getSingletonInstance().returnPokemon(PokemonFactory.PokemonType.Neutrel1);
        logger.info("This duel is between the following two pokemons!");
        logger.info(pokemon.toString());
        logger.info(neutral1.toStringWithoutAbility());
        int[] cooldown = {0, 0};    // the cooldown for the 2 abilities from the given pokemon
        int stun = 0;               // the stun status for the Neutrel pokemon
        //the actions are random
        Random randomAction = new Random();
        while(neutral1.getHP() > 0) {
            int action = randomAction.nextInt(3);
            if (action == 0) {  // the pokemon attacks
                // the pokemon cannot be stunned because Neutrel 1 does not have any abilities
                if (pokemon.getNormalAttack() != 0) {
                    neutral1.setHP(neutral1.getHP() - (pokemon.getNormalAttack()
                            - neutral1.getNormalDefense()));
                } else {
                    neutral1.setHP(neutral1.getHP() - (pokemon.getSpecialAttack()
                            - neutral1.getSpecialAttack()));
                }

                if (stun == 0) {    // if Neutrel 1 is not stunned, it can attack
                    if (neutral1.getNormalAttack() >= pokemon.getNormalDefense()) {
                        pokemon.setHP(pokemon.getHP() - (neutral1.getNormalAttack()
                                - pokemon.getNormalDefense()));
                    }
                    logger.info(pokemon.getName() + " attacks and Neutrel1 attacks!");
                } else {
                    stun = 0;
                    logger.info(pokemon.getName() + " attacks and Neutrel1 is stunned!");
                }
                checkCooldown(pokemon, logger, neutral1, cooldown);
            } else if (action == 1) { // the pokemon uses ability 1
                if (cooldown[0] == 0) { // if the cooldown for this ability is not 0, then the ability
                                        // cannot be used and it goes to the next random action
                    if ((pokemon.getAbility1().getDodge() != null) && !pokemon.getAbility1().getDodge()) {
                        if (neutral1.getNormalAttack() >= pokemon.getNormalDefense()
                                && (stun == 0)) {
                            pokemon.setHP(pokemon.getHP() - (neutral1.getNormalAttack()
                                    - pokemon.getNormalDefense()));
                            logger.info(pokemon.getName() + " uses ability 1" +
                                    " and Neutrel1 attacks!");
                        } else if (stun != 0) {
                            logger.info(pokemon.getName() + " uses ability 1" +
                                    " and Neutrel1 is stuned!");
                        }
                    }
                    stun = getStunAbility1(pokemon, logger, neutral1, cooldown, stun);
                }
            } else {    // the pokemon uses ability 2
                if (cooldown[1] == 0) {
                    if ((pokemon.getAbility2().getDodge() != null) && !pokemon.getAbility2().getDodge()) {
                        if (neutral1.getNormalAttack() >= pokemon.getNormalDefense()
                                && (stun == 0)) {
                            pokemon.setHP(pokemon.getHP() - (neutral1.getNormalAttack()
                                    - pokemon.getNormalDefense()));
                            logger.info(pokemon.getName() + " uses ability 2" +
                                    " and Neutrel1 attacks!");
                        } else if (stun != 0) {
                            logger.info(pokemon.getName() + " uses ability 2" +
                                    " and Neutrel1 is stuned!");
                        }
                        stun = getStunAbility2(pokemon, logger, neutral1, cooldown, stun);
                    }
                }
            }
        }
        logger.info(pokemon.getName() + " wins!");
        return true;
    }

    // verifies stun, attacks and verifies cooldown for ability 2
    static int getStunAbility2(Pokemon pokemon, Logger logger, Pokemon neutral1, int[] cooldown, int stun) {
        if (pokemon.getAbility2().getStun()) {
            stun = 1;
        }
        neutral1.setHP(neutral1.getHP() - pokemon.getAbility2().getDamage());
        cooldown[1] = pokemon.getAbility2().getCoolDown();

        logger.info(pokemon.toString());
        logger.info(neutral1.toStringWithoutAbility());
        logger.info("Cooldown ability 2 is " + cooldown[1]);

        if (cooldown[0] != 0) {
            cooldown[0]--;
            if(cooldown[0] != 0)
                logger.info("Cooldown ability 1 is " + cooldown[0]);
        }
        return stun;
    }

    // verifies stun, attacks and verifies cooldown for ability 1
    static int getStunAbility1(Pokemon pokemon, Logger logger, Pokemon neutral1, int[] cooldown, int stun) {
        if (pokemon.getAbility1().getStun()) {
            stun = 1;
        }
        neutral1.setHP(neutral1.getHP() - pokemon.getAbility1().getDamage());
        cooldown[0] = pokemon.getAbility1().getCoolDown();

        logger.info(pokemon.toString());
        logger.info(neutral1.toStringWithoutAbility());
        logger.info("Cooldown ability 1 is " + cooldown[0]);

        if (cooldown[1] != 0) {
            cooldown[1]--;
            if(cooldown[1] != 0)
                logger.info("Cooldown ability 2 is " + cooldown[1]);
        }
        return stun;
    }

    // checks cooldown for the 2 abilities
    static void checkCooldown(Pokemon pokemon, Logger logger, Pokemon neutral, int[] cooldown) {
        logger.info(pokemon.toString());
        logger.info(neutral.toStringWithoutAbility());

        if (cooldown[0] != 0) {
            cooldown[0]--;
            if(cooldown[0] != 0)
                logger.info("Cooldown ability 1 is " + cooldown[0]);
        }
        if (cooldown[1] != 0) {
            cooldown[1]--;
            if(cooldown[1] != 0)
                logger.info("Cooldown ability 2 is " + cooldown[1]);
        }
    }
}
