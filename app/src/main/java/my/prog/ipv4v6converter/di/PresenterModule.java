package my.prog.ipv4v6converter.di;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import my.prog.ipv4v6converter.presenter.ImplTransferIP;
import my.prog.ipv4v6converter.presenter.ImplUpdateUI;

/**
 * Created by Ruslan on 12.09.2017.
 */
@Module
public class PresenterModule {


    @Provides
    @Singleton
    public ImplUpdateUI provideImplUpdateUI(){
        return new ImplUpdateUI();
    }

    @Provides
    @Singleton
    public ImplTransferIP provideImplTransferIP(){
        return new ImplTransferIP();
    }
}
