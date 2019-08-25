package com.ruiters.caleb.domain.demography;

public class Race {
    private String id, desc;

    private Race() {
    }

    private Race(Builder builder) {
        this.id = builder.id;
        this.desc = builder.desc;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public static class Builder {
        private String id, desc;

        public Builder raceId(String id) {
            this.id = id;
            return this;
        }

        public Builder raceDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder copy(Race race) {
            this.id = race.id;
            this.desc = race.desc;
            return this;
        }

        public Race build() { return new Race(this); }
    }

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
