import java.util.*;

import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        if(Author.count() == 0) {
            Fixtures.load("data.yml");
        }
    }
    
}

