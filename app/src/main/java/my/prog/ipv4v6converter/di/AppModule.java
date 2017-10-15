package my.prog.ipv4v6converter.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import my.prog.ipv4v6converter.other.ImplFunc;
import my.prog.ipv4v6converter.other.ImplPreference;

/**
 * Created by Ruslan on 12.09.2017.
 */
@Module
public class AppModule {

    private Context appContext;

    public AppModule(@NonNull Context context){
        appContext = context;
    }


    @Provides
    @Singleton
    Context provideContex(){
        return appContext;
    }

    @Provides
    @NonNull
    @Singleton
    public ImplPreference providePreference(Context context){
        return new ImplPreference(context);
    }

    @Provides
    @NonNull
    @Singleton
    public ImplFunc provideFunc(Context context){
        return new ImplFunc(context);
    }
}
