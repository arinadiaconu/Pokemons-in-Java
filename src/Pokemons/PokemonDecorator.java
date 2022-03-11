package Pokemons;

public class PokemonDecorator extends Pokemon{

    protected Pokemon decoratedPokemon;

    public PokemonDecorator(Pokemon decoratedPokemon) {
        this.decoratedPokemon = decoratedPokemon;
    }

    // this method boosts by one the winner pokemon's features
    public static void boostPokemon(Pokemon pokemon) {
        pokemon.setHP(pokemon.getHP() + 1);
        if(pokemon.getNormalAttack() != 0) {
            pokemon.setNormalAttack(pokemon.getNormalAttack() + 1);
        } else {
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 1);
        }
        pokemon.setNormalDefense(pokemon.getNormalDefense() + 1);
        pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 1);
    }

    @Override
    public String toString() {
        return "PokemonDecorator{" +
                "decoratedPokemon=" + decoratedPokemon.toString() +
                '}';
    }
}
