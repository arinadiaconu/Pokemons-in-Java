package Pokemons;

public class Ability {

    private int damage;
    private Boolean stun;
    private Boolean dodge;
    private int coolDown;

    // Builder Pattern
    public static class AbilityBuilder {

        private final int damage;
        private Boolean stun;
        private Boolean dodge;
        private int coolDown;

        public AbilityBuilder(int damage) {
            this.damage = damage;
        }

        public AbilityBuilder withStun(Boolean stun) {
            this.stun = stun;

            return this;
        }

        public AbilityBuilder withDodge(Boolean dodge) {
            this.dodge = dodge;

            return this;
        }

        public AbilityBuilder withCoolDown(int coolDown) {
            this.coolDown = coolDown;

            return this;
        }

        public Ability build() {
            Ability ability = new Ability();
            ability.damage = this.damage;
            ability.stun = this.stun;
            ability.dodge = this.dodge;
            ability.coolDown = this.coolDown;

            return ability;
        }

    }

    private Ability() {}

    public int getDamage() {
        return damage;
    }

    public Boolean getStun() {
        return stun;
    }

    public Boolean getDodge() {
        return dodge;
    }

    public int getCoolDown() {
        return coolDown;
    }

    @Override
    public String toString() {
        return "{" +
                "damage=" + damage +
                ", stun=" + stun +
                ", dodge=" + dodge +
                ", coolDown=" + coolDown +
                '}';
    }
}
