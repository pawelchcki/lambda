package lambda;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Zaaz {
    String o;
    String u;

    public Zaaz withO(String o) {
        return this.o == o ? this : new Zaaz(o, this.u);
    }

    public Zaaz withU(String u) {
        return this.u == u ? this : new Zaaz(this.o, u);
    }
}
