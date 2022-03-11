package Game;

import Coaches.Coach1;
import Coaches.Coach2;
import Coaches.CoachesFight;
import Pokemons.Pokemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CoachesBattle {
    public static Boolean command = false;              // the command for the threads that give each pokemon's action
    public static int firstHP;                          // hit points for the first pokemon
    public static int secondHP;                         // hit points for the second pokemon
    public static int[] cooldownPokemon1 = {0, 0};      // cooldown for the 2 abilities for the first pokemon
    public static int[] cooldownPokemon2 = {0, 0};      // cooldown for the 2 abilities for the second pokemon
    public static int[] stun = {0, 0};                  // stun status for the first and second pokemon

    // this method coordinates the battle between 2 pokemons different from Neutrels
    public static void battle(Pokemon pokemonFirstCoach, Pokemon pokemonSecondCoach, Logger logger)
                                throws CloneNotSupportedException {
        firstHP = pokemonFirstCoach.getHP();
        secondHP = pokemonSecondCoach.getHP();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Coach1());
        executor.execute(new Coach2());
        command = true;     //pauses the threads
        logger.info("This duel is between the following two pokemons!");
        logger.info(pokemonFirstCoach.toString());
        logger.info(pokemonSecondCoach.toString());
        // the clones go into battle
        Pokemon pokemon1 = pokemonFirstCoach.clone();
        Pokemon pokemon2 = pokemonSecondCoach.clone();

        while((firstHP > 0) && (secondHP > 0)) {
            Pokemons.PokemonHelperClassForBattle.checkCommand();
            // the checked commands received from the threads
            int firstCommand = CoachesFight.firstCommand;
            int secondCommand = CoachesFight.secondCommand;
            switch(firstCommand) {
                case 0 -> { // pokemon 1 attacks
                    switch (secondCommand) {
                        case 0 -> { // pokemon 2 attacks
                            HelpBattle2.pokemonsAttack(logger, stun, pokemon1, pokemon2);
                            HelpBattle2.checkCooldown(logger,pokemon1, cooldownPokemon1);
                            HelpBattle2.checkCooldown(logger, pokemon2, cooldownPokemon2);
                        }
                        case 1 -> { // pokemon 2 uses ability1
                            if(stun[1] == 0)    // if it is not stunned
                                cooldownPokemon2[0] = pokemon2.getAbility1().getCoolDown();
                            HelpBattle1.abilityVsAttack(pokemon1, pokemon2, pokemon2.getAbility1(), logger,
                                    1, 0, 1);
                            if (cooldownPokemon2[1] != 0) {
                                cooldownPokemon2[1]--;
                                logger.info("Cooldown ability 2 for " + pokemon2.getName() +
                                        " is " + cooldownPokemon2[1]);
                            }
                            HelpBattle2.checkCooldown(logger, pokemon1, cooldownPokemon1);
                        }
                        case 2 -> { // pokemon 2 uses ability2
                            if(stun[1] == 0)    // if it is not stunned
                                cooldownPokemon2[1] = pokemon2.getAbility2().getCoolDown();
                            HelpBattle1.abilityVsAttack(pokemon1, pokemon2, pokemon2.getAbility2(), logger,
                                    2, 0, 1);
                            if (cooldownPokemon2[0] != 0) {
                                cooldownPokemon2[0]--;
                                logger.info("Cooldown ability 1 for " + pokemon2.getName() +
                                        " is " + cooldownPokemon2[0]);
                            }
                            HelpBattle2.checkCooldown(logger, pokemon1, cooldownPokemon1);
                        }
                    }
                }
                case 1 -> { // pokemon 1 uses ability1
                    switch (secondCommand) {
                        case 0 -> { // pokemon2 attacks
                            if(stun[0] == 0)    // if it is not stunned
                                cooldownPokemon1[0] = pokemon1.getAbility1().getCoolDown();
                            HelpBattle1.abilityVsAttack(pokemon2, pokemon1, pokemon1.getAbility1(), logger,
                                    1, 1, 0);
                            if (cooldownPokemon1[1] != 0) {
                                cooldownPokemon1[1]--;
                                logger.info("Cooldown ability 2 for " + pokemon1.getName() +
                                        " is " + cooldownPokemon1[1]);
                            }
                            HelpBattle2.checkCooldown(logger, pokemon2, cooldownPokemon2);
                        }
                        case 1 -> { // pokemon 2 uses ability1
                            if(stun[0] == 0)    // if it is not stunned
                                cooldownPokemon1[0] = pokemon1.getAbility1().getCoolDown();
                            if(stun[1] == 0)    // if it is not stunned
                                cooldownPokemon2[0] = pokemon2.getAbility1().getCoolDown();
                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility1(),
                                    pokemon2.getAbility1(), logger, 1, 1);
                            if (cooldownPokemon1[1] != 0) {
                                cooldownPokemon1[1]--;
                                logger.info("Cooldown ability 2 for " + pokemon1.getName() +
                                        " is " + cooldownPokemon1[1]);
                            }
                            if (cooldownPokemon2[1] != 0) {
                                cooldownPokemon2[1]--;
                                logger.info("Cooldown ability 2 for " + pokemon2.getName() +
                                        " is " + cooldownPokemon2[1]);
                            }
                        }
                        case 2 -> { // pokemon 2 uses ability2
                            if(stun[0] == 0)    // if it is not stunned
                                cooldownPokemon1[0] = pokemon1.getAbility1().getCoolDown();
                            if(stun[1] == 0)    // if it is not stunned
                                cooldownPokemon2[1] = pokemon2.getAbility2().getCoolDown();
                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility1(),
                                    pokemon2.getAbility2(), logger, 1, 2);
                            if (cooldownPokemon1[1] != 0) {
                                cooldownPokemon1[1]--;
                                logger.info("Cooldown ability 2 for " + pokemon1.getName() +
                                        " is " + cooldownPokemon1[1]);
                            }
                            if (cooldownPokemon2[0] != 0) {
                                cooldownPokemon2[0]--;
                                logger.info("Cooldown ability 1 for " + pokemon2.getName() +
                                        " is " + cooldownPokemon2[0]);
                            }
                        }
                    }
                }
                case 2 -> { // pokemon 1 uses ability 2
                    switch (secondCommand) {
                        case 0 -> { // pokemon2 attacks
                            if(stun[0] == 0)    // if it is not stunned
                                cooldownPokemon1[1] = pokemon1.getAbility2().getCoolDown();
                            HelpBattle1.abilityVsAttack(pokemon2, pokemon1, pokemon1.getAbility2(), logger,
                                    2, 1, 0);
                            if (cooldownPokemon1[0] != 0) {
                                cooldownPokemon1[0]--;
                                logger.info("Cooldown ability 1 for " + pokemon1.getName() +
                                        " is " + cooldownPokemon1[0]);
                            }
                            HelpBattle2.checkCooldown(logger, pokemon2, cooldownPokemon2);
                        }
                        case 1 -> { // pokemon 2 uses ability1
                            if(stun[0] == 0)    // if it is not stunned
                                cooldownPokemon1[1] = pokemon1.getAbility2().getCoolDown();
                            if(stun[1] == 0)    // if it is not stunned
                                cooldownPokemon2[0] = pokemon2.getAbility1().getCoolDown();
                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility2(),
                                    pokemon2.getAbility1(), logger, 2, 1);
                            if (cooldownPokemon1[0] != 0) {
                                cooldownPokemon1[0]--;
                                logger.info("Cooldown ability 1 for " + pokemon1.getName() +
                                        " is " + cooldownPokemon1[0]);
                            }
                            if (cooldownPokemon2[1] != 0) {
                                cooldownPokemon2[1]--;
                                logger.info("Cooldown ability 2 for " + pokemon2.getName() +
                                        " is " + cooldownPokemon2[1]);
                            }
                        }
                        case 2 -> { // pokemon 2 uses ability2
                            if(stun[0] == 0)    // if it is not stunned
                                cooldownPokemon1[1] = pokemon1.getAbility2().getCoolDown();
                            if(stun[1] == 0)    // if it is not stunned
                                cooldownPokemon2[1] = pokemon2.getAbility2().getCoolDown();
                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility2(),
                                    pokemon2.getAbility2(), logger, 2, 2);
                            if (cooldownPokemon1[0] != 0) {
                                cooldownPokemon1[0]--;
                                logger.info("Cooldown ability 1 for " + pokemon1.getName() +
                                        " is " + cooldownPokemon1[0]);
                            }
                            if (cooldownPokemon2[0] != 0) {
                                cooldownPokemon2[0]--;
                                logger.info("Cooldown ability 1 for " + pokemon2.getName() +
                                        " is " + cooldownPokemon2[0]);
                            }
                        }
                    }
                }
            }
            resumeThreads();
            command = true;
            firstHP = pokemon1.getHP();
            secondHP = pokemon2.getHP();
            logger.info(pokemon1.getName() + " has " + firstHP + " HP!");
            logger.info(pokemon2.getName() + " has " + secondHP + " HP!");
        }

        Pokemons.PokemonHelperClassForBattle.checkWinner(pokemonFirstCoach,
                pokemonSecondCoach, logger);

        executor.shutdown();
    }

    private static void resumeThreads() {
        command = false;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
