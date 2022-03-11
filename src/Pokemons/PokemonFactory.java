package Pokemons;

// Factory Pattern
public class PokemonFactory {

    // Singleton Pattern
    private static PokemonFactory singletonInstance;

    public static PokemonFactory getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new PokemonFactory();
        }
        return singletonInstance;
    }

    public enum PokemonType {
        Neutrel1, Neutrel2, Pikachu, Bulbasaur,
        Charmander, Squirtle, Snorlax, Vulpix,
        Eevee, Jigglypuff, Meowth, Psyduck
    }

    // builds the pokemon with the given name
    public Pokemon returnPokemon(PokemonType pokemonType) {
        switch (pokemonType) {
            case Neutrel1 -> {
                Ability ability1 = new Ability.AbilityBuilder(0)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(0)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(0)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(0)
                        .build();
                return new Pokemon.PokemonBuilder("Neutrel1")
                        .withHP(10)
                        .withNormalAttack(3)
                        .withNormalDefense(1)
                        .withSpecialDefense(1)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Neutrel2 -> {
                Ability ability1 = new Ability.AbilityBuilder(0)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(0)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(0)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(0)
                        .build();
                return new Pokemon.PokemonBuilder("Neutrel2")
                        .withHP(20)
                        .withNormalAttack(4)
                        .withNormalDefense(1)
                        .withSpecialDefense(1)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Pikachu -> {
                Ability ability1 = new Ability.AbilityBuilder(6)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(4)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(4)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.TRUE)
                        .withCoolDown(5)
                        .build();
                return new Pokemon.PokemonBuilder("Pikachu")
                        .withHP(35)
                        .withSpecialAttack(4)
                        .withNormalDefense(2)
                        .withSpecialDefense(3)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Bulbasaur -> {
                Ability ability1 = new Ability.AbilityBuilder(6)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(4)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(5)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(3)
                        .build();
                return new Pokemon.PokemonBuilder("Bulbasaur")
                        .withHP(42)
                        .withSpecialAttack(5)
                        .withNormalDefense(3)
                        .withSpecialDefense(1)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Charmander -> {
                Ability ability1 = new Ability.AbilityBuilder(4)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(4)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(7)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(6)
                        .build();
                return new Pokemon.PokemonBuilder("Charmander")
                        .withHP(50)
                        .withNormalAttack(4)
                        .withNormalDefense(3)
                        .withSpecialDefense(2)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Squirtle -> {
                Ability ability1 = new Ability.AbilityBuilder(4)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(3)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(2)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(2)
                        .build();
                return new Pokemon.PokemonBuilder("Squirtle")
                        .withHP(60)
                        .withSpecialAttack(3)
                        .withNormalDefense(5)
                        .withSpecialDefense(5)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Snorlax -> {
                Ability ability1 = new Ability.AbilityBuilder(4)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(5)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(0)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.TRUE)
                        .withCoolDown(5)
                        .build();
                return new Pokemon.PokemonBuilder("Snorlax")
                        .withHP(62)
                        .withNormalAttack(3)
                        .withNormalDefense(6)
                        .withSpecialDefense(4)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Vulpix -> {
                Ability ability1 = new Ability.AbilityBuilder(8)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(6)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(2)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.TRUE)
                        .withCoolDown(7)
                        .build();
                return new Pokemon.PokemonBuilder("Vulpix")
                        .withHP(36)
                        .withNormalAttack(5)
                        .withNormalDefense(2)
                        .withSpecialDefense(4)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Eevee -> {
                Ability ability1 = new Ability.AbilityBuilder(5)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(3)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(3)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(3)
                        .build();
                return new Pokemon.PokemonBuilder("Eevee")
                        .withHP(39)
                        .withSpecialAttack(4)
                        .withNormalDefense(3)
                        .withSpecialDefense(3)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Jigglypuff -> {
                Ability ability1 = new Ability.AbilityBuilder(4)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(4)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(3)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(4)
                        .build();
                return new Pokemon.PokemonBuilder("Jigglypuff")
                        .withHP(34)
                        .withNormalAttack(4)
                        .withNormalDefense(2)
                        .withSpecialDefense(3)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Meowth -> {
                Ability ability1 = new Ability.AbilityBuilder(5)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.TRUE)
                        .withCoolDown(4)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(1)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.TRUE)
                        .withCoolDown(3)
                        .build();
                return new Pokemon.PokemonBuilder("Meowth")
                        .withHP(41)
                        .withNormalAttack(3)
                        .withNormalDefense(4)
                        .withSpecialDefense(2)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
            case Psyduck -> {
                Ability ability1 = new Ability.AbilityBuilder(2)
                        .withStun(Boolean.FALSE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(4)
                        .build();
                Ability ability2 = new Ability.AbilityBuilder(2)
                        .withStun(Boolean.TRUE)
                        .withDodge(Boolean.FALSE)
                        .withCoolDown(5)
                        .build();
                return new Pokemon.PokemonBuilder("Psyduck")
                        .withHP(43)
                        .withNormalAttack(3)
                        .withNormalDefense(3)
                        .withSpecialDefense(3)
                        .withAbility1(ability1)
                        .withAbility2(ability2)
                        .build();
            }
        }
        throw new IllegalArgumentException("The pokemon " + pokemonType +
                "you are trying to create does not exist.");
    }
}