package my.prog.ipv4v6converter.di;

import dagger.Module;
import dagger.Provides;
import my.prog.ipv4v6converter.entity.IP;

/**
 * Created by Ruslan on 12.09.2017.
 */
@Module
public class EntityModule {

    @Provides
    public IP provideIP(){
        return new IP("","","","","","","","");
    }
}
