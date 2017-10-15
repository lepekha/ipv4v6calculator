package my.prog.ipv4v6converter.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import my.prog.ipv4v6converter.view.ImplMainActivity;

/**
 * Created by Ruslan on 12.09.2017.
 */
@Module
public class ViewModule {

    @Provides
    @Singleton
    @NonNull
    public ImplMainActivity provideImplMainActivity(){
        return new ImplMainActivity();
    }
}