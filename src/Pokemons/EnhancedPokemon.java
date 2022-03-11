package Pokemons;

public class EnhancedPokemon {
    // this method enhances each pokemon with the given objects that boost their abilities
    public static Pokemon enhance(Pokemon pokemon, String magicToken) {
        switch (magicToken) {
            case "Scut" -> {
                pokemon.setNormalDefense(pokemon.getNormalDefense() + 2);
                pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 2);
            }
            case "Vesta" -> pokemon.setHP(pokemon.getHP() + 10);
            case "Sabiuta" -> {
                if(pokemon.getNormalAttack() != 0) {
                    pokemon.setNormalAttack(pokemon.getNormalAttack() + 3);
                }
            }
            case "Bagheta Magica" -> {
                if(pokemon.getSpecialAttack() != 0) {
                    pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 3);
                }
            }
            case "Vitamine" -> {
                pokemon.setHP(pokemon.getHP() + 2);
                if(pokemon.getNormalAttack() != 0) {
                    pokemon.setNormalAttack(pokemon.getNormalAttack() + 2);
                } else if(pokemon.getSpecialAttack() != 0) {
                    pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 2);
                }
            }
            case "Brad de Craciun" -> {
                if(pokemon.getNormalAttack() != 0) {
                    pokemon.setNormalAttack(pokemon.getNormalAttack() + 3);
                }
                pokemon.setNormalDefense(pokemon.getNormalDefense() + 1);
            }
            case "Pelerina" -> pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 3);
        }
        return pokemon;
    }
}
