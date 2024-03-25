package task1pkg;

public class Estimate {
    private String developer;
    private double estimate;

    public Estimate(String developer, double estimate) {
        this.developer = developer;
        this.estimate = estimate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public double getEstimate() {
        return estimate;
    }

    public void setEstimate(double estimate) {
        this.estimate = estimate;
    }
}
