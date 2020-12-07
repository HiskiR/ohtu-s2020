
package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    
    Matcher hasFewerThan;
    
    public HasFewerThan(int value, String category) {
        this.hasFewerThan = new Not(new HasAtLeast(value, category));
    }
    
    @Override
    public boolean matches(Player p) {
        return this.hasFewerThan.matches(p);
    }
}
