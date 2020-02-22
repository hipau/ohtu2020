
package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        matcher = new All();
    }   
    
    public Matcher build() {
        Matcher buildMatcher = this.matcher;
        this.matcher = new All();
        return buildMatcher;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }    
}
