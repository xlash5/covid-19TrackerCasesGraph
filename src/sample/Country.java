package sample;

public class Country {
    String countryName;
    int totalCases;
    int newCases ;
    int totalDeaths;
    int newDeaths;
    String population;
    double mortality;
    double attackRate;

    public Country(){}

    public Country(String countryName, int totalCases,int newCases, int totalDeaths,int newDeaths, String population, double mortality, double attackRate){
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths= totalDeaths;
        this.newDeaths=newDeaths;
        this.population = population;
        this.mortality=mortality;
        this.attackRate=attackRate;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setMortality(double mortality) {
        this.mortality = mortality;
    }

    public void setAttackRate(double attackRate) {
        this.attackRate = attackRate;
    }


    public String getCountryName() {
        return countryName;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getNewCases() {
        return newCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public String getPopulation() {
        return population;
    }

    public double getMortality() {
        return mortality;
    }

    public double getAttackRate() {
        return attackRate;
    }


}
