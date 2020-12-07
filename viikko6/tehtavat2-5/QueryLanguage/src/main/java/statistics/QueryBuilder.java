package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    
    ArrayList<Matcher> matchers;
    
    public QueryBuilder() {
        this.matchers = new ArrayList();
        this.matchers.add(new All());
    }
    
    public Matcher build() {
        Matcher[] matcherArray = matchers.toArray(new Matcher[matchers.size()]);
        Matcher m = new And(matcherArray);
        this.matchers = new ArrayList<>();
        this.matchers.add(new All());
        return m;
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... ms) {
        matchers.add(new Or(ms));
        return this;
    }
    
    
}
