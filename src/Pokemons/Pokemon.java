package Pokemons;

public class Pokemon implements Cloneable{

    private String name;
    private int HP;
    private int normalAttack;
    private int specialAttack;
    private int normalDefense;
    private int specialDefense;
    private Ability ability1;
    private Ability ability2;

    @Override
    public Pokemon clone() throws CloneNotSupportedException{
        return (Pokemon) super.clone();
    }

    // Builder Pattern
    public static class PokemonBuilder {

        private final String name;
        private int HP;
        private int normalAttack;
        private int specialAttack;
        private int normalDefense;
        private int specialDefense;
        private Ability ability1;
        private Ability ability2;

        public PokemonBuilder(String name) {
            this.name = name;
        }

        public PokemonBuilder withHP(int HP) {
            this.HP = HP;

            return this;
        }

        public PokemonBuilder withNormalAttack(int normalAttack) {
            this.normalAttack = normalAttack;

            return this;
        }

        public PokemonBuilder withSpecialAttack(int specialAttack) {
            this.specialAttack = specialAttack;

            return this;
        }

        public PokemonBuilder withNormalDefense(int normalDefense) {
            this.normalDefense = normalDefense;

            return this;
        }

        public PokemonBuilder withSpecialDefense(int specialDefense) {
            this.specialDefense = specialDefense;

            return this;
        }

        public PokemonBuilder withAbility1(Ability ability1) {
            this.ability1 = ability1;

            return this;
        }

        public PokemonBuilder withAbility2(Ability ability2) {
            this.ability2 = ability2;

            return this;
        }

        public Pokemon build() {
            Pokemon pokemon = new Pokemon();
            pokemon.name = this.name;
            pokemon.HP = this.HP;
            pokemon.normalAttack = this.normalAttack;
            pokemon.specialAttack = this.specialAttack;
            pokemon.normalDefense = this.normalDefense;
            pokemon.specialDefense = this.specialDefense;
            pokemon.ability1 = this.ability1;
            pokemon.ability2 = this.ability2;

            return pokemon;
        }
    }

    protected Pokemon() {}

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getNormalAttack() {
        return normalAttack;
    }

    public void setNormalAttack(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getNormalDefense() {
        return normalDefense;
    }

    public void setNormalDefense(int normalDefense) {
        this.normalDefense = normalDefense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Ability getAbility1() {
        return ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", normalAttack=" + normalAttack +
                ", specialAttack=" + specialAttack +
                ", normalDefense=" + normalDefense +
                ", specialDefense=" + specialDefense +
                ", ability1=" + ability1.toString() +
                ", ability2=" + ability2.toString() +
                '}';
    }

    // this method is for the Neutrel pokemons
    // which do not have abilities
    public String toStringWithoutAbility() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", normalAttack=" + normalAttack +
                ", specialAttack=" + specialAttack +
                ", normalDefense=" + normalDefense +
                ", specialDefense=" + specialDefense +
                '}';
    }
}
